package model;

public class Funcionario {
	public Funcionario() {

	}

	public Funcionario(int id, String nome, String cpf, String telefone, String dataNascimento, float salario, int cargoId, int enderecoId) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.idCargo = cargoId;
		this.idEndereco = enderecoId;
	}

	public int id;
	public String nome;
	public String cpf;
	public String telefone;
	public String dataNascimento;
	public float salario;
	public int idCargo;
	public int idEndereco;

}
