package metier;

/**
 * @version 2.0
 * @author cchesse rchaille
 */

public class Medicament 
{
	private Integer numMedicament;
	private String nomMedicament;
	private String DescriptionMedicament;
	
	/**
	 * Constructeur d'un m�dicament
	 * @param numMedicament num�ro du m�dicament
	 * @param nomMedicament nom du m�dicament
	 * @param descriptionMedicament d�scription du m�dicament
	 */
	
	public Medicament(Integer numMedicament, String nomMedicament,
			String descriptionMedicament) {
		super();
		this.numMedicament = numMedicament;
		this.nomMedicament = nomMedicament;
		DescriptionMedicament = descriptionMedicament;
	}
	
	/**
	 * Acesseur en lecture d'un num�ro de m�dicament
	 * @return numMedicament
	 */
	public Integer getNumMedicament() {
		return numMedicament;
	}
	
	/**
	 * Acesseur en lecture d'un nom de m�dicament
	 * @return numMedicament
	 */
	public String getNomMedicament() {
		return nomMedicament;
	}
	
	/**
	 * Acesseur en lecture d'une description de m�dicament
	 * @return numMedicament
	 */
	public String getDescriptionMedicament() {
		return DescriptionMedicament;
	}
	
	/**
	 * Affiche les informations d'un m�dicament sous forme d'une chaine de caract�re
	 */
	@Override
	public String toString() {
		return numMedicament + "	 |	 " + nomMedicament
				+ "	|	 " + DescriptionMedicament;
	}
	
	
}
