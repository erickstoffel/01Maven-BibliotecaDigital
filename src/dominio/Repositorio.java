package dominio;

import java.util.*;

public class Repositorio<T> {
	private List<T> dados = new ArrayList<>();
	
	public void adicionar(T item) {
		dados.add(item); 
	}
	
	public List<T> listar() { 
    	return dados; 
    }
	
	
}
