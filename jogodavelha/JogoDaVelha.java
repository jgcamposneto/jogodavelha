package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador jogador = new Jogador();
		Computador computador = Computador.getComputador(teclado);
		
		System.out.println("Configuração inicial do tabuleiro:");
		tabuleiro.mostrar();
		System.out.println();
		
		
		while(tabuleiro.estaInacabado()) {

			// Repete a jogada até informar uma posição ainda não preenchida no tabuleiro
			boolean jogadaValida = false;
			while(!jogadaValida) {
				int posicao[] = jogador.lerJogada(teclado);
				jogadaValida = tabuleiro.jogar(posicao, jogador.getJogada());
			}
			
			System.out.println();
			tabuleiro.mostrar();
			System.out.println();

			// O computador só precisa jogar se o jogo não estiver acabado (como por exemplo se o jogador já tiver vencido)
			if (tabuleiro.estaInacabado()) {
			
				// Repete a jogada até informar uma posição ainda não preechida no tabuleiro
				jogadaValida = false;
				while(!jogadaValida) {
					System.out.println("Jogada do computador:");
					jogadaValida = tabuleiro.jogar(computador.jogar(), computador.getJogada());
				}
			
			}
			
			// Mostra o tabuleiro atualizado
			System.out.println();
			tabuleiro.mostrar();
			System.out.println();
	
		}
		
		// Mostra o estado atual do jogo
		System.out.println("Situação do jogo: " + tabuleiro.getEstadoDoJogo());		
		System.out.println("Fim do jogo!");
		
		teclado.close();
	}

}
