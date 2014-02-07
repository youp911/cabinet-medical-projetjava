package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection 
{
	public void MySQLConnection(){}
	public static Connection getConnection(String base, String util, String mdp)
	{
		Statement stLienBd;
		String nomPilote = "org.gjt.mm.mysql.Driver";
		Connection connect = null;
		ResultSet resultat = null;
		try
		{
			Class.forName(nomPilote);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Probl�me chargement driver " + e.getMessage());
		}
		
		try
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/" + base, util, mdp);
			stLienBd = connect.createStatement();
		}
		catch(SQLException e)
		{
			System.out.println("Probl�me lors de la connexion � la base de donn�es " + e.getMessage());
		}
		
		return connect;
	}
}
