package apresentation;

import java.util.List;

import javax.swing.JOptionPane;

import model.Banco;
import model.Cliente;
import model.ItemVenda;
import model.Venda;
import repository.ClienteRepository;
import repository.ItemVendaRepository;

public class ItemVendaJOPtionPane {
	private final ItemVendaRepository _itemVendaRepository;
	private final Banco _banco;

	public ItemVendaJOPtionPane() {
		_itemVendaRepository = new ItemVendaRepository();
		_banco = new Banco();
	}

	public void Adicionar() {
		ItemVenda itemVenda = CriarItemVenda();
		_itemVendaRepository.Inserir(_banco.getConexao(), itemVenda);
	}

	public void Remover() {
		int id = RemoverItemVenda();
		_itemVendaRepository.Remover(_banco.getConexao(), id);
	}

	public void Listar() {
		List<ItemVenda> listaItemVenda = _itemVendaRepository.Listar(_banco.getConexao());
		for (ItemVenda venda : listaItemVenda) {
			System.out.println("Id da Venda: " + venda.IdVenda);
			System.out.println("Id do procedimento: " + venda.IdProcedimento);
			System.out.println("Valor: " + venda.Valor);
			System.out.println("---------------------------------");
		}
	}

	public void Editar() {
		ItemVenda itemVenda = AtualizarItemVenda();
		_itemVendaRepository.Editar(_banco.getConexao(), itemVenda);
	}

	private ItemVenda CriarItemVenda() {
		int idVenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o IdVenda:"));
		int idProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o IdProcedimento:"));
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Valor:"));

		return new ItemVenda(idVenda, idProcedimento, valor);
	}

	private int RemoverItemVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da venda para remover:"));
		return id;
	}

	private ItemVenda AtualizarItemVenda() {
		int idVenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o IdVenda:"));
		int idProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o IdProcedimento:"));
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o Valor:"));

		return new ItemVenda(idVenda, idProcedimento, valor);
	}
}
