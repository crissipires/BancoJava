package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.ItemVenda;
import model.Venda;
import view.ViewVenda;

public class VendaRepository {
	
	private Statement st;
	
	
	public List<ViewVenda> Listar(Connection conexao) {
		String query = "SELECT * FROM viewvenda";
		List<ViewVenda> lista = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				ViewVenda vwVenda = new ViewVenda();
				vwVenda.idVenda = resultSet.getInt("idVenda");
				vwVenda.dataAtendimento = resultSet.getTimestamp("dataAtendimento");
				vwVenda.nomeCliente = resultSet.getString("nomeCliente");
				vwVenda.nomeFuncionario = resultSet.getString("nomeFuncionario");
				vwVenda.observacoes = resultSet.getString("observacoes");
				
				lista.add(vwVenda);
			} 
			st.close();
			resultSet.close();	
		} catch (SQLException e) {
			System.out.println("Erro ao listar vendas: " + e.getMessage());
		}
		
		return lista;
	}
	
	public void Inserir(Connection conexao, Venda venda) {
		if (venda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "INSERT INTO venda (Funcionario_idFuncionario, Cliente_idCliente, Agenda_idAgenda, observacoes)" +
				" VALUES (?, ?, ?, ?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, venda.IdFuncionario);
			ps.setInt(2, venda.IdCliente);
			ps.setInt(3, venda.IdAgenda);
			ps.setString(4, venda.observacoes);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Venda inserida com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir venda: " + e.getMessage());
		}
	}
	
	public void Editar(Connection conexao, Venda venda) {
		if (venda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE venda SET Funcionario_idFuncionario = ?, Cliente_idCliente = ?, Agenda_idAgenda = ?, observacoes = ? "
				+ "WHERE idVenda = ?";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, venda.IdFuncionario);
			ps.setInt(2, venda.IdCliente);
			ps.setInt(3, venda.IdAgenda);
			ps.setString(4, venda.observacoes);
			ps.setInt(5, venda.Id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao editar venda: " + e.getMessage());
		}
	}
	
	
	

}











