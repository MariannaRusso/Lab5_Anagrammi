package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {

	private String parola;
	List<Integer> numeri = null;
	
	public Anagramma(String parola) {
		this.parola = parola;
		numeri = new ArrayList<Integer>();
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean contains(int number) {
		return numeri.contains(number);
	}

	public void add(int number) {
		numeri.add(number);
	}

	public void remove(int number) {
		numeri.remove(Integer.valueOf(number));
	}

	public String convert() {
		String risultato = "";
		for(int i = 0; i < numeri.size(); i++)
			risultato += parola.charAt(numeri.get(i));
		return risultato;
	}

}
