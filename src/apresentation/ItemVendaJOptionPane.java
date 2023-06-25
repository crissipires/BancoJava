package apresentation;

import javax.swing.JOptionPane;

import model.Banco;
import model.ItemVenda;
import model.Venda;
import repository.ItemVendaRepository;

public class ItemVendaJOptionPane {
	
	private final ItemVendaRepository _itemVendaRepository;
	private final Banco _banco;
	
	public ItemVendaJOptionPane() {
		_itemVendaRepository = new ItemVendaRepository();
		_banco = new Banco();
	}
	
	public void AdicionarItemVenda() {
		ItemVenda itemVenda = Criar();
		 _itemVendaRepository.InserirItemVenda(_banco.getConexao(), itemVenda);
	}

	public void ListarItensVendas() {
		 _itemVendaRepository.ListarItensVenda(_banco.getConexao());
	}

	public void EditarItemVenda() {
		ItemVenda itemVenda = Atualizar();
		 _itemVendaRepository.EditarItemVenda(_banco.getConexao(), itemVenda);
	}

	public void RemoverItemVenda() {
		int id = Remover();
	    _itemVendaRepository.RemoverItemVenda(_banco.getConexao(), id);
	}
	
	public static ItemVenda Criar() {
		int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código da venda:"));
		int codigoProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código do procedimento:"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o valor da venda:"));
		
		return new ItemVenda(codigoVenda, codigoProcedimento, valor);
	}
	
	public static ItemVenda Atualizar() {
		int codigoItemVenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código da venda:"));
		int codigoProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código do procedimento:"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o valor da venda:"));
		
		return new ItemVenda(codigoItemVenda,codigoProcedimento, valor);	
	}
	
	public static int Remover() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do item da venda para remover"));
		return id;
	}
	
	
}