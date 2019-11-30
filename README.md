# API_recettes

Dans ce ce qui suit, on va voir l'installation et l'utilisation de l'API_recettes ansi que la mise en place de la base de données sous MySQL.

## 1- Prérequis
* Installer Java JDK
* Installer Eclipse
* Installer Maven
* Installer Git
* Installer MySQL

## 2- Installation de l'API

### Cloner le projet API_recettes
Ouvrez CMD et positionnez-vous dans votre espace de travail, puis collez la commande suivante pour cloner le projet :
```
git clone https://github.com/didadya/API_recettes.git API_Recettes
```
**https://github.com/didadya/API_recettes.git** : est l’URL qui pointe vers le projet sur GitHub.

**API_Recettes** : est le libelle du répertoire local où on va cloner le projet.

### Installer le projet avec Maven

Une fois le projet téléchargé, toujours dans le terminal, positionnez vous dans le projet en utilisant cette commande : 
```
cd API_Recettes
```
Puis, pour compiler et installer les jar’s nécessaire pour faire fonctionner l’API, utilisez la commande : 
```
mvn install
```
Durant ce traitement, Maven crée automatiquement le dossier "target" qui contient le programme compilé.

### Préparation de l'import dans Eclipse 

Il faut maintenant créer les fichiers spécifiques à Eclipse, toujours à l'aide de Maven. En utilisant la commande : 
```
mvn eclipse:eclipse
```
Durant ce traitement, Maven crée les fichiers ".classpath" et ".projet" dont Eclipse a besoin.

### Import dans Eclipse

On peut donc maintenant lancer Eclipse. Pour commencer, vérifiez que vous êtes sur la perspective *“java”*. Sinon, Pour l'avoir, il faut utiliser le menu *"Window > Open perspective > Java"*.

On peut ensuite importer le projet dans Eclipse, pour cela il faut utiliser le menu *"File > Import > Existing Maven Projects"*

Pour lancer l'API, clic droit sur le projet, puis *"Run as > Java Application>"* puis choisir *ApiRecettesApplication* dans *Matching items*.

## 3- Utilisation de l'API

Pour pouvoir utiliser l'API, il faut d'abord créer la base de données (ce qu'on va voir par la suite) puis lancer le service (exécuter le projet).

Voici les services de L'API :

### Rechercher une recette en utilisant son libelle ou son niveau de difficulté
```
Méthode : GET
Requête URL : http://localhost:8181/recettes/recherche/ + (Mot cle de recherche)
Header : Key : Content-Type
         Value : Application/json
```

Exemple d'URL pour chercher *Tartiflette* :  http://localhost:8181/recettes/recherche/tartiflette

### Récuperer toutes les recettes
```
Méthode : GET
Requête URL : http://localhost:8181/recettes
Header : Key : Content-Type
         Value : Application/json
```

## 4- Mise en place de la BDD sous MySQL

Sous MySQL, Créez une base de données nommée "**db_recettes**".

Ensuite, utilisez le script ci-dessous pour la création de la table ainsi que ses champs :
```
CREATE TABLE `recette` (
  `id_recette` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` text,
  `duree_cuissant` int(11) DEFAULT NULL,
  `preparation` longtext,
  `ingredients` longtext,
  `niveau` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_recette`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
```
