package model;

public class Endereco {
	public Endereco() {
		
	}
	
	public Endereco(int idendereco, String logradouro, String complemento, int idbairro) {
		this.idendereco = idendereco;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.idbairro = idbairro;
	}

	public int idendereco;
	public String logradouro;
	public String complemento;
	public int idbairro;

}
