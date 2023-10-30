# Crud Films

## Installation et prérequis
- installer MariaDB avec une base de données nommée "films"
- installer Java 17 (de votre choix)
- installer Git (https://git-scm.com/downloads)
- installer IntelliJ (https://www.jetbrains.com/fr-fr/idea/download/#section=windows)
- cloner le projet avec la commande `git clone https://github.com/Mo8/CrudFilms.git'


## Lancement
- ouvrir le projet avec IntelliJ (File -> Open -> sélectionner le dossier du projet)
- dans le fichier application.properties, modifier les lignes suivantes :
    - spring.datasource.username=nom_utilisateur
    - spring.datasource.password=mot_de_passe
    - (spring.datasource.url=jdbc:mariadb://localhost:3306/films)
- utiliser le bouton "Run" pour lancer le projet (suivre les instructions pour installer les dépendances ou tout autre problème indiqué par IntelliJ)
- ouvrir un navigateur et aller à l'adresse http://localhost:8080

## Utilisation
- http://localhost:8080 : indique toutes les routes disponibles ( voir aussi http://localhost:8080/swagger-ui/index.html )
- pour utiliser l'API, il faut utiliser un logiciel comme Postman (https://www.postman.com/downloads/) ou utiliser le site http://localhost:8080/swagger-ui/index.html
- les sous objets sont créés en tant que links, il faut donc utiliser l'URL indiquée pour les utiliser
- il y a un filtre sur les requêtes GET pour les films, par rapport aux acteurs et realisateurs, il faut utiliser les Ids (séparé par des virgules pour filtrer avec plusieurs) par exemple : http://localhost:8080/films/search/findAllByActeursInAndByRealisateursIn?acteurs_id=1,2&realisateurs_id=2&page=0&size=20

