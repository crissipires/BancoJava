package model;

public class Venda {
	
	public Venda(int id, int idFuncionario, int idCliente, int idAgenda) {
		this.Id = id;
		this.IdFuncionario = idFuncionario;
		this.IdCliente = idCliente;
		this.IdAgenda = idAgenda;
	}
	
	public Venda(int idFuncionario, int idCliente, int idAgenda) {
		this.IdFuncionario = idFuncionario;
		this.IdCliente = idCliente;
		this.IdAgenda = idAgenda;
	}

	public Venda() {

	}

	public int Id;
	public int IdFuncionario;
	public int IdCliente;
	public int IdAgenda;

}
