package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import metier.Consultation;
import metier.Medecin;
import metier.Pathologie;
import metier.Patient;

// DaoConsultation permet l'accès à la table Consultation de la BDD projetjava.sql et d'y gérer les informations (ajout, modification...)

public class DaoConsultation
{
	// Retourne un vector des consultations
	@SuppressWarnings("null")
	public static Vector<Consultation> getLesConsultations() 
	{
		Vector<Consultation> lesConsults = new Vector<Consultation>();
		Consultation uneConsultation;
		Statement stLienBd;
		Statement stLienBd2 = null;
		Statement stLienBd3 = null;
		Statement stLienBd4 = null;
		ResultSet resultat = null;
		ResultSet resultatM = null;
		ResultSet resultatPatho = null;
		ResultSet resultatPatient =null;
		
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBd2 = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBd3 = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBd4 = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			//Requête permettant de récuperer toutes les informations d'une consultation
			String requete = "SELECT * FROM Consultation";
			resultat = stLienBd.executeQuery(requete);
			
			// Tant qu'il existe une autre consultation...
			while (resultat.next())
			{
				Medecin unMedecin = null;
				Pathologie unePathologie = null;
				Patient unPatient = null;
				String numMedecin = resultat.getString(4);
				String numPathologie = resultat.getString(2);
				String numPatient = resultat.getString(3);
				String requeteM = "SELECT * from Medecin Where `NUMORDREMEDECIN`='" + numMedecin +"'";
				resultatM = stLienBd2.executeQuery(requeteM);
				
				while (resultatM.next())
				{
					unMedecin = new Medecin(resultatM.getString(1),resultatM.getString(2),resultatM.getString(3),resultatM.getString(4),resultatM.getString(5),resultatM.getString(6));
					System.out.println(unMedecin);
				}
				
				resultatM.close();
				
				String requetePatho = "SELECT * from Pathologie Where `NUMPATHOLOGIE`= '" + numPathologie +"'";
				System.out.println(requetePatho);
				resultatPatho = stLienBd3.executeQuery(requetePatho);
				
				while (resultatPatho.next())
				{
					unePathologie = new Pathologie(resultatPatho.getInt(1),resultatPatho.getString(2));
					System.out.println(unePathologie);
				}
				
				resultatPatho.close();
				
				String requetePatient = "SELECT * from Patient Where `NUMPATIENT` = '" + numPatient +"'";
				System.out.println(requetePatient);
				resultatPatient = stLienBd4.executeQuery(requetePatient);
				
				while (resultatPatient.next())
				{
					unPatient = new Patient(resultatPatient.getInt(1),resultatPatient.getString(2),resultatPatient.getString(3),resultatPatient.getString(4),
					resultatPatient.getString(5),resultatPatient.getString(6),resultatPatient.getString(7));
					System.out.println(unPatient);
				}
				
				resultatPatient.close();
				
				uneConsultation = new Consultation(resultat.getInt(1),unePathologie, unPatient,unMedecin, resultat.getString(5), resultat.getInt(6));
				System.out.println(uneConsultation);
				lesConsults.add(uneConsultation);
			}
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesConsults;
	}
	
	public static boolean AjouterUneConsultation(Consultation unConsultation)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "INSERT INTO Consultation values("+ null +",'"+unConsultation.getUnePathologie().getNumPathologie()+
					"','"+unConsultation.getLePatient().getNumPatient()+"','"+unConsultation.getLeMedecin().getNumOrdreMedecin()+"','"+unConsultation.getDateConsultat()+
					"','"+unConsultation.getHeureConsultat()+"')";
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
	
	public static boolean ModifierUneConsultation(Consultation uneConsultation)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "UPDATE `Consultation` SET `NUMPATHOLOGIE`='"+ uneConsultation.getUnePathologie().getNumPathologie()+
					"',`NUMPATIENT`='" + uneConsultation.getLePatient().getNumPatient()
					+"',`NUMORDREMEDECIN`='" + uneConsultation.getLeMedecin().getNumOrdreMedecin() + "',`DATECONSULT`='"+ uneConsultation.getDateConsultat()+
					"',`HEURECONSULT`='"+ uneConsultation.getHeureConsultat() + "' WHERE `NUMCONSULT`='" + uneConsultation.getNumConsultat();
			//UPDATE `consultation` SET `NUMCONSULT`=[value-1],`NUMPATHOLOGIE`=[value-2],`NUMPATIENT`=[value-3],`NUMORDREMEDECIN`=[value-4],`DATECONSULT`=[value-5],`HEURECONSULT`=[value-6] WHERE 1
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
