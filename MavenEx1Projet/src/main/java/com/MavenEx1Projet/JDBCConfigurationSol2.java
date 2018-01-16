package com.MavenEx1Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ville.Record;
import ville.Ville;

public class JDBCConfigurationSol2 {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1/maven?user=root&password=";

	static Connection connection = null;

	public static String[] getConnection(String code_INSEE) {
		String[] ville = new String[7];
		try {
			// System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);

			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			ResultSet rset = null;
			Statement stmt = connection.createStatement();
			if (stmt.execute("SELECT Nom_commune, Code_postal, Ligne_5,	Latitude, Longitude"
					+ " FROM ville_france WHERE Code_commune_INSEE = " + code_INSEE)) {
				rset = stmt.getResultSet();
			} else {
				rset = null;
			}

			ville[0] = code_INSEE;
			while (rset.next()) {

				ville[1] = rset.getString("Nom_commune");
				ville[2] = rset.getString("Code_postal");
				ville[4] = rset.getString("Ligne_5");
				ville[5] = rset.getString("Latitude");
				ville[6] = rset.getString("Longitude");

				System.out.println("nom commune : " + ville[1] + "\ncode postal :" + " " + ville[2] + "\nligne : "
						+  "latitude : " + ville[5] + "\nlongitude : " + ville[6]);

			} // fin de la boucle

			rset.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return ville;
	}

	public static List<String> getConnectionBDD() {
		List<String> villes = new ArrayList<String>();

		try {
			Class.forName(DB_DRIVER);

			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			ResultSet rset = null;
			Statement stmt = connection.createStatement();
			if (stmt.execute("SELECT Code_commune_INSEE FROM ville_france ")) {
				rset = stmt.getResultSet();
			} else {
				rset = null;
			}

			while (rset.next()) {
				villes.add(rset.getString("Code_commune_INSEE"));
			}

			rset.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return villes;
	}

	/**
	 * public static VilleBDD[] getInfosBDD(){ VilleBDD villes[] = new VilleBDD[20];
	 * try { //System.out.println("Connection : "+ DB_CONNECTION);
	 * 
	 * Class.forName(DB_DRIVER);
	 * 
	 * if(connection == null) { connection =
	 * DriverManager.getConnection(DB_CONNECTION); } ResultSet rset = null;
	 * Statement stmt = connection.createStatement(); if (stmt.execute("SELECT
	 * Nom_commune, Code_postal, Ligne_5, Latitude, Longitude" + " FROM ville_france
	 * ")) { rset = stmt.getResultSet(); } else { rset = null; }
	 * 
	 * String nom_commune = null; String code_postal = null; String ligne_5 = null;
	 * String latitude = null; String longitude = null; int compteur = 0; while
	 * (rset.next()) {
	 * 
	 * nom_commune = rset.getString("Nom_commune"); code_postal =
	 * rset.getString("Code_postal"); ligne_5 = rset.getString("Ligne_5"); latitude
	 * = rset.getString("Latitude"); longitude = rset.getString("Longitude");
	 * 
	 * villes[compteur] = new VilleBDD(nom_commune, code_postal, ligne_5, latitude,
	 * longitude); compteur++;
	 * 
	 * } //fin de la boucle
	 * 
	 * 
	 * rset.close(); stmt.close(); } catch (ClassNotFoundException e) {
	 * e.printStackTrace(); } catch (SQLException e1) { e1.printStackTrace(); }
	 * 
	 * 
	 * return villes; }
	 **/

	public static Connection setInfos(String id, String nom, String CP, String Libelle_acheminement, Double lat,
			Double longi) {
		try {
			// System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);
			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			Statement stmt = connection.createStatement();
			String requete = "UPDATE ville_france SET Nom_commune = '" + nom + "', Code_postal = '" + CP
					+ "',  Libelle_acheminement = '" + Libelle_acheminement + "', Latitude = '" + lat
					+ "', Longitude = '" + longi + "'WHERE Code_commune_INSEE = '" + id + "'";
			if (stmt.execute(requete)) {
			}
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	public static Connection setInfos(String id, String nom, String CP, String Libelle_acheminement) {

		try {
			// System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);
			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			Statement stmt = connection.createStatement();
			String requete = "UPDATE ville_france SET Nom_commune = '" + nom + "', Code_postal = '" + CP
					+ "',  Libelle_acheminement = '" + Libelle_acheminement + "' WHERE Code_commune_INSEE = " + id;
			if (stmt.execute(requete)) {
			}
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	// public static Connection doublons() {
	//
	// try {
	// // System.out.println("Connection : "+ DB_CONNECTION);
	//
	// Class.forName(DB_DRIVER);
	// if (connection == null) {
	// connection = DriverManager.getConnection(DB_CONNECTION);
	// }
	// ResultSet rset = null;
	// Statement stmt = connection.createStatement();
	// String requete = "SELECT COUNT(Nom_commune) AS nbr_doublon,
	// Nom_commune,Code_commune_INSEE "
	// + "FROM ville_france GROUP BY Nom_commune HAVING COUNT(Nom_commune) > 1";
	// if (stmt.execute(requete)) {
	// rset = stmt.getResultSet();
	// } else {
	// rset = null;
	// }
	//
	// String code = null;
	// String nom = null;
	// int doublons = 0;
	// Statement stmt2 = connection.createStatement();
	//
	// while (rset.next()) {
	// nom = rset.getString("Nom_commune");
	// code = rset.getString("Code_commune_INSEE");
	// doublons = Integer.parseUnsignedInt(rset.getString("nbr_doublon"));
	// System.out.println(nom + " " + code + " " + doublons);
	//
	// String requete2 = "DELETE FROM ville_france WHERE Nom_commune = '"+nom +"'
	// and Code_commune_INSEE <> '" +code+"'";
	// if (stmt2.execute(requete2)) {}
	// }
	//
	// stmt.close();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e1) {
	// e1.printStackTrace();
	// }
	// return connection;
	// }

	public static Connection doublons() {
		GestionJson gestion = new GestionJson();
		Ville villesAPI = gestion.conversionJsontoVille(ConnexionServer.getAll());

		List<Record> recordVilleAPI = null;
		recordVilleAPI = villesAPI.getRecords();

		try {
			// System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);
			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			ResultSet rset = null;
			Statement stmt = connection.createStatement();
			String requete = "SELECT COUNT(Nom_commune) AS nbr_doublon, Nom_commune,Code_commune_INSEE "
					+ "FROM   ville_france GROUP BY Nom_commune HAVING   COUNT(Nom_commune) > 1";
			if (stmt.execute(requete)) {
				rset = stmt.getResultSet();
			} else {
				rset = null;
			}

			String nom = null;
			String requete2 = "";
			Statement stmt2 = connection.createStatement();

			while (rset.next()) {
				nom = rset.getString("Nom_commune");

				for (Record rip : recordVilleAPI) {
					if (rip.getFields().getNomDeLaCommune().equals(nom)) {
						
						requete2 = "DELETE FROM ville_france WHERE Nom_commune = '"+ nom + "' and Code_commune_INSEE <> '" + rip.getFields().getCodeCommuneInsee() + "'";
						if (stmt2.execute(requete2)) {
						}
					}
				}
			}

			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	public static Connection setInfos(String id, String nom) {

		try {
			// System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);

			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			Statement stmt = connection.createStatement();
			if (stmt.execute("UPDATE ville_france SET Nom_commune = '" + nom + "' WHERE Code_commune_INSEE = " + id)) {
			}

			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	public static boolean trouver(String code_insee, List<String> villesBDD) {

		int compteur = 0;
		for (String ville : villesBDD) {
			if (code_insee.equals(ville))
				compteur++;
		}
		return compteur != 0;
	}

	public static Connection creer(String[] ville) {
		System.out.println(ville[1] + "a");
		try {
			Class.forName(DB_DRIVER);

			if (connection == null) {
				connection = DriverManager.getConnection(DB_CONNECTION);
			}
			Statement stmt = connection.createStatement();
			String requete = "INSERT INTO ville_france "
					+ "(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement,Ligne_5,Latitude,Longitude) VALUES "
					+ "('" + ville[0] + "', '" + ville[1] + "', '" + ville[2] + "','" + ville[3] + "','" + ville[4]
					+ "','" + ville[5] + "','" + ville[6] + "')";
			if (stmt.execute(requete)) {
			}

			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return connection;
	}

}