package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClienteRepository extends JFrame {
	
	private Statement st;
	private JFrame tela = new JFrame();
	private JTextArea txtAreaResultado = new JTextArea();
	
	public ClienteRepository() {
		tela.setSize(350, 400);
		tela.setTitle("Estética - CRUD");
		tela.setLayout(null);
		tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tela.setVisible(true);
		txtAreaResultado.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(txtAreaResultado);
		scroll.setBounds(10, 10, 300, 400);
		
		tela.add(scroll);
	}
	
	public void listaClientes(Connection conexao) {
		String query = "SELECT * FROM cliente";	

		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
						
			while (resultSet.next()) {
				
				Cliente cliente = new Cliente();				
				cliente.id = resultSet.getInt("idCliente");
				cliente.nome = resultSet.getString("nome");
				cliente.cpf = resultSet.getString("cpf");
				cliente.dataNascimento = resultSet.getString("dataNascimento");
				cliente.email = resultSet.getString("email");
				cliente.numeroTelefone = resultSet.getString("numeroTelefone");
				
				txtAreaResultado.append(
						"Nome: " + cliente.nome +
						"\nCPF: " + cliente.cpf +
						"\nData de Nascimento: " + cliente.dataNascimento +
						"\nE-mail: " + cliente.email +
						"\nNúmero do telefone: " + cliente.numeroTelefone + "\n\n"
					);
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void insereCliente(Connection conexao, Cliente cliente) {
		PreparedStatement ps = null;
		String query = "INSERT INTO cliente (nome, cpf, dataNascimento, numeroTelefone, email, Endereco_idEndereco)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1, cliente.nome);
			ps.setString(2, cliente.cpf);
			ps.setString(3, cliente.dataNascimento);
			ps.setString(4, cliente.numeroTelefone);
			ps.setString(5, cliente.email);
			ps.setInt(6, 1); //fazer o usuario escolher um endereco que ja ta cadastrado no banco
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Cliente de nome: " + cliente.nome + " inserido com sucesso!");
		} catch (SQLException e) {			
			System.out.println("Erro ao inserir cliente " + e.getMessage());
		}
	}
	
	public void editaCliente(Connection conexao) {
		PreparedStatement ps = null;
		String query = "UPDATE cliente SET nome = ?, cpf = ?, dataNascimento = ?, numeroTelefone = ?, email = ?, Endereco_idEndereco = ?"
				+ " WHERE idCliente = ?";
		
		String nome = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o nome:");
		String cpf = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o CPF:");
		String dataNascimento = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme a data de nascimento:");
		String email = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o e-mail:");
		String numeroTelefone = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o número de telefone:");
		int idEndereco = 2; //arrumar isso pro usuario escolher o endereco
		int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o id do cliente que deseja alterar:"));
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, dataNascimento);
			ps.setString(4, numeroTelefone);
			ps.setString(5, email);
			ps.setInt(6, idEndereco);
			ps.setInt(7, idCliente);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
		} catch (SQLException e) {			
			System.out.println("Erro ao alterar cliente: " + e.getMessage());
		}	
	}
	
	public void removeCliente(Connection conexao) {
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente para remover"));
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

	public void findByName(Connection conexao) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM cliente WHERE nome LIKE ?";
		String nome = "%" + JOptionPane.showInputDialog("Informe o nome: ") + "%";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1, nome);
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();				
				cliente.nome = resultSet.getString("nome");
				cliente.email = resultSet.getString("email");
				cliente.numeroTelefone = resultSet.getString("numeroTelefone");
				cliente.cpf = resultSet.getString("cpf");
				cliente.dataNascimento = resultSet.getString("dataNascimento");

				JOptionPane.showMessageDialog(null,
						"Busca por nome: " + cliente.nome +
						"\n\nCPF: " + cliente.cpf +
						"\nNúmero de telefone: " + cliente.numeroTelefone +
						"\nData de nascimento: " + cliente.dataNascimento +
						"\nE-mail: " + cliente.email
					);
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {			
			System.out.println("Erro ao buscar cliente por nome " + e.getMessage());
		}
	}	
}