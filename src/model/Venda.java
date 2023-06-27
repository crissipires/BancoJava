package model;

public class Venda {
	
	public Venda(int id, int idFuncionario, int idCliente, int idAgenda, String observacoes) {
		this.Id = id;
		this.IdFuncionario = idFuncionario;
		this.IdCliente = idCliente;
		this.IdAgenda = idAgenda;
		this.observacoes = observacoes;
	}
	
	public Venda(int idFuncionario, int idCliente, int idAgenda, String obs) {
		this.IdFuncionario = idFuncionario;
		this.IdCliente = idCliente;
		this.IdAgenda = idAgenda;
		this.observacoes = obs;
	}

	public Venda() {

	}

	public int Id;
	public int IdFuncionario;
	public int IdCliente;
	public int IdAgenda;
	public String observacoes;

}
