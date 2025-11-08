package test;

import dominio.*;
import service.BibliotecaManager;

public class Main {
	public static void main(String[] args) {
		BibliotecaManager bm = new BibliotecaManager();
		Endereco endereco1 = new Endereco("Centro", "Nova Petrópolis", Estados.RS);
		Editora editora1 = new Editora("Sarampo", endereco1);
		Pessoa autor1 = new Pessoa("Erick", 17, "111.111.111-11");
		
		Livro l1 = new Livro("Livro Legal", editora1, autor1);
		Livro l2 = new Livro("Livro chato", editora1, autor1);
		Livro l3 = new Livro("Livro medio", editora1, autor1);
		Livro l4 = new Livro("Livro muito legal", editora1, autor1);
		
		bm.adicionarLivro(l1);
		bm.adicionarLivro(l2);
		bm.adicionarLivro(l3);
		bm.adicionarLivro(l4);
		
		Cliente c1 = new Cliente("Camila", 16, "222.222.222-22");
		bm.adicionarCliente(c1);
		
		try {
			bm.retirarLivro(l1, c1);
			System.out.println("Livro retirado com sucesso!");
			bm.retirarLivro(l2, c1);
			System.out.println("Livro retirado com sucesso!");
			bm.retirarLivro(l3, c1);
			System.out.println("Livro retirado com sucesso!");
			c1.listarLivrosRetirados();
			bm.retirarLivro(l4, c1);
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
		
		try {
			bm.devolverLivro(l1, c1);
			c1.listarLivrosRetirados();
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
		
		bm.salvarJSON();
	}
}
