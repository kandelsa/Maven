package com.MavenEx1Projet;

import com.google.gson.Gson;

import ville.Ville;

/**
 * @author KANDEL Sarah
 * @author HEITZ Alexandre
 *
 */
public class GestionJson {

	private Ville[] villes;
	private String json;

	/**
	 * M�thode permettant de transformer un json en un objet Ville
	 * 
	 * @param stringOfJson
	 *            le json � transformer
	 * @return la ville
	 */
	public Ville[] conversionJsontoTrain(String stringOfJson) {
		Gson gson = new Gson();
		villes = gson.fromJson(stringOfJson, Ville[].class);
		return villes;
	}

	/**
	 * M�thode de transformer un objet Ville en json
	 * 
	 * @param ville
	 * @return le json
	 */
	public String conversionTraintoJson(Ville ville) {
		Gson gson = new Gson();
		json = gson.toJson(ville);
		return json;
	}

	
	
}
