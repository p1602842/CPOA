<?php
require_once(PATH_MODELS."matchSimpleDAO.php");
require_once(PATH_MODELS."matchdoubleDAO.php");
require_once(PATH_MODELS.'prixDAO.php');
require_once(PATH_MODELS.'joueurDAO.php');
require_once(PATH_MODELS.'terrainDAO.php');


$_SESSION['idMatch'] = $_GET['idMatch'];
$_SESSION['type'] = $_GET['type'];

switch($_SESSION['type']) {
    case 'simple':
        $matchDAO = new matchSimpleDAO(DEBUG);
        $match = $matchDAO->getMatchById($_SESSION['idMatch']); 
        $match['id'] = $match['ID_MATCH_SIMPLE'];
        $match['horaire'] = $match['HORAIRE_SIMPLE'];
        $match['phase'] = $match['PHASE_TOURNOI_SIMPLE'];
        break;
    case 'double':
        $matchDAO = new matchDoubleDAO(DEBUG);
        $match = $matchDAO->getMatchById($_SESSION['idMatch']);
        $match['id'] = $match['ID_MATCH_DOUBLE'];
        $match['horaire'] = $match['HORAIRE_DOUBLE'];
        $match['phase'] = $match['PHASE_TOURNOI_DOUBLE'];
        break;
    
}

require_once(PATH_MODELS.'AdminMatchDAO.php');
require_once(PATH_MODELS.'AdminPrixDAO.php');
require_once(PATH_MODELS.'AdminTennismanDAO.php');
require_once(PATH_MODELS.'AdminTerrainDAO.php');

$match = new AdminMatchDAO(DEBUG);
$prix = new AdminPrixDAO(DEBUG);
$player = new AdminTennismanDAO(DEBUG);
$terrain = new AdminTerrainDAO(DEBUG);

$affichMatch = $match -> getMatchbyID($_GET['id']);
$affichPrix = $prix -> getPrixbyID($_GET['id']);
$infosTerrain = $terrain -> getTerrainbyID($affichMatch['idTerrain']);
$nbPlacesTotal = $terrain -> getNbPlacesTerrain($infosTerrain['idTerrain']);

if (isset($_POST['action'])){
	if (($_POST['placeLicencie']+$_POST['placeSolidarite']+$_POST['placePromo']) <= $nbPlacesTotal['somme']){
		if ($prix -> setPlacesbyID($infosTerrain['idTerrain'],$_POST['placeLicencie'],$_POST['placeSolidarite'],$_POST['placePromo'])){
			$alert = choixAlert('modifeffected');
			?><meta http-equiv="refresh" content="2; URL=index.php?page=nbplacescateg"><?php
		} else {
			$alert = choixAlert('messageAlert');
		}
	} else {
		$alert = choixAlert('placemaxover');
	}
}




require_once(PATH_VIEWS.$page.'.php');