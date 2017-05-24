package br.com.quebraca.logica;

public class Conflito {

	public boolean ConfliVertical(Matriz matriz, char palavraVetor[], byte coluna, byte linha) {

		boolean conflito = false;
		byte i;

		for (i = 0; i < palavraVetor.length; i++) {
			if ((matriz.getLetras()[linha][coluna].isCadastrou())) {
				if (palavraVetor[i] == matriz.getLetras()[linha][coluna].getLetra()) {
					conflito = false;
				} else {
					conflito = true; 
					break;
				}
			} else {
				conflito = false;
			}
			linha++;
		}
		return conflito;
	}

	public boolean ConfliHorizontal(Matriz matriz, char palavraVetor[], byte linha, byte coluna) { 
		boolean conflito = false;

		for (byte i = 0; i < palavraVetor.length; i++) {
			if ((matriz.getLetras()[linha][coluna].isCadastrou())) {
				if (palavraVetor[i] == matriz.getLetras()[linha][coluna].getLetra()) {
					conflito = false;
				} else {
					conflito = true;
					break;
				}
			} else {
				conflito = false;
			}
			coluna++;
		}
		return conflito;
	}

}
