package fr.enssat.mnantel;

public interface GrapheNonValue extends Graphe
{
	/**
	 * Ajoute une liaison entre 'source' et 'destination' (deux liaisons si le
	 * graphe est non orienté). Le prédécesseur servira à calculer le routage
	 * avec l'algorithme de Warshall.
	 */
	void ajouterArc(Sommet source, Sommet destination, Sommet predecesseur);

	void ajouterArc(Sommet source, Sommet destination);

	/** Retourne la liste d'adjacence du graphe */
	Adjacence<Sommet> getAdjacence();

}
