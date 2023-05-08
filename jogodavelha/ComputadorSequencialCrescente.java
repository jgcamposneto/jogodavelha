package jogodavelha;

// Subclasse de computador para gerar jogadas sequenciais crescentes
public class ComputadorSequencialCrescente extends Computador {

	private int[][] posicoesSequenciais = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
	private int indice;
	
	public ComputadorSequencialCrescente() {
		this.indice = 0;
	}
 	
	@Override
	public int[] jogar() {
		// A cada jogada o índice retorna uma posição do começo para o fim
		return posicoesSequenciais[indice++];
	}
	
}
