package fr.enssat.mnantel;

import java.util.HashMap;
import java.util.Set;

public class GrapheNonValueImpl extends AbstractGraphe implements GrapheNonValue
{
	private final Adjacence<Sommet> adjacence;

	public GrapheNonValueImpl(boolean oriente)
	{
		super(oriente);
		this.adjacence = new Adjacence<>();
	}

	// =======
	// GETTERS
	// =======

	@Override
	public Adjacence<Sommet> getAdjacence()
	{
		return adjacence;
	}

	// ====
	// ARCS
	// ====

	@Override
	public boolean existeArc(Sommet source, Sommet destination)
	{
		return adjacence.estAdjacent(source, destination);
	}

	@Override
	public void ajouterArc(Sommet source, Sommet destination, Sommet predecesseur)
	{
		ajouterSommet(source);
		ajouterSommet(destination);
		adjacence.getList().get(source).put(destination, predecesseur);
		if ( !estOriente() ) { // On ajoute l'arc en sens inverse aussi
			adjacence.getList().get(destination).put(source, predecesseur);
		}
	}

	@Override
	public void ajouterArc(Sommet source, Sommet destination)
	{
		ajouterArc(source, destination, null);
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
			adjacence.getList().put(sommet, new HashMap<Sommet, Sommet>());
		}
	}
}
