package com.MavenEx1Projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author KANDEL Sarah
 * @author HEITZ Alexandre
 *
 */

public class ConnexionServer {
	
	/**
	 * M�thode permettant de r�cup�rer les villes  
	 * en envoyant une requ�te de type GET au serveur 
	 * 
	 * @param objet le type d'objet que l'on souhaite 
	 * 			r�cup�rer (une mission ou les donn�es gps)
	 * @return le json correspondant � l'objet souhait�
	 */
	//probl�me accent ici
	public static String getAll() {
		String json = "";
		String output = "";
		try {

			URL url = new URL("http://datanova.legroupe.laposte.fr/api/records/1.0/search/?dataset=laposte_hexasmal&rows=100&OpenDataSoft=alexandreheitz");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"utf8"));

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				json += output;
			}			
			conn.disconnect();
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
}
