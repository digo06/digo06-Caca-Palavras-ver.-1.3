package br.com.quebraca.logica;

import java.io.Serializable;

public class Nivel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Matriz matriz;
	private PalaCadastradas palavrasDoNivel; 
	
	public Nivel(){
		this.matriz = new Matriz();
		this.palavrasDoNivel = new PalaCadastradas();
	}
	
	public void nivelFacil(){
		this.matriz = new Matriz((byte)15,(byte)15);		
	}
	
	public void nivelMedio(){
		this.matriz = new Matriz((byte)20,(byte)20);
	}
	
	public void nivelDificil(){
		this.matriz = new Matriz((byte)25,(byte)25);
	}

	public Matriz getMatriz(){
		return matriz;
	}

	public void setMatriz(Matriz matriz){
		this.matriz = matriz;
	}

	public PalaCadastradas getPalavrasDoNivel() {
		return palavrasDoNivel;
	}

	public void setPalavrasDoNivel(PalaCadastradas palavrasDoNivel) {
		this.palavrasDoNivel = palavrasDoNivel;
	}

}
