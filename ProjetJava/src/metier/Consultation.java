package metier;

import java.util.Date;
import java.util.HashMap;

/**
 * @version 2.0
 * @author cchesse rchaille
 */

public class Consultation
{
	private Integer numConsultat;
	private Pathologie unePathologie;
	private Patient lePatient;
	private Medecin leMedecin;
	private String dateConsultat;
	private Integer heureConsultat;
	private HashMap<Medicament,String> uneOrdonnance;
	


	
/**
 * Constructeur d'une consultation
 * @param numConsultat numéro de la consultation
 * @param unePathologie Pathologie de la consultation
 * @param lePatient Patient associé à la consultation
 * @param leMedecin Médecin associé à la consultation
 * @param dateConsultat Date de la consultation (format AAAA-MM-JJ)
 * @param heureConsultat Heure de la consultation 
 * @see #Patient
 * @see #Medecin
 */
	public Consultation(Integer numConsultat, Pathologie unePathologie,
			Patient lePatient, Medecin leMedecin, String dateConsultat,
			Integer heureConsultat) {
		super();
		this.numConsultat = numConsultat;
		this.unePathologie = unePathologie;
		this.lePatient = lePatient;
		this.leMedecin = leMedecin;
		this.dateConsultat = dateConsultat;
		this.heureConsultat = heureConsultat;
	}


	/**
	 * Constructeur d'une consultation
	 * @param numConsultat numéro de la consultation
	 * @param dateConsultat Date de la consultation (format AAAA-MM-JJ)
	 * @param heureConsultat Heure de la consultation 
	 * @param lePatient Patient associé à la consultation
	 * @param leMedecin Médecin associé à la consultation
	 * @param unePathologie Pathologie de la consultation
	 * @see #Patient
	 * @see #Medecin
	 */

	public Consultation(Integer numConsultat, String dateConsultat,
			Integer heureConsultat, Medecin leMedecin, Patient lePatient, Pathologie unePathologie) {
		super();
		this.numConsultat = numConsultat;
		this.dateConsultat = dateConsultat;
		this.heureConsultat = heureConsultat;
		this.leMedecin = leMedecin;
		this.lePatient = lePatient;
		this.unePathologie = unePathologie;
		this.uneOrdonnance = new HashMap<Medicament,String>();
	}

/**
 * Acesseur en lecture d'un patient
 * @return lePatient
 * @see #Patient
 */
	
	public Patient getLePatient() {
		return lePatient;
	}
	
/**
 * Acesseur en lecture d'une ou plusieurs ordonnance(s)
 * @return uneOrdonnance
 * @see #Ordonnance
 */

	public HashMap<Medicament, String> getUneOrdonnance() {
		return uneOrdonnance;
	}

	/**
	 * Acesseur en lecture d'une pathologie
	 * @return unePathologie
	 * @see #Pathologie
	 */
	
	public Pathologie getUnePathologie() {
		return unePathologie;
	}

	/**
	 * Acesseur en lecture d'un médecin
	 * @return leMédecin
	 * @see #Medecin
	 */
	
	public Medecin getLeMedecin() {
		return leMedecin;
	}
	
	/**
	 * Acesseur en lecture d'un numéro de consultation
	 * @return numConsultat
	 * @see #Consultation
	 */
	
	public Integer getNumConsultat() {
		return numConsultat;
	}

	/**
	 * Acesseur en lecture d'une date de consultation
	 * @return dateConsultat
	 * @see #Consultation
	 */
	
	public String getDateConsultat() {
		return dateConsultat;
	}

	/**
	 * Acesseur en lecture d'une heure de consultation
	 * @return heureConsultat
	 * @see #Consultation
	 */
	
	public Integer getHeureConsultat() {
		return heureConsultat;
	}
	
	/**
	 * Permet l'ajout d'un médicament
	 * @param unMedicament le médicament à ajouter
	 * @param unePosologie la posologie associé au médicament à ajouter
	 */
	
	public void ajoutMedPoso(Medicament unMedicament, String unePosologie)
	{
		this.uneOrdonnance.put(unMedicament, unePosologie);
	}

	/**
	 * Affiche les informations d'une consultation sous forme d'une chaine de caractère
	 */
	@Override
	public String toString() {
		return "Consultation [numConsultat=" + numConsultat
				+ ", dateConsultat=" + dateConsultat + ", heureConsultat="
				+ heureConsultat + ", leMedecin=" + leMedecin + ", lePatient="
				+ lePatient + ", uneOrdonnance=" + uneOrdonnance
				+ ", unePathologie=" + unePathologie + "]";
	}
	
}
