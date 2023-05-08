package jogodavelha;

//Subclasse de computador para gerar jogadas sequenciais decrescentes
public class ComputadorSequencialDecrescente extends Computador {

	private int[][] posicoesSequenciais = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
	private int indice;
	
	public ComputadorSequencialDecrescente() {
		this.indice = 8;
	}
 	
	@Override
	public int[] jogar() {
		// A cada jogada o índice retorna uma posição do final para o começo
		return posicoesSequenciais[indice--];
		
	}
	
}
