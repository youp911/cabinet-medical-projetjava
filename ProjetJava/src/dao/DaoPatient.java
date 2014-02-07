package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import metier.Medecin;
import metier.Patient;

//DaoConsultation permet l'accès à la table Patient de la BDD projetjava.sql et d'y gérer les informations (ajout, modification...)

public class DaoPatient 
{
	
	public static Vector<Patient> getLesPatients() 
	{
		Vector<Patient> lesPatients = new Vector<Patient>();
		Patient unPatient;
		Statement stLienBd;
		ResultSet resultat = null;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "SELECT * FROM Patient";
			resultat = stLienBd.executeQuery(requete);
			while (resultat.next())
			{
				unPatient = new Patient(resultat.getInt(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),
						resultat.getString(5),resultat.getString(6),resultat.getString(7));
				lesPatients.add(unPatient);
			}
			resultat.close();
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}
		
		return lesPatients;
	}
	public static boolean AjouterUnPatient(Patient unPatient)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			
			String requete = "INSERT INTO Patient values("+ null +",'"+unPatient.getNomPatient()+"','"+ unPatient.getPrenomPatient()
					+"','"+unPatient.getAdressePatient()+"','"+unPatient.getCPPatient()+"','"+unPatient.getVillePatient()+"','" + unPatient.getDateNaiss() +"')";
			resultat = stLienBd.executeUpdate(requete);
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
	public static boolean ModifierUnPatient(Patient unPatient)
	{
		boolean res=false;
		Statement stLienBd;
		int resultat;
		try
		{
			stLienBd = MySQLConnection.getConnection("projetjava", "root", "").createStatement();
			String requete = "UPDATE `patient` SET `NUMPATIENT`='"+unPatient.getNumPatient()+"',`NOMPATIENT`='"+
					unPatient.getNomPatient() +"',`PRENOMPATIENT`='"+unPatient.getPrenomPatient()+"',`ADRESSEPATIENT`='"+
					unPatient.getAdressePatient()+"',`CPPATIENT`='"+unPatient.getCPPatient()+"'," +
					"`VILLEPATIENT`='"+unPatient.getVillePatient()+"', `DATENAISSANCE` = '" + unPatient.getDateNaiss() + "'"
					+" WHERE `NUMPATIENT` = '"+unPatient.getNumPatient()+"'"; 
			System.out.println(requete);
			resultat = stLienBd.executeUpdate(requete);
			//UPDATE `patient` SET `NUMPATIENT`='1',`NOMPATIENT`='blabla',`PRENOMPATIENT`='test',`ADRESSEPATIENT`='21 rue test',
			//		`CPPATIENT`='17000',`VILLEPATIENT`='la rochelle',`DATENAISSANCE`="10-10-1260" WHERE `NUMPATIENT`='1'
			MySQLConnection.getConnection("projetjava", "root", "").close();
		}
		catch(SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de données " + e.getMessage());
		}		
		return res;
	}
}
