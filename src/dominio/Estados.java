package dominio;

public enum Estados {
	AC("Acre"),
	AL("Alagoas"),
	AP("Amapa"),
	AM("Amazonas"),
	BA("Bahia"),
	CE("Ceara"),
	ES("Espirito Santo"),
	GO("Goiais"),
	MA("Maranhao"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Para"),
	PB("Paraiba"),
	PR("Parana"),
	PE("Pernambuco"),
	PI("Piaui"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rondonia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SP("Sao Paulo"),
	SE("Sergipe"),
	TO("Tocantins");
	
	private final String NOME;

	private Estados(String nome) {
		NOME = nome;
	}

	public String getNOME() {
		return NOME;
	}
	
}
