package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ItemVenda;

public class ItemVendaRepository {
	
	private Statement st;
	
	public void listarItensVenda(Connection conexao) {
		String query = "SELECT * FROM itensVenda";
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				ItemVenda itemVenda = new ItemVenda();
				itemVenda.idVenda = resultSet.getInt("idVenda");
				itemVenda.Procedimento_idProcedimento = resultSet.getInt("Procedimento_idProcedimento");
				itemVenda.valor = resultSet.getFloat("valor");
				
				//mostrar
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar item vendas: " + e.getMessage());
		}
	}
	
	public void editarItemVenda(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE itensVenda SET Procedimento_idProcedimento = ?, valor = ?" +
				"WHERE idItemVenda";
	}
	
}
