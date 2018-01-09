package com.MavenEx1Projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class JDBCConfigurationSol2 {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1/maven?user=root&password=";

	static Connection connection = null;
	private static String code_INSEE = "92077";
	
    public static Connection getConnection(){		

    	try {
    	    //System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);

            if(connection == null) {
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

			String 	nom_commune = null;
			String code_postal = null;
			String ligne_5 = null;
			String latitude = null;
			String longitude = null;

			while (rset.next()) {

				nom_commune = rset.getString("Nom_commune");
				code_postal = rset.getString("Code_postal");
				ligne_5 = rset.getString("Ligne_5");
				latitude = rset.getString("Latitude");
				longitude = rset.getString("Longitude");
				
				System.out.println("nom commune : "+nom_commune + "\ncode postal :"
						+ " " + code_postal + "\nligne : " + ligne_5 + "\n"
								+ "latitude : " + latitude + "\nlongitude : " + longitude);

			} //fin de la boucle

			
			rset.close();
			stmt.close();
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
            e1.printStackTrace();
        }
        return connection;
    }
    
/**
    public static VilleBDD[] getInfosBDD(){		
    	VilleBDD villes[] = new VilleBDD[20];
    	try {
    	    //System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);

            if(connection == null) {
                connection = DriverManager.getConnection(DB_CONNECTION);
            }
            ResultSet rset = null;
			Statement stmt = connection.createStatement();
			if (stmt.execute("SELECT Nom_commune, Code_postal, Ligne_5,	Latitude, Longitude"
					+ " FROM ville_france ")) {
				rset = stmt.getResultSet();
			} else {
				rset = null;
			}

			String 	nom_commune = null;
			String code_postal = null;
			String ligne_5 = null;
			String latitude = null;
			String longitude = null;
			int compteur = 0;
			while (rset.next()) {

				nom_commune = rset.getString("Nom_commune");
				code_postal = rset.getString("Code_postal");
				ligne_5 = rset.getString("Ligne_5");
				latitude = rset.getString("Latitude");
				longitude = rset.getString("Longitude");
				
				villes[compteur] = new VilleBDD(nom_commune, code_postal, ligne_5, latitude, longitude);
				compteur++;
				
			} //fin de la boucle

			
			rset.close();
			stmt.close();
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
            e1.printStackTrace();
        }
    	
    	
        return villes;
    }**/
    
    public static Connection setInfos(String id, String nom, String CP, String Libelle_acheminement,  Double lat, Double longi){		
    	try {
    	    //System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);
            if(connection == null) {
                connection = DriverManager.getConnection(DB_CONNECTION);
            }
			Statement stmt = connection.createStatement();
			String requete = "UPDATE ville_france SET Nom_commune = '"+nom+ "', Code_postal = '"+CP +"',  Libelle_acheminement = '"
					+Libelle_acheminement+"', Latitude = '" +lat+"', Longitude = '"+longi+"'WHERE Code_commune_INSEE = " +id;
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
    
public static Connection setInfos(String id, String nom, String CP, String Libelle_acheminement){		
    	
    	
    	try {
    	    //System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);
            if(connection == null) {
                connection = DriverManager.getConnection(DB_CONNECTION);
            }
			Statement stmt = connection.createStatement();
			String requete = "UPDATE ville_france SET Nom_commune = '"+nom+ "', Code_postal = '"+CP +"',  Libelle_acheminement = '"
					+Libelle_acheminement+"' WHERE Code_commune_INSEE = " +id;
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
    
    public static Connection setInfos(String id, String nom){		

    	try {
    	    //System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);

            if(connection == null) {
                connection = DriverManager.getConnection(DB_CONNECTION);
            }
			Statement stmt = connection.createStatement();
			if (stmt.execute("UPDATE ville_france SET Nom_commune = '"+nom+ "' WHERE Code_commune_INSEE = " +id)) {
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