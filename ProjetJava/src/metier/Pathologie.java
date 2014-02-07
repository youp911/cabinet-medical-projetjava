package metier;

/**
 * @version 2.0
 * @author cchesse rchaille
 */

import java.util.HashMap;

public class Pathologie 
{
	private Integer numPathologie;
	private String libellePathologie;
	private HashMap<Medicament,String> uneOrdonnance;
	
	/**
	 * Constructeur d'une pathologie
	 * @param numPathologie numéro de la pathologie
	 * @param libellePathologie libelle de la pathologie
	 */
	public Pathologie(Integer numPathologie, String libellePathologie) 
	{
		super();
		this.numPathologie = numPathologie;
		this.libellePathologie = libellePathologie;
		this.uneOrdonnance = new HashMap<Medicament,String>();
	}
	
	/**
	 * Acesseur en lecture d'une ordonnance 
	 * @return uneOrdonnance
	 * @see #Ordonnance
	 */
	public HashMap<Medicament, String> getUneOrdonnance() {
		return uneOrdonnance;
	}

	/**
	 * Acesseur en lecture du numéro d'une pathologie
	 * @return numPathologie
	 */
	public Integer getNumPathologie() {
		return numPathologie;
	}
	
	/**
	 * Acesseur en lecture du libelle d'une pathologie
	 * @return libellePathologie
	 */
	public String getLibellePathologie() {
		return libellePathologie;
	}

	/**
	 * Affiche les informations d'une pathologie sous forme d'une chaine de caractère
	 */
	@Override
	public String toString() {
		return "Numéro Pathologie : " + numPathologie
				+ ", libellé Pathologie =" + libellePathologie;
	}
	

}
