package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;


public class EnderecoRepository {
	private Statement st;

	public List<Endereco> listar(Connection conexao) {
		String query = "SELECT * FROM endereco";
		List<Endereco> lista = new ArrayList<>();

		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);

			while (resultSet.next()) {
				Endereco endereco = new Endereco();
				endereco.idendereco = resultSet.getInt("idEndereco");
				endereco.logradouro = resultSet.getString("logradouro");
				endereco.complemento = resultSet.getString("complemento");
				endereco.idbairro = resultSet.getInt("Bairro_idBairro");

				lista.add(endereco);
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
}
