package apresentation;

import java.util.List;

import javax.swing.JOptionPane;

import model.Banco;
import model.Venda;
import repository.VendaRepository;

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
		List<Venda> listaVendas = _vendaRepository.Listar(_banco.getConexao());
		for (Venda venda : listaVendas) {
			System.out.println("Id: " + venda.Id);
			System.out.println("Id do Funcionario: " + venda.IdFuncionario);
			System.out.println("Id do Cliente: " + venda.IdCliente);
			System.out.println("Id da Agenda: " + venda.IdAgenda);
			 System.out.println("---------------------------------");
		}
	}

	public void Editar() {
		Venda venda = Atualizar();
		_vendaRepository.Editar(_banco.getConexao(), venda);
	}

	public void Remover() {
		int id = RemoverVenda();
		// _vendaRepository.(_banco.getConexao(), id);
	}
	
	private Venda Criar() {
		int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do funcionário:"));
		int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do cliente:"));
		int codigoAgenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código da agenda:"));
		
		return new Venda(codigoFuncionario, codigoCliente, codigoAgenda);
	}
	
	private Venda Atualizar() {
		int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código da Venda:"));
		int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código do funcionário:"));
		int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código do cliente:"));
		int codigoAgenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de Venda\n\nInforme o Código da agenda:"));
		
		return new Venda(codigoVenda,codigoFuncionario, codigoCliente, codigoAgenda);			
	}
	
	private int RemoverVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da venda para remover"));
		return id;
	}
}
