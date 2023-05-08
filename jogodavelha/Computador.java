package jogodavelha;

import java.util.Scanner;

// Interface comum para as classes Jogador e Computador, para forçar que eles
// retornem a jogada correspondente a eles
public abstract class Computador implements Jogavel {

	public abstract int[] jogar();	
	
	@Override
	public Jogada getJogada() {
		return Jogada.COMPUTADOR;
	}

	// Escolhe o tipo de adversário computador
	public static Computador getComputador(Scanner teclado) {
		
		int computador = 0;

		System.out.println("1 - ComputadorAleatorio");
		System.out.println("2 - ComputadorSequencialCrescente");
		System.out.println("3 - ComputadorSequencialDecrescente");
		
		while(computador < 1 || computador > 3) { 
			System.out.println("Escolha o tipo de adversário Computador:");
			computador = teclado.nextInt();
		}
		
		if(computador == 1)
			return new ComputadorAleatorio();
		else if(computador == 2)
			return new ComputadorSequencialCrescente();
		else
			return new ComputadorSequencialDecrescente();
		
	}
	
}	
