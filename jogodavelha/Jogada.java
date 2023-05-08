package jogodavelha;

// Representa a jogada no tabuleiro
public enum Jogada {
	
	JOGADOR(" o "), 
	COMPUTADOR(" x "), 
	VAZIO("   ");
	
	private String representacao;
	
	private Jogada(String rep) {
		this.representacao = rep;
	}

	public String getRepresentacao() {
		return representacao;
	}
	
}
