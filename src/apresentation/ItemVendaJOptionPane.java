package apresentation;

import java.util.List;

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
	
	public void Adicionar() {
		ItemVenda itemVenda = CriarItemVenda();
		 _itemVendaRepository.Inserir(_banco.getConexao(), itemVenda);
	}

	public void Listar() {
		 List<ItemVenda> listaVendas = _itemVendaRepository.Listar(_banco.getConexao());
		 for(ItemVenda item : listaVendas) {
			 System.out.println("Id da venda: " + item.IdVenda);
		     System.out.println("Id do procedimento: " + item.IdProcedimento);
		     System.out.println("Valor: " + item.Valor);
		     System.out.println("---------------------------------");
		 }
	}

	public void Editar() {
		ItemVenda itemVenda = AtualizarItemVenda();
		 _itemVendaRepository.Editar(_banco.getConexao(), itemVenda);
	}

	public void Remover() {
		int id = RemoverItemVenda();
	    _itemVendaRepository.Remover(_banco.getConexao(), id);
	}
	
	public static ItemVenda CriarItemVenda() {
		int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código da venda:"));
		int codigoProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código do procedimento:"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o valor da venda:"));
		
		return new ItemVenda(codigoVenda, codigoProcedimento, valor);
	}
	
	public static ItemVenda AtualizarItemVenda() {
		int codigoItemVenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o Código da venda:"));
		int codigoProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o Código do procedimento:"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o valor da venda:"));
		
		return new ItemVenda(codigoItemVenda,codigoProcedimento, valor);	
	}
	
	public static int RemoverItemVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do item da venda para remover"));
		return id;
	}
	
	
}