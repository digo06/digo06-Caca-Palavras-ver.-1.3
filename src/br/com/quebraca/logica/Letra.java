package br.com.quebraca.logica;

import java.io.Serializable;

public class Letra implements Serializable {

	private static final long serialVersionUID = 1L;

	private char letra;
	private byte coluna;
	private boolean cadastrou;

	public Letra() {
		this(' ', (byte) 0, (byte) 0);
	}

	public Letra(char letra, byte posLinha, byte posColuna) {
		this.letra = letra;
		this.cadastrou = false;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
		this.cadastrou = true;
	}

	public byte getColuna() {
		return coluna;
	}

	public boolean isCadastrou() {
		return cadastrou;
	}

}
