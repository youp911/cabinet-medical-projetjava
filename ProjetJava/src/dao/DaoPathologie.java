package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import metier.Pathologie;

//DaoConsultation permet l'accès à la table Pathologie de la BDD projetjava.sql et d'y gérer les informations (ajout, modification...)

public class DaoPathologie 
{
	public static Vector<Pathologie> getLesPathologies() 
	{
		Vector<Pathologie> lesPaths = new Vector<Pathologie>();
		Pathologie unePathologie;
		Statement stLienBd;
		ResultSet resultat = null;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "SELECT * FROM Pathologie";
			resultat = stLienBd.executeQuery(requete);
			while (resultat.next())
			{
				unePathologie = new Pathologie(resultat.getInt(1),resultat.getString(2));
				lesPaths.add(unePathologie);
			}
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesPaths;
	}
	public static boolean AjouterUnePathologie(Pathologie unPathologie)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "INSERT INTO Pathologie values("+ null +",'"+unPathologie.getLibellePathologie()+"')";
			resultat = stLienBd.executeUpdate(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	public static boolean ModifierUnePathologie(Pathologie unePathologie)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "UPDATE `pathologie` SET `LIBELLEPATHOLOGIE`='" + unePathologie.getLibellePathologie()+
					"' WHERE `NUMPATHOLOGIE`= '"+unePathologie.getNumPathologie()+"'"; 
			//UPDATE `pathologie` SET `NUMPATHOLOGIE`=[value-1],`LIBELLEPATHOLOGIE`=[value-2] WHERE 1
			resultat = stLienBd.executeUpdate(requete);
			System.out.println(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	
	public static boolean SupprimerUnePathologie(Pathologie unePathologie)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			String requete = "DELETE FROM Pathologie where numordrePathologie = '" + unePathologie.getNumPathologie() +"'";
			resultat = stLienBd.executeUpdate(requete);
			System.out.println(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
}
