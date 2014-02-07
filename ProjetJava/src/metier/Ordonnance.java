package metier;

/**
 * @version 2.0
 * @author cchesse rchaille
 */

public class Ordonnance {

	Medicament unMedicament;
	Consultation uneConsultation;
	String unePosologie;
	
	/**
	 * 
	 * @param unMedicament médicament ajouté à l'ordonnance
	 * @param uneConsultation consultation associée à l'ordonnance
	 * @param unePosologie posologie associée à l'ordonnance
	 */
	
	public Ordonnance(Medicament unMedicament, Consultation uneConsultation,
			String unePosologie) {
		super();
		this.unMedicament = unMedicament;
		this.uneConsultation = uneConsultation;
		this.unePosologie = unePosologie;
	}
	
	/**
	 * Acesseur en lecture d'un médicament
	 * @return unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}
	
	/**
	 * Acesseur en lecture d'une consultation
	 * @return uneConsultation
	 */
	public Consultation getUneConsultation() {
		return uneConsultation;
	}
	
	/**
	 * Acesseur en lecture d'une posologie
	 * @return unePosologie
	 */
	public String getUnePosologie() {
		return unePosologie;
	}
	
	/**
	 * Affiche les informations d'une ordonnance sous forme d'une chaine de caractère
	 */
	@Override
	public String toString() {
		return "Ordonnance [unMedicament=" + unMedicament
				+ ", uneConsultation=" + uneConsultation + ", unePosologie="
				+ unePosologie + "]";
	}
}
