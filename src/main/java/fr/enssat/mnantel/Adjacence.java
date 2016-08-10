package fr.enssat.mnantel;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Représente une liste d'adjacence.
 */
public class Adjacence<T>
{
	private final HashMap<Sommet, HashMap<Sommet, T>> listeAdjacence;

	public Adjacence()
	{
		this.listeAdjacence = new HashMap<>();
	}

	public HashMap<Sommet, HashMap<Sommet, T>> getList()
	{
		return listeAdjacence;
	}

	/**
	 * Deux sommets sont dit adjacents si à partir d'un sommet "source", il est
	 * possible d'atteindre le sommet "destination"
	 */
	public boolean estAdjacent(Sommet source, Sommet destination)
	{
		if ( listeAdjacence.containsKey(source) ) {
			if ( listeAdjacence.get(source).containsKey(destination) ) {
				return true;
			}
		}
		return false;
	}

	public boolean memeArcs(Adjacence<T> other)
	{
		if ( !listeAdjacence.keySet().equals(other.listeAdjacence.keySet()) ) {
			// Les deux listes ne contiennent pas les mêmes sommets donc n'auront forcément pas les même arcs
			return false;
		}

		for ( Entry<Sommet, HashMap<Sommet, T>> item : listeAdjacence.entrySet() ) {
			Sommet source = item.getKey();
			HashMap<Sommet, T> liens = item.getValue();
			HashMap<Sommet, T> autreLiens = other.listeAdjacence.get(source);
			if ( !liens.keySet().equals(autreLiens.keySet()) ) {
				return false;
			}
		}

		return true;
	}

	// Si on veux comparer que les deux graphes ont aussi les mêmes valeurs associés, utiliser directement la méthode 'equals'.
}
