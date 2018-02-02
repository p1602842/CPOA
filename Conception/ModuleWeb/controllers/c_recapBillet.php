<?php
require_once(PATH_MODELS."matchSimpleDAO.php");
require_once(PATH_MODELS."matchdoubleDAO.php");

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



require_once(PATH_VIEWS.$page.'.php');