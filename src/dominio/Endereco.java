package dominio;

public class Endereco {
	private String bairro;
	private String cidade;
	private Estados estado;
	
	public Endereco(String bairro, String cidade, Estados estado) {
		super();
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
}
