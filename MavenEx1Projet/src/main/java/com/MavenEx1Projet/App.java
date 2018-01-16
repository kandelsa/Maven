package com.MavenEx1Projet;

import java.util.List;
import java.util.Scanner;

import ville.Record;
import ville.Ville;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("static-access")
	public static void main( String[] args )
    {
    	JDBCConfigurationSol2 jdbc = new JDBCConfigurationSol2();
		
		jdbc.getConnection();
		
		maj();
		
		
		/**
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez vous modifier la BDD ? (y/n)");
		String str = sc.nextLine();
		
		if (str.equals("y")) {
			sc = new Scanner(System.in);
			System.out.println("quel est l'id de la commune à changer ?");
			String id = sc.nextLine();
			sc = new Scanner(System.in);
			System.out.println("quel est le nouveau nom  ?");
			String nom =sc.nextLine();
			
			jdbc.setInfos(id, nom);
		}
		System.out.println("Bonne journée !");
    }**/
    }
    
    public static void maj(){
		
    	GestionJson gestion = new GestionJson();		
		Ville villes = gestion.conversionJsontoVille(ConnexionServer.getAll());
		
		List<Record> recordVilleAPI = null;
		recordVilleAPI = villes.getRecords();
		
		for(Record rip : recordVilleAPI) {
			if(rip.getFields().getCoordonneesGps() != null)
				JDBCConfigurationSol2.setInfos(rip.getFields().getCodeCommuneInsee(), rip.getFields().getNomDeLaCommune(), rip.getFields().getCodePostal(),
					rip.getFields().getLibellDAcheminement(),  rip.getFields().getCoordonneesGps().get(0) , rip.getFields().getCoordonneesGps().get(1));
			else
				JDBCConfigurationSol2.setInfos(rip.getFields().getCodeCommuneInsee(), rip.getFields().getNomDeLaCommune(), rip.getFields().getCodePostal(),
						rip.getFields().getLibellDAcheminement());

		}
		System.out.println("azertyuiop");
		JDBCConfigurationSol2.doublons();
		System.out.println("qsdfghjklm");
    }
}
