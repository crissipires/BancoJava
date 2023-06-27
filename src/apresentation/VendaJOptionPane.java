package apresentation;

import java.util.List;

import javax.swing.JOptionPane;

import model.Banco;
import model.Venda;
import repository.VendaRepository;
import view.ViewVenda;

public class VendaJOptionPane {
	private final VendaRepository _vendaRepository;
	private final Banco _banco;
	
	public VendaJOptionPane() {
		_vendaRepository = new VendaRepository();
		_banco = new Banco();
	}

	public void Adicionar() {
		Venda venda = Criar();
		_vendaRepository.Inserir(_banco.getConexao(), venda);
	}

	public void Listar() {
		List<ViewVenda> listaVendas = _vendaRepository.Listar(_banco.getConexao());
		System.out.println("------- VENDAS -------");
		for (ViewVenda venda : listaVendas) {
			System.out.println("Id da Venda: " + venda.idVenda);
			System.out.println("Nome do Funcionario: " + venda.nomeFuncionario);
			System.out.println("Nome do Cliente: " + venda.nomeCliente);
			System.out.println("Data do agendamento: " + venda.dataAtendimento);
			System.out.println("Observações: " + venda.observacoes);
			System.out.println("---------------------------------");
		}
	}

	public void Editar() {
		Venda venda = Atualizar();
		_vendaRepository.Editar(_banco.getConexao(), venda);
	}
	
	private Venda Criar() {
		int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do funcionário:"));
		int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do cliente:"));
		int codigoAgenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código da agenda:"));
		String obs = JOptionPane.showInputDialog("Cadastro de Venda\n\nObservações:");
		
		return new Venda(codigoFuncionario, codigoCliente, codigoAgenda, obs);
	}
	
	private Venda Atualizar() {
		int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código da Venda:"));
		int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código do funcionário:"));
		int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código do cliente:"));
		int codigoAgenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código da agenda:"));
		String obs = JOptionPane.showInputDialog("Edição de Venda\n\nObservações:");
		
		return new Venda(codigoVenda,codigoFuncionario, codigoCliente, codigoAgenda, obs);			
	}
	
	private int RemoverVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da venda para remover"));
		return id;
	}
}
