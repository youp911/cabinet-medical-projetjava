package metier;

/**
 * @version 2.0
 * @author cchesse rchaille
 */

import java.util.ArrayList;
import java.util.Date;

public class Patient 
{
	private Integer numPatient;
	private String nomPatient;
	private String prenomPatient;
	private String adressePatient;
	private String cpPatient;
	private String villePatient;
	private String dateNaiss;
	private ArrayList<Consultation> lesConsultations;
	
	/**
	 * Constructeur d'un patient
	 * @param numPatient numéro du patient
	 * @param nomPatient nom du patient
	 * @param prenomPatient prenom du patient
	 * @param adressePatient adresse du patient
	 * @param cpPatient code postal du patient
	 * @param villePatient ville du patient
	 * @param dateNaiss sate de naissance d'un médicament
	 */
	
		// TODO Auto-generated constructor stub
	public Patient(Integer numPatient, String nomPatient, String prenomPatient,
			String adressePatient, String cpPatient, String villePatient,
			String dateNaiss) {
		super();
		this.numPatient = numPatient;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.adressePatient = adressePatient;
		this.cpPatient = cpPatient;
		this.villePatient = villePatient;
		this.dateNaiss = dateNaiss;
	}

	/**
	 * Affiche les informations d'un patient sous forme d'une chaine de caractère
	 */
	
	@Override
	public String toString() {
		return "numPatient=" + numPatient + ", nomPatient="
				+ nomPatient + ", prenomPatient=" + prenomPatient;
	}



	/**
	 * Acesseur en lecture de la date de naissance d'un patient
	 * @return dateNaiss
	 */
	public String getDateNaiss() {
		return dateNaiss;
	}

	/**
	 * Acesseur en lecture du numéro d'un patient
	 * @return numPatient
	 */
	public Integer getNumPatient() {
		return numPatient;
	}

	/**
	 * Acesseur en lecture du nom d'un patient
	 * @return nomPatient
	 */
	public String getNomPatient() {
		return nomPatient;
	}

	/**
	 * Acesseur en lecture du prénom d'un patient
	 * @return prenomPatient
	 */
	public String getPrenomPatient() {
		return prenomPatient;
	}

	/**
	 * Acesseur en lecture de l'adresse d'un patient
	 * @return adressePatient
	 */
	public String getAdressePatient() {
		return adressePatient;
	}

	/**
	 * Acesseur en lecture d'un code postal d'un patient
	 * @return cpPatient
	 */
	public String getCPPatient() {
		return cpPatient;
	}

	/**
	 * Acesseur en lecture de la ville d'un patient
	 * @return villePatient
	 */
	public String getVillePatient() {
		return villePatient;
	}

	/**
	 * Acesseur en lecture de la / des consultation(s) du patient
	 * @return lesConsultations
	 * @see #Consultation
	 */
	public ArrayList<Consultation> getLesConsultations() {
		return lesConsultations;
	}
	
	
}
