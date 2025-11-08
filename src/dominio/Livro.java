package dominio;

import java.util.Objects;

public class Livro implements Comparable<Livro>{
	private Integer id;
	private String nome;
	private Editora editora;
	private Pessoa autor;
	private boolean disponivel = true;
	
	public Livro(int id, String nome, Editora editora, Pessoa autor) {
		super();
		Objects.requireNonNull(id, "Atributo Id deve ser diferente de Null");
		Objects.requireNonNull(nome, "Atributo Nome deve ser diferente de Null");
		Objects.requireNonNull(editora, "Atributo Editora deve ser diferente de Null");
		Objects.requireNonNull(autor, "Atributo Autor deve ser diferente de Null");
		this.id = id;
		this.nome = nome;
		this.editora = editora;
		this.autor = autor;
	}

	public static void retirarLivro(Livro livro) throws LivroIndisponivelException {
		if(!livro.disponivel) {
			throw new LivroIndisponivelException("O livro já esta retirado!");
		}else {			
			livro.disponivel = false;
			System.out.println("Livro retirado!");
		}
	}
	
	public void devolverLivro(Livro livro) throws LivroIndisponivelException{
		if(livro.disponivel) {
			throw new LivroIndisponivelException("O livro não esta retirado!");
		}else {			
			livro.disponivel = true;
			System.out.println("Livro devolvido!");
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int compareTo(Livro o) {
		if(this.id > o.getId()) return 1;
		if(this.id.equals(o.getId())) return 0;
		else return -1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, disponivel, editora, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(autor, other.autor) && disponivel == other.disponivel
				&& Objects.equals(editora, other.editora) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
}
