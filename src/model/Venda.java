package model;

public class Venda {
	
	public Venda(int idFuncionario, int idCliente, int idAgenda){
	        this.IdFuncionario = idFuncionario;
	        this.IdCliente = idCliente;
	        this.IdAgenda = idAgenda;
	}
	
	public Venda(int idVenda,int idFuncionario, int idCliente, int idAgenda){
		this.Id = idVenda;
        this.IdFuncionario = idFuncionario;
        this.IdCliente = idCliente;
        this.IdAgenda = idAgenda;
	}

	public Venda(){

	}

	
	
	public int Id;
	public int IdFuncionario; //podemos setar um funcionario padrao pra todos os atendimentos
	public int IdCliente;
	public int IdAgenda; //o horario nao tem como fugir, temos que cadastrar
}
