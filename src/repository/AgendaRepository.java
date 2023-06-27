package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import view.AgendaView;

public class AgendaRepository {
	
	private Statement st;

	public List<AgendaView> listar(Connection conexao) {
		String query = "SELECT * FROM viewAgenda";
		List<AgendaView> lista = new ArrayList<>();

		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);

			while (resultSet.next()) {
                 AgendaView agenda = new AgendaView();
				 agenda.id = resultSet.getInt("idagenda");
				 agenda.dataAtendimento = resultSet.getString("dataatendimento");
				 agenda.idCliente = resultSet.getInt("Cliente_idcliente");
				 agenda.idFuncionario = resultSet.getInt("funcionario_idfuncionario");
				 agenda.nomeCliente = resultSet.getString("nome_cliente");
				 agenda.nomeFuncionario = resultSet.getString("nome_funcionario");

				lista.add(agenda);
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
}
