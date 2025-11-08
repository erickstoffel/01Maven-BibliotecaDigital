package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente extends Pessoa {
	private final String ID = UUID.randomUUID().toString();
	private List<Livro> livrosRetirados = new ArrayList<Livro>();
	
	public Cliente(String nome, int idade, String cpf){
		super(nome, idade, cpf);
	}
	
	public void listarLivrosRetirados() {
		for (Livro livro : livrosRetirados) {
			System.out.println(livro.getNome());
		}
	}
	
	
	public String getId() {
		return ID;
	}

	public List<Livro> getLivrosRetirados() {
		return livrosRetirados;
	}

	public void setLivrosRetirados(List<Livro> livrosRetirados) {
		this.livrosRetirados = livrosRetirados;
	}
}
