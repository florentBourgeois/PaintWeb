<h1> Projet PaintWeb </h1>

<h2> Description </h2>

<p>L'objectif de ce projet est la mise en pratique de l'ensemble des notions apportées par le développement objet, la découverte des bonnes pratiques apportées par le concept objet ainsi que l'utilisation d'outils avancés du développement java (springboot, junit, maven)</p>

 
<h2> Importer le projet </h2> 
 
 Deux approches peuvent être employées pour importer le projet depuis eclipse : 
<ul>
	<li> import depuis git </li>
	<li> import après téléchargement</li>
</ul>



<h3> Depuis git </h3>
<ul>
	<li> Fichier -> Import </li>
	<li> Git -> Project from Git </li>
	<li> Clone URi</li>
	<li> remplir les informations du git : </li>
		<ul>
			<li> uri : https://github.com/florentBourgeois/PaintWeb.git </li>
			<li> host : github.com</li>
			<li> Repository path : le dossier ou vous voulez sauvegarder le projet </li>
			<li> Protocol : https </li>
			<li> Port : laisser vide</li>
			<li> User : votre utilisateur Github </li>
			<li> Password : votre password Github </li>
		</ul>
</ul>

<h3> Depuis l'archive </h3>

<ul>
	<li> Télécharger l'archive et la dézipper dans le dossier ou vous voulez sauvegarder le projet</li>
	<li> Fichier -> Import </li>
	<li> Maven -> Existing maven project </li>
	<li> browse et selectionner le fichier pom.xml dans le dossier du projet</li>
	<li> finish </li>
</ul>


<h2> Tester le fonctionnement du projet</h2>

Actuellement le projet ne contient que le modèle d'objets pour le paint ainsi que les tests sur ce modèle.
Pour valider le fonctionnement du projet : 
<ul>
	<li> clic droit sur le projet -> Maven -> Update project </li>
	<li> attendre que le téléchargement se termine (indiqué dans la bare tout en bas à droite d'eclipse</li>
	<li> clic droit sur le projet -> Run as -> Maven test </li>
	<li> si la configuration est correcte, alors vous verrez apparaitre le message <em>"Tests run: 71, Failures: 0, Errors: 0, Skipped: 0"</em>  dans la console </li>
</ul>

Lorsque vous executez les tests maven ; vous retrouverez le résultat d'execution des tests dans le dossier target/surefire-reports/  Double cliquer sur l'un de ces fichiers pour voir l'état détaillé des tests. 


