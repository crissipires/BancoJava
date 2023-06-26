package apresentation;

import java.util.List;

import javax.swing.JOptionPane;

import model.Banco;
import model.Venda;
import repository.VendaRepository;

public class VendaJOPtionPane {

	private final VendaRepository _vendaRepository;
	private final Banco _banco;

	public VendaJOPtionPane() {
		_vendaRepository = new VendaRepository();
		_banco = new Banco();
	}

	public void Adicionar() {
		Venda venda = CriarVenda();
		_vendaRepository.Inserir(_banco.getConexao(), venda);
	}

	public void Remover() {
		int id = RemoverVenda();
		// _vendaRepository.Remover(_banco.getConexao(), id);
	}

	public void Listar() {
		List<Venda> listaVendas = _vendaRepository.Listar(_banco.getConexao());
		for (Venda venda : listaVendas) {
			System.out.println("Id da Venda: " + venda.Id);
			System.out.println("Id do Funcionario: " + venda.IdFuncionario);
			System.out.println("Id do Cliente: " + venda.IdCliente);
			System.out.println("Id da Agenda: " + venda.IdAgenda);
			System.out.println("---------------------------------");
		}
	}

	public void Editar() {
		Venda venda = AtualizarVenda();
		_vendaRepository.Editar(_banco.getConexao(), venda);
	}

	private Venda CriarVenda() {
		int idFuncionario = Integer
				.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o IdFuncionario:"));
		int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o IdCliente:"));
		int idAgenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o IdAgenda:"));

		return new Venda(idFuncionario, idCliente, idAgenda);
	}

	private int RemoverVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente para remover"));
		return id;
	}

	private Venda AtualizarVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Id:"));
		int idFuncionario = Integer
				.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o IdFuncionario:"));
		int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o IdCliente:"));
		int idAgenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o IdAgenda:"));

		return new Venda(id, idFuncionario, idCliente, idAgenda);
	}
}
