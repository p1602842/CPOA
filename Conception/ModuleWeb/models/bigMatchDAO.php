<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."matchSimpleDAO.php";
require_once PATH_MODELS."matchDoubleDAO.php";      
require_once PATH_MODELS."joueurEquipeDAO.php";
require_once PATH_MODELS."equipeDAO.php";

class bigMatchDAO extends DAO {

public function getBigMatchSimple(){
    $list = array();
    $req = $this->queryAll("SELECT ID_MATCH_SIMPLE, HORAIRE_SIMPLE, PHASE_TOURNOI_SIMPLE
    FROM MATCHSIMPLE
    WHERE PHASE_TOURNOI_SIMPLE = 8
    AND ACCESSIBLE_SIMPLE = 1
    AND JOUE_SIMPLE = 0");
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
            $equipeDAO = new equipeDAO(DEBUG);
            $equipe = $equipeDAO->getEquipe($matchDouble[0]);

            $terrainDAO = new terrainDAO(DEBUG);
            $terrain = $terrainDAO->getTerrainDouble($matchDouble[0]);

            $joueurEquipeDAO = new joueurEquipeDAO(DEBUG);
            $joueurEquipe1 = $joueurEquipeDAO->getJoueurEquipe($equipe[0]->getIdEquipe());
            $joueurEquipe2 = $joueurEquipeDAO->getJoueurEquipe($equipe[1]->getIdEquipe());

            $list[] = new matchDouble($matchDouble[0], $matchDouble[1], $matchDouble[2], $equipe, $joueurEquipe1, $joueurEquipe2, $terrain);
        }
        return $list;
    } else {
        return false;
    }
}



}
