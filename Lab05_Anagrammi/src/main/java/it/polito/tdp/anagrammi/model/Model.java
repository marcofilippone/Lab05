package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DAO;

public class Model {
	
	private DAO dao;
	
	public Model() {
		dao = new DAO();
	}
	
	public List<String> getDizionario(){
		return dao.getDizionario();
	}
	
	public List<String> anagrammi(String parola) {
		List<String> paroleAnagramma = new ArrayList<>();
		cerca("", parola, 0, paroleAnagramma);
		return paroleAnagramma;
	}
	
	public void cerca(String parziale, String lettere, int livello, List<String> paroleAnagramma) {
		if(lettere.length()==0) {
			paroleAnagramma.add(parziale);
		}
		else {
			for(int i=0; i<lettere.length(); i++) {
				char c = lettere.charAt(i);
				parziale = parziale+c;
				lettere = lettere.substring(0, i)+lettere.substring(i+1);
				cerca(parziale, lettere, livello+1, paroleAnagramma);
				parziale = parziale.substring(0, parziale.length()-1);
				lettere = lettere.substring(0, i)+c+lettere.substring(i);
			}
		}
	}
	
}
