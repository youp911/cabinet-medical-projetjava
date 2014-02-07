package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import metier.Consultation;
import metier.Medecin;
import metier.Medicament;
import metier.Ordonnance;
import metier.Pathologie;
import metier.Patient;

//DaoConsultation permet l'accès à la table Ordonnance de la BDD projetjava.sql et d'y gérer les informations (ajout, modification...)

public class DaoOrdonnance {

	public static Vector<Ordonnance> getLesOrdonnances() 
	{
		Vector<Ordonnance> lesOrdonnances = new Vector<Ordonnance>();
		Ordonnance uneOrdonnance;
		Statement stLienBd;
		Statement stLienBd2;
		Statement stLienBd3;
		ResultSet resultat = null;
		ResultSet resultat2 =null;
		ResultSet resultat3 = null;
		Consultation uneConsultation = null;
		Medicament unMedicament = null;
		
		
		Statement stLienBdM = null;
		Statement stLienBdPatho = null;
		Statement stLienBdPatient = null;
		ResultSet resultatM = null;
		ResultSet resultatPatho = null;
		ResultSet resultatPatient =null;
		
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBdM = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBdPatho = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBdPatient = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBd2 = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBd3 = MySQLConnection.getConnection("projetjava", "root", "").createStatement();

			
			String requete = "SELECT * FROM Ordonnance";
			resultat = stLienBd.executeQuery(requete);
			
			while (resultat.next())
			{
				String requeteMedoc = "Select * from Medicament where NUMMEDICAMENT = '" + resultat.getString(1) + "'";
				resultat2 = stLienBd2.executeQuery(requeteMedoc);
				
				
				while(resultat2.next())
				{
					unMedicament = new Medicament(resultat2.getInt(1),resultat2.getString(2), resultat2.getString(3));
					
				}			
					
						String requeteConsult = "Select * from Consultation where NUMCONSULT = '" + resultat.getString(2) +"'";
						resultat3 = stLienBd3.executeQuery(requeteConsult);
						
						
						while (resultat3.next())
						{
							Medecin unMedecin = null;
							Pathologie unePathologie = null;
							Patient unPatient = null;
							String numMedecin = resultat3.getString(4);
							String numPathologie = resultat3.getString(2);
							String numPatient = resultat3.getString(3);
							String requeteM = "SELECT * from Medecin Where `NUMORDREMEDECIN`='" + numMedecin +"'";
							
							
							while (resultatM.next())
							{
								unMedecin = new Medecin(resultatM.getString(1),resultatM.getString(2),resultatM.getString(3),resultatM.getString(4),resultatM.getString(5),resultatM.getString(6));
								
							}
							
							resultatM.close();
							
							String requetePatho = "SELECT * from Pathologie Where `NUMPATHOLOGIE`= '" + numPathologie +"'";
							
							resultatPatho = stLienBdPatho.executeQuery(requetePatho);
							
							while (resultatPatho.next())
							{
								unePathologie = new Pathologie(resultatPatho.getInt(1),resultatPatho.getString(2));
								
							}
							
							resultatPatho.close();
							
							String requetePatient = "SELECT * from Patient Where `NUMPATIENT` = '" + numPatient +"'";
							
							resultatPatient = stLienBdPatient.executeQuery(requetePatient);
							
							while (resultatPatient.next())
							{
								unPatient = new Patient(resultatPatient.getInt(1),resultatPatient.getString(2),resultatPatient.getString(3),resultatPatient.getString(4),
								resultatPatient.getString(5),resultatPatient.getString(6),resultatPatient.getString(7));
								
							}
							
							resultatPatient.close();
							
							uneConsultation = new Consultation(resultat3.getInt(1),unePathologie, unPatient,unMedecin, resultat3.getString(5), resultat3.getInt(6));
							
						}
						
						resultat.close();
						MySQLConnection.getConnection("projetjava", "root", "").close();
						
						uneOrdonnance = new Ordonnance(unMedicament,uneConsultation, resultat.getString(3));
						lesOrdonnances.add(uneOrdonnance);
						
				}
			
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesOrdonnances;
	}
	public static boolean AjouterUneOrdonnance(Ordonnance uneOrdonnance)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "INSERT INTO Ordonnance values('"+ uneOrdonnance.getUnMedicament().getNumMedicament()+"','"+
			uneOrdonnance.getUneConsultation().getNumConsultat()+"','"+uneOrdonnance.getUnePosologie()+"')";
			resultat = stLienBd.executeUpdate(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	public static boolean ModifierUneOrdonnance(Ordonnance uneOrdonnance, String ancienMedicament)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "UPDATE `Ordonnance` SET `NUMMEDICAMENT`='" + uneOrdonnance.getUnMedicament().getNumMedicament()+
					"', `NUMCONSULT`= '"+uneOrdonnance.getUneConsultation().getNumConsultat()+"','"
					+"', POSOLOGIE = '" + uneOrdonnance.getUnePosologie() + "' WHERE NUMMEDICAMENT = '" + ancienMedicament +"'"; 
			
			resultat = stLienBd.executeUpdate(requete);
			
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	
	public static Vector<Ordonnance> getLesOrdonnancesDUneConsultation(Consultation laConsultation) 
	{
		Vector<Ordonnance> lesOrdonnances = new Vector<Ordonnance>();
		Ordonnance uneOrdonnance;
		Statement stLienBd;
		Statement stLienBd2;
		
		ResultSet resultat = null;
		ResultSet resultat2 =null;
		
		Medicament unMedicament = null;	
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			stLienBd2 = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "SELECT * FROM Ordonnance where NumConsult = " + laConsultation.getNumConsultat();
			resultat = stLienBd.executeQuery(requete);
			
			while (resultat.next())
			{
				String requeteMedoc = "Select * from Medicament where NUMMEDICAMENT = " + resultat.getString(1) + "";
				resultat2 = stLienBd2.executeQuery(requeteMedoc);
				
				
				while(resultat2.next())
				{
					unMedicament = new Medicament(resultat2.getInt(1),resultat2.getString(2), resultat2.getString(3));
					
				}			
					
				
				MySQLConnection.getConnection("projetjava", "root", "").close();
						
				uneOrdonnance = new Ordonnance(unMedicament,laConsultation, resultat.getString(3));
				lesOrdonnances.add(uneOrdonnance);
						
			}
			
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesOrdonnances;
	}
	
	public static boolean supprimerUneOrdonnance(Ordonnance uneOrdonnance)
	{
		Statement stLienBd;
		int resultat = 0;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			String requete = "DELETE FROM Ordonnance where NumConsult = " + uneOrdonnance.getUneConsultation().getNumConsultat() + " and NUMMEDICAMENT = " + uneOrdonnance.getUnMedicament().getNumMedicament();
			resultat = stLienBd.executeUpdate(requete);
			System.out.println(requete);
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		return false;
		
		}
	}

