package apresentation;

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

	public void AdicionarVenda() {
		Venda venda = Criar();
		_vendaRepository.inserirVenda(_banco.getConexao(), venda);
	}

	public void ListarVendas() {
		_vendaRepository.listarVendas(_banco.getConexao());
	}

	public void EditarVenda() {
		Venda venda = Atualizar();
		_vendaRepository.editarVenda(_banco.getConexao(), venda);
	}

	public void RemoverVenda() {
		int id = Remover();
		// _vendaRepository.(_banco.getConexao(), id);
	}
	
	private Venda Criar() {
		int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do funcionário:"));
		int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do cliente:"));
		int codigoAgenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código da agenda:"));
		
		return new Venda(codigoFuncionario, codigoCliente, codigoAgenda);
	}
	
	private Venda Atualizar() {
		int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código da Venda:"));
		int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do funcionário:"));
		int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código do cliente:"));
		int codigoAgenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Venda\n\nInforme o Código da agenda:"));
		
		return new Venda(codigoVenda,codigoFuncionario, codigoCliente, codigoAgenda);			
	}
	
	private int Remover() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da venda para remover"));
		return id;
	}
}
