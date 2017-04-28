package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	List<String> solutions = null;
	private AnagrammaDAO anagrammaDAO;
	
	public Model() {
		
		anagrammaDAO = new AnagrammaDAO();
	}
	
	public List<String> trovaAnagrammi(String parola) {
		
		solutions = new ArrayList<String>();
		
		Anagramma anagramma = new Anagramma(parola);
		
		int step = 0;
		recursive(anagramma, step);
		
		return solutions;
	}

	private void recursive(Anagramma anagramma, int step) {

		if(step >= anagramma.getParola().length()){
			String parola = anagramma.convert();
			if(!solutions.contains(parola))
				solutions.add(parola);
			return;
		}
		
		for (int i = 0; i < anagramma.getParola().length(); i++) {
			if(!anagramma.contains(i)) {
				anagramma.add(i);
				recursive(anagramma, step+1);
				anagramma.remove(i);
			}
		}
		return;
		
	}

	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
	}

}