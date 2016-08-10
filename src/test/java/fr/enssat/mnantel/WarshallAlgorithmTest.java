package fr.enssat.mnantel;

import fr.enssat.mnantel.warshall.WarshallAlgorithm;
import org.junit.Assert;
import org.junit.Test;


@SuppressWarnings("static-method")
public class WarshallAlgorithmTest
{
	private static Sommet Brest = new Sommet("Brest");
	private static Sommet Morlaix = new Sommet("Morlaix");
	private static Sommet SaintBrieuc = new Sommet("Saint-Brieuc");
	private static Sommet Rennes = new Sommet("Rennes");
	private static Sommet Paris = new Sommet("Paris");

	@Test
	public void testCasNormal()
	{
		GrapheNonValue grapheATraiter = new GrapheNonValueImpl(true);
		grapheATraiter.ajouterArc(Brest, Morlaix);
		grapheATraiter.ajouterArc(Morlaix, SaintBrieuc);
		grapheATraiter.ajouterArc(SaintBrieuc, Rennes);
		grapheATraiter.ajouterArc(Paris, Rennes);

		// Graphe attendu après fermeture transitive
		GrapheNonValue grapheAttendu = new GrapheNonValueImpl(true);
		grapheAttendu.ajouterArc(Brest, Morlaix);
		grapheAttendu.ajouterArc(Morlaix, SaintBrieuc);
		grapheAttendu.ajouterArc(SaintBrieuc, Rennes);
		grapheAttendu.ajouterArc(Paris, Rennes);
		// Arcs devant être crés par l'algo
		grapheAttendu.ajouterArc(Brest, Rennes);
		grapheAttendu.ajouterArc(Brest, SaintBrieuc);
		grapheAttendu.ajouterArc(Morlaix, Rennes);

		// Execution de l'algorithme sur le graphe
		WarshallAlgorithm algo = new WarshallAlgorithm(grapheATraiter);
		algo.executer();

		// Vérification du résultat
		Assert.assertTrue(grapheATraiter.getAdjacence().memeArcs(grapheAttendu.getAdjacence()));
	}

	@Test
	public void testToutEstJoignable()
	{
		GrapheNonValue grapheATraiter = new GrapheNonValueImpl(true);
		grapheATraiter.ajouterArc(SaintBrieuc, SaintBrieuc);
		grapheATraiter.ajouterArc(Morlaix, Morlaix);
		grapheATraiter.ajouterArc(Brest, Brest);
		grapheATraiter.ajouterArc(SaintBrieuc, Morlaix);
		grapheATraiter.ajouterArc(SaintBrieuc, Brest);
		grapheATraiter.ajouterArc(Morlaix, Brest);
		grapheATraiter.ajouterArc(Morlaix, SaintBrieuc);
		grapheATraiter.ajouterArc(Brest, Morlaix);
		grapheATraiter.ajouterArc(Brest, SaintBrieuc);

		// On créer un graphe identique (résultat attendu)
		GrapheNonValue grapheAttendu = new GrapheNonValueImpl(true);
		grapheAttendu.ajouterArc(SaintBrieuc, SaintBrieuc);
		grapheAttendu.ajouterArc(Morlaix, Morlaix);
		grapheAttendu.ajouterArc(Brest, Brest);
		grapheAttendu.ajouterArc(SaintBrieuc, Morlaix);
		grapheAttendu.ajouterArc(SaintBrieuc, Brest);
		grapheAttendu.ajouterArc(Morlaix, Brest);
		grapheAttendu.ajouterArc(Morlaix, SaintBrieuc);
		grapheAttendu.ajouterArc(Brest, Morlaix);
		grapheAttendu.ajouterArc(Brest, SaintBrieuc);

		// Execution de l'algorithme sur le graphe
		WarshallAlgorithm algo = new WarshallAlgorithm(grapheATraiter);
		algo.executer();

		// Vérification du résultat
		Assert.assertTrue(grapheATraiter.getAdjacence().memeArcs(grapheAttendu.getAdjacence()));
	}
}
