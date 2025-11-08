package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dominio.*;


public class BibliotecaManager {
	private Repositorio<Livro> livros;
	private Repositorio<Cliente> clientes;
	
	//Jackson
	Path arquivoLivros = Paths.get("D:\\workspace\\01Maven-BibliotecaDigital\\livros.json");
	Path arquivoClientes = Paths.get("D:\\workspace\\01Maven-BibliotecaDigital\\clientes.json");
	ObjectMapper conversor = new ObjectMapper();
	
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
		try {
			String livrosJSON = conversor.writeValueAsString(livros);
			String clientesJSON = conversor.writeValueAsString(clientes);
			Files.createDirectories(arquivoLivros.getParent());
			Files.createDirectories(arquivoClientes.getParent());
			Files.write(arquivoLivros, livrosJSON.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
			Files.write(arquivoClientes, clientesJSON.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarJSON() {
		try {
			livros = (Repositorio<Livro>) conversor.readValue(arquivoLivros.toFile(), new TypeReference<Repositorio<Livro>>(){});
			clientes = (Repositorio<Cliente>) conversor.readValue(arquivoClientes.toFile(), new TypeReference<Repositorio<Cliente>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
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
