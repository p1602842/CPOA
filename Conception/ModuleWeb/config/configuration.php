
<?php
const DEBUG = true; // production : false; dev : true

// Accès base de données
const BD_HOST = '90.119.181.117';
const BD_DBNAME = 'cpoa-asc';
const BD_USER = 'CPOA';
const BD_PWD = 'carotte';

// Identifiants connexion espace administrateur
const USERNAME = "CPOA";
const PASSWORD = "carotte";

// Langue du site
const LANG ='FR-fr';

// Paramètres du site : nom de l'auteur ou des auteurs
const AUTEUR = 'Antoine, Simon et Claire';

//dossiers racines du site
define('PATH_CONTROLLERS','./controllers/c_');
define('PATH_ASSETS','./assets/');
define('PATH_LIB','./lib/');
define('PATH_MODELS','./models/');
define('PATH_VIEWS','./views/v_');
define('PATH_TEXTES','./languages/');

//sous dossiers
define('PATH_CSS', PATH_ASSETS.'css/');
define('PATH_IMAGES', PATH_ASSETS.'images/');
define('PATH_SCRIPTS', PATH_ASSETS.'scripts/');
define("PATH_GALERIE",'galerie/');
//define('PATH_LOG','log/');

//fichiers
//define('LOG_BDD','logbdd.txt');
define('PATH_LOGO', PATH_IMAGES.'logo.png');
define('PATH_TENNIS',PATH_IMAGES.'tennis.jpg');
define('PATH_MENU', PATH_VIEWS.'menu.php');
