package fr.enssat.mnantel.dijkstra;

import fr.enssat.mnantel.GrapheValue;
import fr.enssat.mnantel.Sommet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DijkstraAlgorithm
{
	private final List<Sommet> nonExplore;

	/**
	 * Indique la plus courte distance cumulée trouvée pour se rendre de la
	 * source au sommet.
	 */
	private final Map<Sommet, Integer> distance;

	/**
	 * Pour chaque sommet, associe le meilleur prédécésseur pour s'y rendre à
	 * partir de la source.
	 */
	private final Map<Sommet, Sommet> predecesseurs;

	private final GrapheValue graphe;

	/**
	 * Sommet de départ dans le graphe.
	 */
	private final Sommet source;

	public DijkstraAlgorithm(GrapheValue graphe, Sommet source)
	{
		if ( graphe == null || graphe.estVide() || source == null || !graphe.existeSommet(source) ) {
			throw new IllegalArgumentException(); // Préconditions de l'algorithme
		}

		this.graphe = graphe;
		this.source = source;

		nonExplore = new ArrayList<>(graphe.getSommets()); // Tous les sommets restent � parcourir au lancement
		predecesseurs = new HashMap<>();

		distance = new HashMap<>();
		for ( Sommet sommet : nonExplore ) {
			distance.put(sommet, graphe.getPoids(source, sommet));
		}

		// Initialise les predecesseurs de la source
		for ( Sommet sommet : graphe.getSommetsAdjacents(source) ) {
			predecesseurs.put(sommet, source);
		}

		nonExplore.remove(source);
	}

	public void executer()
	{
		while ( !nonExplore.isEmpty() ) {
			Sommet sommet = getSommetLePlusProche(nonExplore);
			nonExplore.remove(sommet);
			parcourirSommetsAdjacents(sommet);
		}
	}

	private Sommet getSommetLePlusProche(List<Sommet> sommets)
	{
		assert !sommets.isEmpty(); // précondition
		Iterator<Sommet> i = sommets.iterator();
		Sommet plusProche = i.next();
		while ( i.hasNext() ) {
			// INVARIANT: plusProche est le proche sommet de "sommets" entre le début (inclus) et i (exclus)
			Sommet candidat = i.next();
			if ( distance.get(candidat) < distance.get(plusProche) ) {
				plusProche = candidat;
			}
		}
		return plusProche;
	}

	private void parcourirSommetsAdjacents(Sommet sommet)
	{
		for ( Sommet adjacent : graphe.getSommetsAdjacents(sommet) ) {

			// distance = distance déjà parcourue pour arriver à 'sommet' + la distance pour se rendre de 'sommet' à 'adjacent'
			int distanceDepuisAdjacent = distance.get(sommet) + graphe.getPoids(sommet, adjacent);
			if ( distanceDepuisAdjacent < distance.get(adjacent) ) {
				// Signifie qu'on a trouvé un meilleur chemin 
				distance.put(adjacent, distanceDepuisAdjacent);
				predecesseurs.put(adjacent, sommet);
			}
		}
	}

	/**
	 * Calcul le plus court chemin jusqu'à la destination donnée. Nécéssite que
	 * l'algorithme ai été éxécuté pour un point de départ au préalable.
	 */
	public List<Sommet> trouverCheminVers(Sommet destination)
	{
		/*
		 * Plus court chemin de la destination jusqu'à la source. Le routage
		 * nous permet d'obtenir le chemin "à l'envers", donc plutôt que de
		 * devoir inverser en fin de fonction, on utilise directement une liste
		 * chainée et on ajoute en tête.
		 */
		LinkedList<Sommet> chemin = new LinkedList<>();
		Sommet etape = destination;

		while ( etape != source ) { // Le predecesseur est donc la source
			chemin.addFirst(etape);
			etape = predecesseurs.get(etape);
			if ( etape == null ) {
				return null; // Aucun chemin n'éxiste
			}
		}

		chemin.addFirst(source);

		System.out.println("[Algo Dijkstra] Le plus court chemin de " + source + " vers " + destination + " est " + chemin);
		return chemin;
	}
}
