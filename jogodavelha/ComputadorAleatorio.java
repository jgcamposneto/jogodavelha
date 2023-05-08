package jogodavelha;

import java.util.Random;

// Subclasse de computador para gerar jogadas aleatórias
public class ComputadorAleatorio extends Computador {

	private Random aleatorio;
	
	public ComputadorAleatorio() {
		this.aleatorio = new Random();
	}

	@Override
	public int[] jogar() {

		// Gera um número aleatório entre 0 e 2 para o computador jogar
		int linhaComputador = aleatorio.nextInt(3);
		int colunaComputador = aleatorio.nextInt(3);
		int posicao[] = {linhaComputador, colunaComputador};
		
		return posicao;

	}
	
}
