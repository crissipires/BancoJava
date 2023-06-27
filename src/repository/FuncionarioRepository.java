package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import view.ViewFuncionario;

public class FuncionarioRepository {
	private Statement st;
	
	public List<ViewFuncionario> listar(Connection conexao) {
		String query = "SELECT * FROM viewFuncionario";	
		List<ViewFuncionario> lista = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
						
			while (resultSet.next()) {
				ViewFuncionario funcionario = new ViewFuncionario();				
				funcionario.idFuncionario = resultSet.getInt("idFuncionario");
				funcionario.nomeFuncionario = resultSet.getString("nomeFuncionario");
				funcionario.descricaoCargo = resultSet.getString("descricaoCargo");
				
			    lista.add(funcionario);
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		
		return lista;
	}
}
