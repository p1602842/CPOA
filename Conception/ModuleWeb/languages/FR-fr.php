<?php

//Header
define('LOGO', 'Logo du grand prix de tennis'); // Affiché si image non trouvée
define('TENNIS','Image de tennis'); //idem
define('TITRE', 'Grand Prix de Tennis de Lyon');
define('MESSAGE_BIENVENUE','Bienvenue sur notre billeterie en ligne du grand
prix de tennis de Lyon. Ici vous pouvez achetez vos billets en ligne en fonction
de la catégorie souhaitée.Vous pouvez également consultez le planning afin de
connaitre les matchs qui se jouent.');
define('MESSAGE_POUR_ADMIN',' Si vous êtes un administrateur, veuillez
vous connectez pour accèder à vos privilèges.');


//Menu
define('MENU_ACCUEIL','Accueil');
define('MENU_BILLET','Billets');
define('MENU_PLANNING','Planning');


define('MENU_CONNEXION','Connexion');
define('MENU_DECONNEXION','Deconnexion');
define('MENU_ADMIN','Administrateur');


//Messages d'erreurs:
define('TEXTE_PAGE_404','Oops, la page demandée n\'existe pas !');
define('ERREUR_CONNECT_BDD','Impossible de se connecter à la base de données !');
define('ERREUR_QUERY_BDD','Une erreur est survenue lors de la requête SQL !');

define('ERREUR_FORM_CAT_EMPTY','Elle doit avoir un nom !');
define('ERREUR_FORM_CAT_ALREADYEXIST','Cette categorie existe déjà !');
define('ERREUR_FORM_CAT_LONGUEUR','Elle doit avoir un nom compris entre 4 et 20 lettres !');

define('ERREUR_FORM_PHOTO_FILE1','Erreur fichier');
define('ERREUR_FORM_PHOTO_FILE2','Vous devez choisir un fichier');
define('ERREUR_FORM_PHOTO_SIZE','Taille maximum 100Ko');
define('ERREUR_FORM_PHOTO_EXT','Extension non supportée');
define('ERREUR_FORM_PHOTO_DESC','La description doit contenir au moins une lettre');
define('ERREUR_FORM_PHOTO_ALREADYEXIST','Ce nom de fichier est déjà pris !');

define('ERREUR_FORM_CONNEXION_UNKNOWID','Cet identifiant est inconnu !');
define('ERREUR_FORM_CONNEXION_PASSWORD','Mot de passe incorrect !');

define('ERREUR_FORM_INSCRIPTION_LONGUEURID','Le nom d\'utilisateur doit être compris entre 4 et 20 caractères !');
define('ERREUR_FORM_INSCRIPTION_LONGUEURMDP','Le mot de passe doit comporter au moins 4 caractères !');
define('ERREUR_FORM_INSCRIPTION_ALREADYEXIST','Cet utilisateur existe déjà !');

define('ERREUR_PHOTO_BADID','Identifiant de photo incorrect dans l\'URL');
define('ERREUR_PHOTO_DELETE','Supression impossible !');
define('ERREUR_PHOTO_MODIF','Modification impossible !');
define('ERREUR_PHOTO_VANDALE','Cette photo ne vous appartient pas, vandale !');

define('MESSAGE_ERREUR','Une erreur s\'est produite');


//Messages informations

define('TEXTE_SELECTED_PHOTOS'," photo(s) selectionnée(s)");
define('TEXTE_FORM_CAT_SUCCESS',"Categorie ajoutée !");
define('TEXTE_FORM_PHOTO_SUCCESS',"Photo ajoutée !");

define('TEXTE_FORM_CONNEXION_SUCCESS1',"Bienvenue ");
define('TEXTE_FORM_CONNEXION_SUCCESS2',", redirection vers l'accueil en cours");

define('TEXTE_FORM_INSCRIPTION_SUCCESS1',"Inscription réussite ");
define('TEXTE_FORM_INSCRIPTION_SUCCESS2',", redirection vers l'accueil en cours");

define('TEXTE_PHOTO_DELETE_SUCCESS',"Photo supprimé");
define('TEXTE_PHOTO_MODIF_SUCCESS',"Modification réussite");



//Titres


define('TITRE_PAGE_ACCUEIL_TOUS','Toutes les photos');
define('TITRE_PAGE_ACCUEIL_CAT','Les photos de la categorie ');
define('TITRE_PAGE_PHOTO','Les détails sur cette photo');

define('TITRE_PAGE_ADDCAT','Quelle Categorie ?');
define('TITRE_PAGE_ADDPHOTO','Quelle photo ?');

define('TITRE_PAGE_CONNEXION','Connexion administrateur');
define('TITRE_PAGE_INSCRIPTION','Inscription');


//Forms

define('FORM_QUESTION_CAT_AFFICHER','Quelles photos souhaitez-vous afficher ?');

define('FORM_QUESTION_CAT_NAME','Nom de la catégorie:');

define('FORM_QUESTION_PHOTO_FICHIER','Choisir le fichier:');
define('FORM_QUESTION_PHOTO_DESC','Décrire la photo en une phrase:');
define('FORM_QUESTION_PHOTO_CAT','Choisir une catégorie:');

define('FORM_CONNEXION_IDENTIFIANT','Identifiant');
define('FORM_CONNEXION_MDP','Mot de passe');


// Boutons
define('BUTTON_CONNEXION','Se connecter');
