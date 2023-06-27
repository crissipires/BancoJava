package apresentation;

import java.util.List;

import model.Banco;
import repository.AgendaRepository;
import view.AgendaView;

public class AgendaJOptionPane {
	private final AgendaRepository _agendaRepository;
	private final Banco _banco;
	
	public AgendaJOptionPane() {
		_agendaRepository = new AgendaRepository();
		_banco = new Banco();
	}
	
	public void Listar() {
		List<AgendaView> listaAgenda = _agendaRepository.listar(_banco.getConexao());
		System.out.println("------- Agenda -------");
		for (AgendaView agenda : listaAgenda) {
			   System.out.println("Id da agenda: " + agenda.id);
			   System.out.println("Data de Atendimento: " + agenda.dataAtendimento);
			   System.out.println("Cliente: " + agenda.nomeCliente);
			   System.out.println("Funcionário: " + agenda.nomeFuncionario);
			   System.out.println("-----------------------");
		}
	}
}
