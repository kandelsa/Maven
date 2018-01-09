package com.MavenEx1Projet;

import java.util.Scanner;

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
    }
}
