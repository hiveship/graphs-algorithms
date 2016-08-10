package fr.enssat.mnantel;

import java.util.HashMap;
import java.util.Set;

public class GrapheValueImpl extends AbstractGraphe implements GrapheValue
{
	private final Adjacence<Integer> adjacence;

	public GrapheValueImpl(boolean oriente)
	{
		super(oriente);
		this.adjacence = new Adjacence<>();
	}

	// =======
	// GETTERS
	// =======

	@Override
	public Adjacence<Integer> getAdjacence()
	{
		return adjacence;
	}

	// =======
	// SOMMETS
	// =======

	@Override
	public Set<Sommet> getSommets()
	{
		return adjacence.getList().keySet();
	}

	@Override
	public Set<Sommet> getSommetsAdjacents(Sommet source)
	{
		return adjacence.getList().get(source).keySet();
	}

	@Override
	public void ajouterSommet(Sommet sommet)
	{
		if ( !adjacence.getList().containsKey(sommet) ) {
			adjacence.getList().put(sommet, new HashMap<Sommet, Integer>());
		}
	}

	// ====
	// ARCS
	// ====

	@Override
	public void ajouterArc(Sommet source, Sommet destination, int poids)
	{
		ajouterSommet(source);
		ajouterSommet(destination);
		adjacence.getList().get(source).put(destination, poids);
		if ( !estOriente() ) { // On ajoute l'arc en sens inverse aussi
			adjacence.getList().get(destination).put(source, poids);
		}
	}

	@Override
	public boolean existeArc(Sommet source, Sommet destination)
	{
		return adjacence.estAdjacent(source, destination);
	}

	// =========
	// VALUATION
	// =========

	/**
	 * Retourne le poid de l'arc permettant de se rentre de Source vers
	 * Destination. Si il n'éxiste pas d'arc dans le graphe entre 'source' et
	 * 'destination', on retourne une valeur infinie (simulée par
	 * Integer.MAX_VALUE).
	 */
	@Override
	public int getPoids(Sommet source, Sommet destination)
	{
		if ( source == destination ) {
			return 0;
		} else {
			// Sommets accéssibles directement depuis la source
			HashMap<Sommet, Integer> sommetsAdjacents = adjacence.getList().get(source);
			if ( sommetsAdjacents.containsKey(destination) ) {
				return sommetsAdjacents.get(destination);
			}
		}
		return Integer.MAX_VALUE;
	}
}
