package dominio;

import java.util.*;

public class Repositorio<T> {
    private List<T> itens = new ArrayList<>();

    public void adicionar(T item) {
        itens.add(item);
    }

    public void remover(T item) {
        itens.remove(item);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(itens);
    }

    public int tamanho() {
        return itens.size();
    }

    public List<T> getItens() {
        return itens;
    }

    public void setItens(List<T> itens) {
        this.itens = itens;
    }
}
