package metier;

import java.util.ArrayList;


/**
 * @version 2.0
 * @author cchesse rchaille
 */

public class Medecin 
{

	private String numOrdreMedecin;
	private String nomMedecin;
	private String prenomMedecin;
	private String adresseMedecin;
	private String CPMedecin;
	private String VilleMedecin;
	private ArrayList<Consultation> lesConsultations;
	private ArrayList<Medecin> lesMedecins = new ArrayList<Medecin>();
	
/**
 * 
 * @param numOrdreMedecin num�ro du m�decin (10 chiffres)
 * @param nomMedecin nom du m�decin
 * @param prenomMedecin pr�nom du m�decin
 * @param adresseMedecin adresse du m�decin
 * @param cPMedecin code postal du m�decin
 * @param villeMedecin ville du m�decin
 * @param lesConsultations les consultations associ�es au m�decin
 * @see #Consultation
 */
	public Medecin(String numOrdreMedecin, String nomMedecin,
			String prenomMedecin, String adresseMedecin, String cPMedecin,
			String villeMedecin, ArrayList<Consultation> lesConsultations) {
		super();
		this.numOrdreMedecin = numOrdreMedecin;
		this.nomMedecin = nomMedecin;
		this.prenomMedecin = prenomMedecin;
		this.adresseMedecin = adresseMedecin;
		CPMedecin = cPMedecin;
		VilleMedecin = villeMedecin;
		this.lesConsultations = lesConsultations;
	}
	
	/**
	 * Constructeur d'un m�decin (sans consultations associ�es)
	 * @param numOrdreMedecin num�ro d'ordre du m�decin (10 chiffres)
	 * @param nomMedecin nomdu m�decin
	 * @param prenomMedecin pr�nom du m�decin
	 * @param adresseMedecin adresse du m�decin
	 * @param cPMedecin code postal du m�decin
	 * @param villeMedecin ville du m�decin
	 */
	public Medecin(String numOrdreMedecin, String nomMedecin,
			String prenomMedecin, String adresseMedecin, String cPMedecin,
			String villeMedecin) {
		super();
		this.numOrdreMedecin = numOrdreMedecin;
		this.nomMedecin = nomMedecin;
		this.prenomMedecin = prenomMedecin;
		this.adresseMedecin = adresseMedecin;
		CPMedecin = cPMedecin;
		VilleMedecin = villeMedecin;
	}

	/**
	 * Acesseur en lecture d'une ou plusieurs consultation(s)
	 * @return lesConsultations
	 * @see #Consultation
	 */
	public ArrayList<Consultation> getLesConsultations() {
		return lesConsultations;
	}
	
	/**
	 * Acesseur en lecture d'un num�ro de m�decin
	 * @return numOrdreMedecin
	 * @see #Medecin
	 */
	
	public String getNumOrdreMedecin() {
		return numOrdreMedecin;
	}
	
	/**
	 * Acesseur en lecture d'un ou plusieurs m�decin(s)
	 * @return lesMedecins
	 * @see #Medecin
	 */
	
	public ArrayList<Medecin> getLesMedecins() {
		return lesMedecins;
	}
	
	/**
	 * Acesseur en lecture du nom du m�decin
	 * @return nomMedecins
	 * @see #Medecin
	 */
	
	public String getNomMedecin() {
		return nomMedecin;
	}

	/**
	 * Acesseur en lecture du prenom du m�decin
	 * @return prenomMedecins
	 * @see #Medecin
	 */
	
	public String getPrenomMedecin() {
		return prenomMedecin;
	}

	/**
	 * Acesseur en lecture de l'adresse du m�decin
	 * @return adresseMedecins
	 * @see #Medecin
	 */
	
	public String getAdresseMedecin() {
		return adresseMedecin;
	}

	/**
	 * Acesseur en lecture du code postal du m�decin
	 * @return CPMedecins
	 * @see #Medecin
	 */
	
	public String getCPMedecin() {
		return CPMedecin;
	}

	/**
	 * Acesseur en lecture de la ville du m�decin
	 * @return prenomMedecins
	 * @see #Medecin
	 */ 
	
	public String getVilleMedecin() {
		return VilleMedecin;
	}
	
	/**
	 * Affiche les informations d'un m�decin sous forme d'une chaine de caract�re
	 */
	@Override
	public String toString() {
		return "Medecin [numOrdreMedecin=" + numOrdreMedecin + ", nomMedecin="
				+ nomMedecin + ", prenomMedecin=" + prenomMedecin + "]";
	}
	
}
