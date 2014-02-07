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
		Vector<Ordonnance> lesPaths = new Vector<Ordonnance>();
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
			System.out.println(requete);
			while (resultat.next())
			{
				String requeteMedoc = "Select * from Medicament where NUMMEDICAMENT = '" + resultat.getString(1) + "'";
				resultat2 = stLienBd2.executeQuery(requeteMedoc);
				System.out.println(resultat2);
				
				while(resultat2.next())
				{
					unMedicament = new Medicament(resultat2.getInt(1),resultat2.getString(2), resultat2.getString(3));
					System.out.println(unMedicament);
				}			
					
						String requeteConsult = "Select * from Consultation where NUMCONSULT = '" + resultat.getString(2) +"'";
						resultat3 = stLienBd3.executeQuery(requeteConsult);
						System.out.println(resultat3);
						
						while (resultat3.next())
						{
							Medecin unMedecin = null;
							Pathologie unePathologie = null;
							Patient unPatient = null;
							String numMedecin = resultat3.getString(4);
							String numPathologie = resultat3.getString(2);
							String numPatient = resultat3.getString(3);
							String requeteM = "SELECT * from Medecin Where `NUMORDREMEDECIN`='" + numMedecin +"'";
							resultatM = stLienBdM.executeQuery(requeteM);
							
							while (resultatM.next())
							{
								unMedecin = new Medecin(resultatM.getString(1),resultatM.getString(2),resultatM.getString(3),resultatM.getString(4),resultatM.getString(5),resultatM.getString(6));
								System.out.println(unMedecin);
							}
							
							resultatM.close();
							
							String requetePatho = "SELECT * from Pathologie Where `NUMPATHOLOGIE`= '" + numPathologie +"'";
							System.out.println(requetePatho);
							resultatPatho = stLienBdPatho.executeQuery(requetePatho);
							
							while (resultatPatho.next())
							{
								unePathologie = new Pathologie(resultatPatho.getInt(1),resultatPatho.getString(2));
								System.out.println(unePathologie);
							}
							
							resultatPatho.close();
							
							String requetePatient = "SELECT * from Patient Where `NUMPATIENT` = '" + numPatient +"'";
							System.out.println(requetePatient);
							resultatPatient = stLienBdPatient.executeQuery(requetePatient);
							
							while (resultatPatient.next())
							{
								unPatient = new Patient(resultatPatient.getInt(1),resultatPatient.getString(2),resultatPatient.getString(3),resultatPatient.getString(4),
								resultatPatient.getString(5),resultatPatient.getString(6),resultatPatient.getString(7));
								System.out.println(unPatient);
							}
							
							resultatPatient.close();
							
							uneConsultation = new Consultation(resultat3.getInt(1),unePathologie, unPatient,unMedecin, resultat3.getString(5), resultat3.getInt(6));
							System.out.println(uneConsultation);
						}
						
						resultat.close();
						MySQLConnection.getConnection("projetjava", "root", "").close();
						
						uneOrdonnance = new Ordonnance(unMedicament,uneConsultation, resultat.getString(3));
						lesPaths.add(uneOrdonnance);
						
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
			//UPDATE `Ordonnance` SET `NUMOrdonnance`=[value-1],`LIBELLEOrdonnance`=[value-2] WHERE 1
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
