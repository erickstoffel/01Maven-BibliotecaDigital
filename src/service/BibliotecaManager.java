package service;

import dominio.*;

public class BibliotecaManager {
	private Repositorio<Livro> livros;
	private Repositorio<Cliente> clientes;
	
	 public BibliotecaManager() {
		 this.livros = new Repositorio<>();
		 this.clientes = new Repositorio<>();
	 }
	
	public void retirarLivro(Livro livro, Cliente cliente) throws BibliotecaException {
		if(!livro.isDisponivel()) {
			throw new BibliotecaException("O livro não esta disponível!");
		}
		int LIMITE_LIVROS = 3;
		if(cliente.getLivrosRetirados().size() >= LIMITE_LIVROS) {
			throw new BibliotecaException("O cliente já atingiu o limite de "+LIMITE_LIVROS+" livros retirados!");
		}
		livro.setDisponivel(false);
		cliente.getLivrosRetirados().add(livro);
	}
	
	public void devolverLivro(Livro livro, Cliente cliente) throws BibliotecaException{
		if(livro.isDisponivel()) {
			throw new BibliotecaException("O livro está disponível, portanto não é possível devolvê-lo!");
		}
		
		if (!cliente.getLivrosRetirados().contains(livro)) {
		    throw new BibliotecaException("Esse cliente não retirou esse livro!");
		}
		
		livro.setDisponivel(true);
		cliente.getLivrosRetirados().remove(livro);
	}
	
	public void adicionarCliente(Cliente c) {
		clientes.adicionar(c);
	}
	
	public void adicionarLivro(Livro l) {
		livros.adicionar(l);
	}

	public void salvarJSON() {
		
	}

	public Repositorio<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Repositorio<Livro> livros) {
		this.livros = livros;
	}

	public Repositorio<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Repositorio<Cliente> clientes) {
		this.clientes = clientes;
	}	
}
