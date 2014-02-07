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
	 * @param unMedicament m�dicament ajout� � l'ordonnance
	 * @param uneConsultation consultation associ�e � l'ordonnance
	 * @param unePosologie posologie associ�e � l'ordonnance
	 */
	
	public Ordonnance(Medicament unMedicament, Consultation uneConsultation,
			String unePosologie) {
		super();
		this.unMedicament = unMedicament;
		this.uneConsultation = uneConsultation;
		this.unePosologie = unePosologie;
	}
	
	/**
	 * Acesseur en lecture d'un m�dicament
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
	 * Affiche les informations d'une ordonnance sous forme d'une chaine de caract�re
	 */
	@Override
	public String toString() {
		return "Ordonnance [unMedicament=" + unMedicament
				+ ", uneConsultation=" + uneConsultation + ", unePosologie="
				+ unePosologie + "]";
	}
}
