package jogodavelha;

public class Tabuleiro {
	
	// Declara uma matriz para guardar cada posição do tabuleiro
	private Jogada posicoes[][] = new Jogada[3][3];
	
	// Estado atual do jogo
	private EstadoDoJogo estado;
	
	public Tabuleiro() {
		
		// Inicializa cada posição do tabuleiro com vazio
		for (int linha = 0; linha < posicoes.length; linha++) {
			for (int coluna = 0; coluna < posicoes.length; coluna++) {
				posicoes[linha][coluna] = Jogada.VAZIO;
			}
		}
		
		// Inicializa o Estado do jogo como inacabado
		estado = EstadoDoJogo.INACABADO;
	}

	public void mostrar() {

		// Para exibir a posição atual do tabuleiro
		String[][] tabuleiro = {{posicoes[0][0].getRepresentacao(), "|", posicoes[0][1].getRepresentacao(), "|", posicoes[0][2].getRepresentacao()}, 
                 {"---", "+", "---", "+", "---"},
                 {posicoes[1][0].getRepresentacao(), "|", posicoes[1][1].getRepresentacao(), "|", posicoes[1][2].getRepresentacao()},
                 {"---", "+", "---", "+", "---"},
                 {posicoes[2][0].getRepresentacao(), "|", posicoes[2][1].getRepresentacao(), "|", posicoes[2][2].getRepresentacao()}};

        // Imprime o tabuleiro
        for (String[] linha : tabuleiro) {
            for (String coluna : linha) {
                System.out.print(coluna);
            }
            System.out.println();
        }

	}

	public boolean jogar(int[] posicao, Jogada jogada) {
		// Se for uma jogada válida, atualiza a posição e retorna verdadeiro
		// Se for uma jogada inválida, não atualiza e retorna falso
		if (this.posicoes[posicao[0]][posicao[1]] == Jogada.VAZIO) {
			this.posicoes[posicao[0]][posicao[1]] = jogada;
			this.atualizarEstado();
			return true;
		}

		return false;
		
	}
	
	// Atualiza o estado do jogo: VITORIA, INACABADO, EMPATE, DERROTA
	private void atualizarEstado() {

		estado = EstadoDoJogo.EMPATADO;
		
	    // Verifica inacabado
		for (Jogada[] linha : posicoes) {
			for (Jogada coluna : linha) {
				if (coluna == Jogada.VAZIO)
					estado = EstadoDoJogo.INACABADO;
			}
		}
		
		// Verifica vitória
	    if((posicoes[0][0] == posicoes[0][1] && posicoes[0][0] == posicoes[0][2] && posicoes[0][2] == Jogada.JOGADOR) // Primeira linha horizontal
	    	||
	      (posicoes[0][0] == posicoes[1][0] && posicoes[0][0] == posicoes[2][0] && posicoes[2][0] == Jogada.JOGADOR) // Primeira coluna vertical 
	    	||
	      (posicoes[1][0] == posicoes[1][1] && posicoes[1][0] == posicoes[1][2] && posicoes[1][0] == Jogada.JOGADOR) // Segunda linha horizontal
	    	||
          (posicoes[2][0] == posicoes[2][1] && posicoes[2][0] == posicoes[2][2] && posicoes[2][0] == Jogada.JOGADOR) // Terceira linha horizontal
	    	||
	      (posicoes[0][1] == posicoes[1][1] && posicoes[0][1] == posicoes[2][1] && posicoes[0][1] == Jogada.JOGADOR) // Segunda coluna vertical
	    	||
	      (posicoes[0][2] == posicoes[1][2] && posicoes[0][2] == posicoes[2][2] && posicoes[0][2] == Jogada.JOGADOR) // Terceira coluna vertical
	        ||
          (posicoes[0][0] == posicoes[1][1] && posicoes[0][0] == posicoes[2][2] && posicoes[0][0] == Jogada.JOGADOR) // Diagonal 1
	    	||
          (posicoes[0][2] == posicoes[1][1] && posicoes[0][2] == posicoes[2][0] && posicoes[0][2] == Jogada.JOGADOR)) // Diagonal 2
	    	estado = EstadoDoJogo.VITORIA;
	    
	 // Verifica derrota
	    if((posicoes[0][0] == posicoes[0][1] && posicoes[0][0] == posicoes[0][2] && posicoes[0][2] == Jogada.COMPUTADOR) // Primeira linha horizontal
		    	||
		      (posicoes[0][0] == posicoes[1][0] && posicoes[0][0] == posicoes[2][0] && posicoes[2][0] == Jogada.COMPUTADOR) // Primeira coluna vertical 
		    	||
		      (posicoes[1][0] == posicoes[1][1] && posicoes[1][0] == posicoes[1][2] && posicoes[1][0] == Jogada.COMPUTADOR) // Segunda linha horizontal
		    	||
	          (posicoes[2][0] == posicoes[2][1] && posicoes[2][0] == posicoes[2][2] && posicoes[2][0] == Jogada.COMPUTADOR) // Terceira linha horizontal
		    	||
		      (posicoes[0][1] == posicoes[1][1] && posicoes[0][1] == posicoes[2][1] && posicoes[0][1] == Jogada.COMPUTADOR) // Segunda coluna vertical
		    	||
		      (posicoes[0][2] == posicoes[1][2] && posicoes[0][2] == posicoes[2][2] && posicoes[0][2] == Jogada.COMPUTADOR) // Terceira coluna vertical
		        ||
	          (posicoes[0][0] == posicoes[1][1] && posicoes[0][0] == posicoes[2][2] && posicoes[0][0] == Jogada.COMPUTADOR) // Diagonal 1
		    	||
	          (posicoes[0][2] == posicoes[1][1] && posicoes[0][2] == posicoes[2][0] && posicoes[0][2] == Jogada.COMPUTADOR)) // Diagonal 2
		    	estado = EstadoDoJogo.DERROTA;
		
	}

	public boolean estaInacabado() {
		return estado == EstadoDoJogo.INACABADO;
	}

	public EstadoDoJogo getEstadoDoJogo( ) {
		return estado;
	}

}
