package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import metier.Medicament;
import metier.Medicament;

//DaoConsultation permet l'accès à la table Medicament de la BDD projetjava.sql et d'y gérer les informations (ajout, modification...)

public class DaoMedicament 
{
	public static Vector<Medicament> getLesMedocs() 
	{
		Vector<Medicament> lesMedocs = new Vector<Medicament>();
		Medicament unMedicament;
		Statement stLienBd;
		ResultSet resultat = null;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "SELECT * FROM Medicament";
			resultat = stLienBd.executeQuery(requete);
			while (resultat.next())
			{
				unMedicament = new Medicament(resultat.getInt(1),resultat.getString(2), resultat.getString(3));
				lesMedocs.add(unMedicament);
			}
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesMedocs;
	}
	public static boolean AjouterUnMedicament(Medicament unMedicament)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "INSERT INTO Medicament values("+ null +",'"+unMedicament.getNomMedicament()+"','"+unMedicament.getDescriptionMedicament()+"')";
			System.out.println(requete);
			resultat = stLienBd.executeUpdate(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	public static boolean ModifierUnMedicament(Medicament uneMedicament)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "UPDATE `Medicament` SET `NOMMEDICAMENT`='" + uneMedicament.getNomMedicament()+
					"',`DESCRIPTIONMEDICAMENT`='" + uneMedicament.getDescriptionMedicament()+
					"' WHERE `NUMMEDICAMENT`= '"+uneMedicament.getNumMedicament()+"'"; 
			//UPDATE `medicament` SET `NUMMEDICAMENT`=[value-1],`NOMMEDICAMENT`=[value-2],`DESCRIPTIONMEDICAMENT`=[value-3] WHERE 1
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

	public static Medicament TrouverUnMedocAvecSonNom (String leNom)
	{
		boolean res=false;
		Statement stLienBd;
		ResultSet resultat = null;
		Medicament unMedicament = null;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			String requete = "Select * from Medicament where nomMedicament = '" + leNom +"'";
			resultat = stLienBd.executeQuery(requete);
			System.out.println(requete);
			while (resultat.next())
			{
				unMedicament = new Medicament(resultat.getInt(1),resultat.getString(2), resultat.getString(3));
			}
			
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return unMedicament;
	}
}
