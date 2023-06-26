package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Cliente;
import model.ItemVenda;

public class ClienteRepository  {
	
	private Statement st;	

	public List<Cliente> Listar(Connection conexao) {
		String query = "SELECT * FROM cliente";	
		List<Cliente> lista = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
						
			while (resultSet.next()) {
				Cliente cliente = new Cliente();				
				cliente.Id = resultSet.getInt("idCliente");
				cliente.Nome = resultSet.getString("nome");
				cliente.Cpf = resultSet.getString("cpf");
				cliente.DataNascimento = resultSet.getString("dataNascimento");
				cliente.Email = resultSet.getString("email");
				cliente.NumeroTelefone = resultSet.getString("numeroTelefone");
				
			    lista.add(cliente);
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		
		return lista;
	}
	
	public void Inserir(Connection conexao, Cliente cliente) {
		if(cliente == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "INSERT INTO cliente (nome, cpf, dataNascimento, numeroTelefone, email, Endereco_idEndereco)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1, cliente.Nome);
			ps.setString(2, cliente.Cpf);
			ps.setString(3, cliente.DataNascimento);
			ps.setString(4, cliente.NumeroTelefone);
			ps.setString(5, cliente.Email);
			ps.setInt(6, cliente.IdEndereco); 
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Cliente de nome: " + cliente.Nome + " inserido com sucesso!");
		} catch (SQLException e) {			
			System.out.println("Erro ao inserir cliente " + e.getMessage());
		}
	}
	
	public void Editar(Connection conexao, Cliente cliente) {
		if(cliente == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE cliente SET nome = ?, cpf = ?, dataNascimento = ?, numeroTelefone = ?, email = ?, Endereco_idEndereco = ?"
				+ " WHERE idCliente = ?";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1, cliente.Nome);
			ps.setString(2, cliente.Cpf);
			ps.setString(3, cliente.DataNascimento);
			ps.setString(4, cliente.NumeroTelefone);
			ps.setString(5, cliente.Email);
			ps.setInt(6, cliente.IdEndereco);
			ps.setInt(7, cliente.Id);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
		} catch (SQLException e) {			
			System.out.println("Erro ao alterar cliente: " + e.getMessage());
		}	
	}
	
	public void Remover(Connection conexao, int id) {
		if(id == 0) {
			return;
		}
		
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		
		String queryValidarCliente = "SELECT COUNT(*) FROM venda WHERE Cliente_idCliente = ?";
		
		try {
			ps = conexao.prepareStatement(queryValidarCliente);
			ps.setInt(1, id);
			resultSet = ps.executeQuery();
			
			if(resultSet.next() && resultSet.getInt(1) > 0) {
				JOptionPane.showMessageDialog(null, "Não é possível remover um cliente que está presente em uma venda");
				return;
			}
			
			 ps = null;
		} catch (SQLException e ) {
			System.out.println("Erro ao remover cliente " + e.getMessage());
		}
		
		String query = "DELETE FROM cliente WHERE idCliente = ?";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			resultSet.close();
			
			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
		} catch (SQLException e) {			
			System.out.println("Erro ao remover cliente: " + e.getMessage());
		} 
	}
}