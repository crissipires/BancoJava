package main;

public class Cliente {
	
	public Cliente(String nome, String cpf, String dataNascimento, String numeroTelefone, String email, int idEndereco) {
        this.Nome = nome;
        this.Cpf = cpf;
        this.DataNascimento = dataNascimento;
        this.NumeroTelefone = numeroTelefone;
        this.Email = email;
        this.IdEndereco = idEndereco;
    }
	
	public Cliente(int id, String nome, String cpf, String dataNascimento, String numeroTelefone, String email, int idEndereco) {
        this.Id = id;
		this.Nome = nome;
        this.Cpf = cpf;
        this.DataNascimento = dataNascimento;
        this.NumeroTelefone = numeroTelefone;
        this.Email = email;
        this.IdEndereco = idEndereco;
    }
	
	public Cliente() {
		
	}
	
	public Integer Id;
	public String Nome;
	public String Cpf;
	public String DataNascimento;
	public String NumeroTelefone;
	public String Email;
	public int IdEndereco;
}