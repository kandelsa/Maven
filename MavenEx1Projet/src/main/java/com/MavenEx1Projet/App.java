package com.MavenEx1Projet;

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
    }
}
