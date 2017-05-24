package br.com.quebraca.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PalaCadastradas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, ArrayList<Letra>> palavrasCadastradas;

	public PalaCadastradas() {
		this(new HashMap<String, ArrayList<Letra>>());
	}

	public PalaCadastradas(HashMap<String, ArrayList<Letra>> letrasDaPalavra) {
		this.palavrasCadastradas = letrasDaPalavra;
	}

	public void adicionaPalavrasCadastradas(String palavra, ArrayList<Letra> listaDeLetras) {
		this.palavrasCadastradas.put(palavra, listaDeLetras);
	}
}
