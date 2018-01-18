<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."matchSimpleDAO.php";
require_once PATH_MODELS."matchDoubleDAO.php";

class bigMatchDAO extends DAO {

public function getBigMatchSimple(){
    $list = array();
    $req = $this->queryAll("SELECT ID_MATCH_SIMPLE, HORAIRE_SIMPLE, PHASE_TOURNOI_SIMPLE
    FROM MATCHSIMPLE
    WHERE PHASE_TOURNOI_SIMPLE BETWEEN 4 AND 7
    AND ACCESSIBLE_SIMPLE = 1
    AND JOUE_SIMPLE = 0;");
    if($req){
        foreach ($req as $matchSimple){
            $joueurDAO = new joueurDAO(DEBUG);
            $joueur = $joueurDAO->getJoueurParMatch($matchSimple[0]);
            $terrainDAO = new terrainDAO(DEBUG);
            $terrain = $terrainDAO->getTerrainSimple($matchSimple[0]);
            $list[] = new matchSimple($matchSimple[0], $matchSimple[1], $matchSimple[2], $joueur, $terrain);
        }
        return $list;
    } else {
        return false;
    }
}

public function getBigMatchDouble(){
    $list = array();
    $req = $this->queryAll("SELECT ID_MATCH_DOUBLE, HORAIRE_DOUBLE, PHASE_TOURNOI_DOUBLE
    FROM MATCHDOUBLE
    WHERE PHASE_TOURNOI_DOUBLE = 5
    AND ACCESSIBLE_DOUBLE = 1
    AND JOUE_DOUBLE = 0;");
    if($req){
        foreach ($req as $matchDouble){
            $list[] = array($matchDouble[0], $matchDouble[1], $matchDouble[2]);
        }
        return $list;
    } else {
        return false;
    }
}



}
