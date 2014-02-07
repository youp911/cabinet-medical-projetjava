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
 * @param numOrdreMedecin numéro du médecin (10 chiffres)
 * @param nomMedecin nom du médecin
 * @param prenomMedecin prénom du médecin
 * @param adresseMedecin adresse du médecin
 * @param cPMedecin code postal du médecin
 * @param villeMedecin ville du médecin
 * @param lesConsultations les consultations associées au médecin
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
	 * Constructeur d'un médecin (sans consultations associées)
	 * @param numOrdreMedecin numéro d'ordre du médecin (10 chiffres)
	 * @param nomMedecin nomdu médecin
	 * @param prenomMedecin prénom du médecin
	 * @param adresseMedecin adresse du médecin
	 * @param cPMedecin code postal du médecin
	 * @param villeMedecin ville du médecin
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
	 * Acesseur en lecture d'un numéro de médecin
	 * @return numOrdreMedecin
	 * @see #Medecin
	 */
	
	public String getNumOrdreMedecin() {
		return numOrdreMedecin;
	}
	
	/**
	 * Acesseur en lecture d'un ou plusieurs médecin(s)
	 * @return lesMedecins
	 * @see #Medecin
	 */
	
	public ArrayList<Medecin> getLesMedecins() {
		return lesMedecins;
	}
	
	/**
	 * Acesseur en lecture du nom du médecin
	 * @return nomMedecins
	 * @see #Medecin
	 */
	
	public String getNomMedecin() {
		return nomMedecin;
	}

	/**
	 * Acesseur en lecture du prenom du médecin
	 * @return prenomMedecins
	 * @see #Medecin
	 */
	
	public String getPrenomMedecin() {
		return prenomMedecin;
	}

	/**
	 * Acesseur en lecture de l'adresse du médecin
	 * @return adresseMedecins
	 * @see #Medecin
	 */
	
	public String getAdresseMedecin() {
		return adresseMedecin;
	}

	/**
	 * Acesseur en lecture du code postal du médecin
	 * @return CPMedecins
	 * @see #Medecin
	 */
	
	public String getCPMedecin() {
		return CPMedecin;
	}

	/**
	 * Acesseur en lecture de la ville du médecin
	 * @return prenomMedecins
	 * @see #Medecin
	 */ 
	
	public String getVilleMedecin() {
		return VilleMedecin;
	}
	
	/**
	 * Affiche les informations d'un médecin sous forme d'une chaine de caractère
	 */
	@Override
	public String toString() {
		return "Medecin [numOrdreMedecin=" + numOrdreMedecin + ", nomMedecin="
				+ nomMedecin + ", prenomMedecin=" + prenomMedecin + "]";
	}
	
}
