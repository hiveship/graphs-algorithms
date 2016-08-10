package fr.enssat.mnantel;

public interface GrapheValue extends Graphe
{

	/** Retourne le poids de la liaison entre 'source' et 'destination' */
	int getPoids(Sommet source, Sommet destination);

	/**
	 * Ajoute une liaison entre 'source' et 'destination' (deux liaisons si le
	 * graphe est non orienté)
	 */
	void ajouterArc(Sommet source, Sommet destination, int poids);

	/** Retourne la liste d'adjacence du graphe */
	Adjacence<Integer> getAdjacence();

}
