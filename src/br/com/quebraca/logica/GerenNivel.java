package br.com.quebraca.logica;

import java.util.ArrayList;
import java.util.Random;

public class GerenNivel {

	private Nivel nivel;
	private Conflito conflito;

	public GerenNivel() {
		this.nivel = new Nivel();
		this.conflito = new Conflito();
	}

	public void Horizontal(String palavra) {
		char palavraVetor[] = palavra.toCharArray(); // criado um vetor que
														// recebe um to array
		if (palavraVetor.length >= this.nivel.getMatriz().getLetras().length) { // verifica
																				// se
																				// a
																				// o
																				// vetor
																				// criado
																				// é
																				// maior
																				// ou
																				// igual
																				// a
																				// matriz
																				// letra

		} else {
			byte linha = (byte) (Math.random() * this.nivel.getMatriz().getLetras().length - 1);
			// gerado um byte linha que recebe a matriz embaralhada.
			// e chamado a funcao Math.random para embaralhar a matriz conforme
			// o seu tamanho por letra.

			byte coluna = (byte) (Math.random() * ((this.nivel.getMatriz().getLetras().length) - palavraVetor.length));
			// o mesmo processo da ultima linha porem ele irar subitrair o valor
			// de P

			while (this.conflito.ConfliHorizontal(this.nivel.getMatriz(), palavraVetor, linha, coluna)) {

				linha = (byte) (Math.random() * this.nivel.getMatriz().getLetras().length - 1);
				coluna = (byte) (Math.random() * ((this.nivel.getMatriz().getLetras().length) - palavraVetor.length));
			}

			ArrayList<Letra> letrasDaPalavra = new ArrayList<Letra>();

			for (byte i = 0; i < palavraVetor.length; i++) {
				this.nivel.getMatriz().getLetras()[linha][coluna].setLetra(palavraVetor[i]);
				letrasDaPalavra.add(this.nivel.getMatriz().getLetras()[linha][coluna]);
				this.nivel.getPalavrasDoNivel().adicionaPalavrasCadastradas(palavra, letrasDaPalavra);
				coluna++;
			}
		}
	}

	public void Vertical(String palavra) {
		char palavraVetor[] = palavra.toCharArray();
		if (palavraVetor.length >= this.nivel.getMatriz().getLetras().length) {
		} else {
			byte coluna = (byte) (Math.random() * this.nivel.getMatriz().getLetras().length - 1);
			byte linha = (byte) (Math.random() * ((this.nivel.getMatriz().getLetras().length) - palavraVetor.length));

			while (this.conflito.ConfliVertical(this.nivel.getMatriz(), palavraVetor, coluna, linha)) {
				coluna = (byte) (Math.random() * this.nivel.getMatriz().getLetras().length - 1);
				linha = (byte) (Math.random() * ((this.nivel.getMatriz().getLetras().length) - palavraVetor.length));
			}

			ArrayList<Letra> letrasDaPalavra = new ArrayList<Letra>();
			for (byte i = 0; i < palavraVetor.length; i++) {
				this.nivel.getMatriz().getLetras()[linha][coluna].setLetra(palavraVetor[i]);
				letrasDaPalavra.add(this.nivel.getMatriz().getLetras()[linha][coluna]);
				this.nivel.getPalavrasDoNivel().adicionaPalavrasCadastradas(palavra, letrasDaPalavra);
				linha++;
			}
		}
	}

	public void carregaMatrizComLetrasAleatorias() {
		Random r = new Random();
		for (byte i = 0; i < this.nivel.getMatriz().getLetras().length; i++) {
			for (byte j = 0; j < this.nivel.getMatriz().getLetras().length; j++) {
				char letra = (char) (r.nextInt(26) + 'A');
				this.nivel.getMatriz().getLetras()[i][j] = new Letra(letra, i, j);
			}
		}
	}

	public Nivel getNivel() {
		return nivel;
	}
}
