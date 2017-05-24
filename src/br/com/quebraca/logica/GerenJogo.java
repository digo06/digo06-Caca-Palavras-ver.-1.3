package br.com.quebraca.logica;

public class GerenJogo {

	private GerenNivel gerenteDeNivel;

	public GerenJogo() {
		this.gerenteDeNivel = new GerenNivel();
	}

	public GerenNivel getGerenteDeNivel() {
		return gerenteDeNivel;
	}

	public void setGerenteDeNivel(GerenNivel gerenteMatriz) {
		this.gerenteDeNivel = gerenteMatriz;
	}
}
