package model;

public class ItemVenda {

	public ItemVenda(int idVenda, int idProcedimento, float valor) {
		this.IdVenda = idVenda;
		this.IdProcedimento = idProcedimento;
		this.Valor = valor;
	}

	public ItemVenda() {
	}

	public int IdVenda;
	public int IdProcedimento;
	public float Valor;
}
