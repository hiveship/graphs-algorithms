package fr.enssat.mnantel;

import java.util.Set;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// Commun aux graphes valués et non valués
public abstract class AbstractGraphe implements Graphe
{
	private final boolean oriente;

	public AbstractGraphe(boolean oriente)
	{
		this.oriente = oriente;
	}

	// ==========
	// PROPRIETES
	// ==========

	@Override
	public boolean estOriente()
	{
		return oriente;
	}

	@Override
	public boolean estVide()
	{
		return getSommets().isEmpty();
	}

	@Override
	public int taille()
	{
		return getSommets().size();
	}

	@Override
	public boolean estValue()
	{
		throw new NotImplementedException();
	}

	// =======
	// SOMMETS
	// =======

	@Override
	public boolean existeSommet(Sommet sommet)
	{
		return getSommets().contains(sommet);
	}

	@Override
	public void retirerSommet(Sommet sommet)
	{
		throw new NotImplementedException();
	}

	@Override
	public int getDegre(Sommet sommet)
	{
		return getDegreEntrant(sommet) + getDegreSortant(sommet);
	}

	@Override
	public int getDegreSortant(Sommet sommet)
	{
		throw new NotImplementedException();
	}

	@Override
	public int getDegreEntrant(Sommet sommet)
	{
		throw new NotImplementedException();
	}

	@Override
	public Set<Sommet> getSuccesseurs(Sommet s)
	{
		throw new NotImplementedException();
	}

	@Override
	public Set<Sommet> getPredecesseurs(Sommet s)
	{
		throw new NotImplementedException();
	}

	// ====
	// ARCS
	// ====

	@Override
	public void retirerArc(Sommet source, Sommet destination)
	{
		throw new NotImplementedException();
	}

}
