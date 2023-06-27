package model;

public class ItemVenda {

	public ItemVenda(int idVenda, int idProcedimento, float valor, int quantidade) {
		this.IdVenda = idVenda;
		this.IdProcedimento = idProcedimento;
		this.Valor = valor;
		this.quantidade = quantidade;
	}

	public ItemVenda() {
	}

	public int IdVenda;
	public int IdProcedimento;
	public float Valor;
	public int quantidade;
}
