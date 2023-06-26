package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioRepository {
	private Statement st;
	
	public List<Funcionario> listar(Connection conexao) {
		String query = "SELECT * FROM funcionario";	
		List<Funcionario> lista = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
						
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();				
				funcionario.id = resultSet.getInt("idFuncionario");
				funcionario.nome = resultSet.getString("nome");
				funcionario.cpf = resultSet.getString("cpf");
				funcionario.dataNascimento = resultSet.getString("dataNascimento");
				funcionario.telefone = resultSet.getString("telefone");
				funcionario.salario = resultSet.getFloat("salario");
				funcionario.idCargo = resultSet.getInt("Cargo_idCargo1");
				funcionario.idEndereco = resultSet.getInt("Endereco_idEndereco");
				
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
