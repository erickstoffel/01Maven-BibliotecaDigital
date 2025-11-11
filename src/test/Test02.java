package test;

import service.BibliotecaManager;

public class Test02 {
	public static void main(String[] args) {
		
		BibliotecaManager bm = new BibliotecaManager();
		
		bm.carregarJSON();
		System.out.println(bm.getClientes().getItens().get(0).getNome());
		System.out.println(bm.getLivros().getItens().get(0).getNome());
		System.out.println(bm.getLivros().getItens().get(1).getNome());
	}
}
