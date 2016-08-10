package fr.enssat.mnantel;

import java.util.Arrays;
import java.util.List;

import fr.enssat.mnantel.dijkstra.DijkstraAlgorithm;
import org.junit.Assert;
import org.junit.Test;


@SuppressWarnings("static-method")
public class DijkstraAlgorithmTest
{
	private static Sommet Brest = new Sommet("Brest");
	private static Sommet Morlaix = new Sommet("Morlaix");
	private static Sommet Quimper = new Sommet("Quimper");
	private static Sommet Guingamp = new Sommet("Guingamp");
	private static Sommet SaintBrieuc = new Sommet("Saint-Brieuc");
	private static Sommet Vannes = new Sommet("Vannes");
	private static Sommet Rennes = new Sommet("Rennes");

	@Test
	public void testBrestVersRennes()
	{
		GrapheValue graphe = new GrapheValueImpl(false);
		graphe.ajouterArc(Brest, Morlaix, 58);
		graphe.ajouterArc(Brest, Guingamp, 121);
		graphe.ajouterArc(Brest, Quimper, 71);
		graphe.ajouterArc(Morlaix, SaintBrieuc, 97);
		graphe.ajouterArc(Morlaix, Guingamp, 56);
		graphe.ajouterArc(Guingamp, Quimper, 119);
		graphe.ajouterArc(Guingamp, SaintBrieuc, 36);
		graphe.ajouterArc(Guingamp, Vannes, 117);
		graphe.ajouterArc(Quimper, Vannes, 119);
		graphe.ajouterArc(SaintBrieuc, Vannes, 117);
		graphe.ajouterArc(SaintBrieuc, Rennes, 101);
		graphe.ajouterArc(Vannes, Rennes, 116);

		DijkstraAlgorithm algo = new DijkstraAlgorithm(graphe, Brest);
		algo.executer();

		List<Sommet> cheminObtenu = algo.trouverCheminVers(Rennes);
		List<Sommet> cheminAttendu = Arrays.asList(Brest, Morlaix, Guingamp, SaintBrieuc, Rennes);
		org.junit.Assert.assertTrue(cheminAttendu.equals(cheminObtenu));
	}

	@Test
	public void testDestinationPasDansGraphe()
	{
		GrapheValue graphe = new GrapheValueImpl(false);
		graphe.ajouterArc(Brest, Morlaix, 58);
		graphe.ajouterArc(Brest, Guingamp, 111);
		graphe.ajouterArc(Morlaix, Guingamp, 56);

		DijkstraAlgorithm algo = new DijkstraAlgorithm(graphe, Morlaix);
		algo.executer();

		List<Sommet> cheminObtenu = algo.trouverCheminVers(Rennes);
		Assert.assertTrue(cheminObtenu == null); // Aucun chemin ne doit exister
	}

	@Test
	public void testSourceVersSource()
	{
		GrapheValue graphe = new GrapheValueImpl(false);
		graphe.ajouterArc(SaintBrieuc, Vannes, 117);
		graphe.ajouterArc(SaintBrieuc, Rennes, 101);
		graphe.ajouterArc(Vannes, Rennes, 116);

		DijkstraAlgorithm algo = new DijkstraAlgorithm(graphe, SaintBrieuc);
		algo.executer();

		List<Sommet> cheminObtenu = algo.trouverCheminVers(SaintBrieuc);
		List<Sommet> cheminAttendu = Arrays.asList(SaintBrieuc);
		Assert.assertTrue(cheminAttendu.equals(cheminObtenu));
	}
}
