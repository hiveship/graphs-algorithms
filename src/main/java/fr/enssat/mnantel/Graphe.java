package fr.enssat.mnantel;

import java.util.Set;

public interface Graphe
{
	// PROPRIETES GENERALES

	/** Retourne vrai si le graphe est orienté. */
	boolean estOriente();

	/** Retourne vrai si le graphe est valué. */
	boolean estValue();

	/** Retourne vrai si le graphe est vide (ne comporte aucun sommet). */
	boolean estVide();

	/** Retourne la taille du graphe (nombre total de sommets). */
	int taille();

	// GESTION DES SOMMETS

	/** Ajoute un sommet au graphe. Pas de doublons possibles. */
	void ajouterSommet(Sommet sommet);

	/**
	 * Supprime un sommet existant du graphe. Supprime également toutes les
	 * liaisons associées à ce sommet.
	 */
	void retirerSommet(Sommet sommet);

	/** Retourne l'ensemble des sommets du graphe. */
	Set<Sommet> getSommets();

	/**
	 * Retourne l'enssemble des sommets directement accéssibles depuis le sommet
	 * 'source'
	 */
	Set<Sommet> getSommetsAdjacents(Sommet source);

	/** Retourne le degré d'un sommet. Degré = Degré entrant + degré sortant */
	int getDegre(Sommet sommet);

	/** Retourne le degré sortant d'un sommet */
	int getDegreSortant(Sommet sommet);

	/** Retourne le degré entrant d'un sommet */
	int getDegreEntrant(Sommet sommet);

	/** Retourne vrai si le sommet éxiste dans le graphe */
	boolean existeSommet(Sommet sommet);

	/** Retourne l'enssemble des sommets atteignables depuis le sommet 's' */
	Set<Sommet> getSuccesseurs(Sommet s);

	/** Retourne l'ensemble des sommets permettant d'atteindre le sommet 's'. */
	Set<Sommet> getPredecesseurs(Sommet s);

	// GESTION DES ARCS

	/** Supprime la liaison existante entre 'source' et 'destination' */
	void retirerArc(Sommet source, Sommet destination);

	/** Retourne vrai si il éxiste un arc entre 'source' et 'destination'. */
	boolean existeArc(Sommet source, Sommet destination);

}
