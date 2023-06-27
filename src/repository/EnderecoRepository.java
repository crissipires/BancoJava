package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import view.ViewEndereco;


public class EnderecoRepository {
	private Statement st;

	public List<ViewEndereco> listar(Connection conexao) {
		String query = "SELECT * FROM viewEndereco";
		List<ViewEndereco> lista = new ArrayList<>();

		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);

			while (resultSet.next()) {
				ViewEndereco endereco = new ViewEndereco();
				endereco.idEndereco = resultSet.getInt("idEndereco");
				endereco.logradouro = resultSet.getString("logradouro");
				endereco.nomeBairro = resultSet.getString("nomeBairro");
				endereco.nomeCidade = resultSet.getString("nomeCidade");
				endereco.nomeEstado = resultSet.getString("nomeEstado");
				endereco.nomePais = resultSet.getString("nomePais");

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
