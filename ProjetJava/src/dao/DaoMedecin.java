package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import metier.Medecin;

//DaoConsultation permet l'accès à la table Medecin de la BDD projetjava.sql et d'y gérer les informations (ajout, modification...)

public class DaoMedecin 
{
	public static Vector<Medecin> getLesMedecins() 
	{
		Vector<Medecin> lesMedecins = new Vector<Medecin>();
		Medecin unMedecin;
		Statement stLienBd;
		ResultSet resultat = null;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "SELECT * FROM Medecin";
			resultat = stLienBd.executeQuery(requete);
			while (resultat.next())
			{
				unMedecin = new Medecin(resultat.getString(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),resultat.getString(5),resultat.getString(6));
				lesMedecins.add(unMedecin);
			}
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesMedecins;
	}
	public static boolean AjouterUnMedecin(Medecin unMedecin)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "INSERT INTO Medecin values('"+ unMedecin.getNumOrdreMedecin()+"','"+unMedecin.getNomMedecin()+"','"+unMedecin.getPrenomMedecin()
					+"','"+unMedecin.getAdresseMedecin()+"','"+unMedecin.getCPMedecin()+"','"+unMedecin.getVilleMedecin()+"')";
			resultat = stLienBd.executeUpdate(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	public static boolean ModifierUnMedecin(Medecin unMedecin)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "UPDATE `medecin` SET `NUMORDREMEDECIN`='"+unMedecin.getNumOrdreMedecin()+"',`NOMMEDECIN`='"+
					unMedecin.getNomMedecin() +"',`PRENOMMEDECIN`='"+unMedecin.getPrenomMedecin()+"',`ADRESSEMEDECIN`='"+
					unMedecin.getAdresseMedecin()+"',`CPMEDECIN`='"+unMedecin.getCPMedecin()+"'," +
					"`VILLEMEDECIN`='"+unMedecin.getVilleMedecin()+"' " +
					"WHERE numordremedecin = '"+unMedecin.getNumOrdreMedecin()+"'"; 
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
	public static boolean SupprimerUnMedecin(Medecin unMedecin)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			String requete = "DELETE FROM medecin where numordremedecin = '" + unMedecin.getNumOrdreMedecin() +"'";
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
