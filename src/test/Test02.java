package test;

import service.BibliotecaManager;

public class Test02 {
	public static void main(String[] args) {
		
		BibliotecaManager bm = new BibliotecaManager();
		
		bm.carregarJSON();
		bm.getClientes().getItens().get(0).getNome();
		bm.getClientes().getItens().get(1).getNome();
		bm.getLivros().getItens().get(0).getNome();
		bm.getLivros().getItens().get(1).getNome();
	}
}
