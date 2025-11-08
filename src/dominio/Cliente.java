package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	private int id;
	private List<Livro> livrosRetirados = new ArrayList<Livro>();
	
	public Cliente(String nome, int idade, String cpf, int id) {
		super(nome, idade, cpf);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Livro> getLivrosRetirados() {
		return livrosRetirados;
	}

	public void setLivrosRetirados(List<Livro> livrosRetirados) {
		this.livrosRetirados = livrosRetirados;
	}
}
