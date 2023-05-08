package jogodavelha;

import java.util.Scanner;

public class Jogador implements Jogavel {

	public int[] lerJogada(Scanner teclado) {
	
		// Lê a linha da posição da jogada
		int linha = 0;
		while (linha < 1 || linha > 3) {
			System.out.println("Informe a linha da próxima jogada (1 a 3): ");
			linha = teclado.nextInt();
			if(linha < 1 || linha > 3) {
				System.out.println("Linha inválida! Tente novamente.");
				continue;
			}
		}
		
		// Lê a coluna da posição da jogada
		int coluna = 0;
		while (coluna < 1 || coluna > 3) {
			System.out.println("Informe a coluna da próxima jogada (1 a 3): ");
			coluna = teclado.nextInt();
			if(coluna < 1 || coluna > 3) {
				System.out.println("Coluna inválida! Tente novamente.");
				continue;
			}
		}
		
		// Cria um array com as posições escolhidas para retornar na função
		int posicao[] = new int[2];
		
		// Converte para o padrão de índice do java, que inicia em 0.
		posicao[0] = linha - 1;
		posicao[1] = coluna - 1;
		
		return posicao;
		
	}

	@Override
	public Jogada getJogada() {
		return Jogada.JOGADOR;
	}
}
