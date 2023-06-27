package apresentation;

import java.util.List;

import model.Banco;
import repository.EnderecoRepository;
import model.Endereco;

public class EnderecoJOptionPane {
	private final EnderecoRepository _enderecoRepository;
	private final Banco _banco;

	public EnderecoJOptionPane() {
	    _enderecoRepository = new EnderecoRepository();
	    _banco = new Banco();
	}

	public void Listar() {
	    List<Endereco> listaEnderecos = _enderecoRepository.listar(_banco.getConexao());
	    for (Endereco endereco : listaEnderecos) {
	        System.out.println("Id do Endereco: " + endereco.idendereco);
	        System.out.println("Logradouro: " + endereco.logradouro);
	        System.out.println("Complemento: " + endereco.complemento);
	        System.out.println("Id do Bairro: " + endereco.idbairro);
	        System.out.println("---------------------------------");
	    }
	}
}
