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
	 * Constructeur d'un médicament
	 * @param numMedicament numéro du médicament
	 * @param nomMedicament nom du médicament
	 * @param descriptionMedicament déscription du médicament
	 */
	
	public Medicament(Integer numMedicament, String nomMedicament,
			String descriptionMedicament) {
		super();
		this.numMedicament = numMedicament;
		this.nomMedicament = nomMedicament;
		DescriptionMedicament = descriptionMedicament;
	}
	
	/**
	 * Acesseur en lecture d'un numéro de médicament
	 * @return numMedicament
	 */
	public Integer getNumMedicament() {
		return numMedicament;
	}
	
	/**
	 * Acesseur en lecture d'un nom de médicament
	 * @return numMedicament
	 */
	public String getNomMedicament() {
		return nomMedicament;
	}
	
	/**
	 * Acesseur en lecture d'une description de médicament
	 * @return numMedicament
	 */
	public String getDescriptionMedicament() {
		return DescriptionMedicament;
	}
	
	/**
	 * Affiche les informations d'un médicament sous forme d'une chaine de caractère
	 */
	@Override
	public String toString() {
		return numMedicament + "	 |	 " + nomMedicament
				+ "	|	 " + DescriptionMedicament;
	}
	
	
}
