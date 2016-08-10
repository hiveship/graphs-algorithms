package fr.enssat.mnantel.warshall;


import fr.enssat.mnantel.GrapheNonValue;
import fr.enssat.mnantel.Sommet;

public class WarshallAlgorithm
{
	private final GrapheNonValue graphe;

	public WarshallAlgorithm(GrapheNonValue graphe)
	{
		this.graphe = graphe;
	}

	public void executer()
	{
		for ( Sommet k : graphe.getSommets() ) {
			for ( Sommet i : graphe.getSommets() ) {
				if ( graphe.existeArc(i, k) ) {
					for ( Sommet j : graphe.getSommets() ) {
						if ( graphe.existeArc(k, j) ) {
							if ( !graphe.existeArc(i, j) ) { // Pour éviter de dupliquer un arc il faut vérifier si il n'éxiste pas déjà
								graphe.ajouterArc(i, j, k);
								System.out.println("[Algo Warshall] Ajout d'un arc entre " + i.getLabel() + " et " + j.getLabel() + " en passant par " + k.getLabel());
							}
						}
					}
				}
			}
		}
	}

}
