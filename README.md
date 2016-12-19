# Graphs

Implémentation en Java d'une structure de graphe et de deux algorithmes associés : Dijkstra et Warshall.

# Structure

Un graphe est un ensemble de sommets reliés ensemble par des arcs. Ils modélisent de
nombreuses situations où interviennent des objets en interactions. Par exemple les
interconnexions routières entre différentes agglomérations. En mathématiques la théorie des
graphes propose un grand nombre d’algorithmes permettant de résoudre des problèmes connus
pouvant être modélisés par des graphes.

# Dijkstra

Un problème récurent dans la théorie des graphes et de trouver le meilleur chemin à
emprunter pour se rendre d’un point à un autre. Sur l’exemple du réseau routier, l’algorithme de
Dijkstra permet de trouver le chemin le plus court entre deux villes.

# Warshall

L’objectif de l’algorithme de Warshall est de construire la fermeture transitive d’un
graphe, orienté ou non. Si dans le graphe il existe un chemin pour se rendre d’un sommet A à un
sommet B, alors on ajoute un arc (s’il n’existe pas déjà) entre A et B. Le calcul de la fermeture
transitive d’un graphe permet donc de savoir s’il existe au moins un chemin entre deux sommets
du graphe.

Une variante permet d’obtenir le routage entre deux sommets, c’est-à-dire de trouver un
chemin pour se rendre entre deux sommets. Contrairement à l’algorithme de Dijkstra, ici il ne
s’agit pas forcément du chemin le plus court, mais « d’un chemin ».
