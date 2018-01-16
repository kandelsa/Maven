package com.MavenEx1Projet;

import java.util.List;

import ville.Record;
import ville.Ville;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		JDBCConfigurationSol2 jdbc = new JDBCConfigurationSol2();

		jdbc.getConnection("92077");

		maj();

		/**
		 * Scanner sc = new Scanner(System.in); System.out.println("Voulez vous modifier
		 * la BDD ? (y/n)"); String str = sc.nextLine();
		 * 
		 * if (str.equals("y")) { sc = new Scanner(System.in); System.out.println("quel
		 * est l'id de la commune à changer ?"); String id = sc.nextLine(); sc = new
		 * Scanner(System.in); System.out.println("quel est le nouveau nom ?"); String
		 * nom =sc.nextLine();
		 * 
		 * jdbc.setInfos(id, nom); } System.out.println("Bonne journée !"); }
		 **/
	}

	public static void maj() {

		//gestion doublon
		JDBCConfigurationSol2.doublons();
		
		GestionJson gestion = new GestionJson();
		Ville villesAPI = gestion.conversionJsontoVille(ConnexionServer.getAll());

		List<Record> recordVilleAPI = null;
		recordVilleAPI = villesAPI.getRecords();

		List<String> inseeVilleBDD = JDBCConfigurationSol2.getConnectionBDD();
		String[] villeManquante = new String[7];
		
		for (Record rip : recordVilleAPI) {
			//update des informations
			if (rip.getFields().getCoordonneesGps() != null)
				JDBCConfigurationSol2.setInfos(rip.getFields().getCodeCommuneInsee(),
						rip.getFields().getNomDeLaCommune(), rip.getFields().getCodePostal(),
						rip.getFields().getLibellDAcheminement(), rip.getFields().getCoordonneesGps().get(0),
						rip.getFields().getCoordonneesGps().get(1));
			else
				JDBCConfigurationSol2.setInfos(rip.getFields().getCodeCommuneInsee(),
						rip.getFields().getNomDeLaCommune(), rip.getFields().getCodePostal(),
						rip.getFields().getLibellDAcheminement());
			
			//vérification : est-ce que la ville existe dans la BDD
			if (!JDBCConfigurationSol2.trouver(rip.getFields().getCodeCommuneInsee())) {
				villeManquante[0] = rip.getFields().getCodeCommuneInsee();
				villeManquante[1] = rip.getFields().getNomDeLaCommune();
				villeManquante[2] = rip.getFields().getCodePostal();
				villeManquante[3] = rip.getFields().getLibellDAcheminement();
				villeManquante[4] = " ";
				if (rip.getFields().getCoordonneesGps() != null) {
					villeManquante[5] = "" + rip.getFields().getCoordonneesGps().get(0);
					villeManquante[6] = "" + rip.getFields().getCoordonneesGps().get(1);
				}
				JDBCConfigurationSol2.creer(villeManquante);
			}
		}

		System.out.println("test fini !");
	}
}
