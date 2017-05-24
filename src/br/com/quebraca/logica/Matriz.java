package br.com.quebraca.logica;

import java.io.Serializable;

public class Matriz implements Serializable{
	
	private static final long serialVersionUID = -3945544161239856702L;
	
	private Letra [] [] matrizLetras;
	
	public Matriz(){		
		this((byte)0,(byte)0);
	}
	public Matriz(byte linhas,byte colunas){
		this.matrizLetras = new Letra[linhas][colunas];
	}
	public Letra[][] getLetras() {
		return this.matrizLetras;
	}
	public void setMatrizLetras(Letra[][] matrizLetras) {
		this.matrizLetras = matrizLetras;
	}
	
}
