package fr.enssat.mnantel;

public class Sommet
{
	private final String label;

	public Sommet(String label)
	{
		this.label = label;
	}

	/**
	 * Informations du sommet. Ici juste une chaine de caractère mais pourait
	 * être beaucoup plus complexe.
	 */
	public String getLabel()
	{
		return label;
	}

	@Override
	public String toString()
	{
		return "Sommet " + label;
	}

}
