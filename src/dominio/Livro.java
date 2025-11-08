package dominio;

import java.util.Objects;
import java.util.UUID;

public class Livro{
	private final String ID = UUID.randomUUID().toString();
	private String nome;
	private Editora editora;
	private Pessoa autor;
	private boolean disponivel = true;
	
	public Livro(String nome, Editora editora, Pessoa autor) {
		super();
		Objects.requireNonNull(nome, "Atributo Nome deve ser diferente de Null");
		Objects.requireNonNull(editora, "Atributo Editora deve ser diferente de Null");
		Objects.requireNonNull(autor, "Atributo Autor deve ser diferente de Null");
		this.nome = nome;
		this.editora = editora;
		this.autor = autor;
	}
	
	public String getId() {
		return ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, disponivel, editora, ID, nome);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    Livro other = (Livro) obj;
	    return Objects.equals(ID, other.ID);
	}
}
