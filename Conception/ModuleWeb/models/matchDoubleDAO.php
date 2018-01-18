<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."matchDouble.php";
require_once PATH_MODELS."joueur.php";
require_once PATH_MODELS."terrain.php";
require_once PATH_MODELS."joueurDAO.php";
require_once PATH_MODELS."terrainDAO.php";

class matchDoubleDAO extends DAO {

public function getMatchDoubleVisiteur(){
    $list = array();
    $req = $this->queryAll("SELECT ID_MATCH_DOUBLE, HORAIRE_DOUBLE, PHASE_TOURNOI_DOUBLE
    FROM MATCHDOUBLE
    WHERE PHASE_TOURNOI_DOUBLE < 5
    AND ACCESSIBLE_DOUBLE = 1
    AND JOUE_DOUBLE = 0;");

    if($req){
        foreach ($req as $matchDouble){
            $equipeDAO = new equipeDAO(DEBUG);
            $equipe = $equipeDAO->getEquipe($matchDouble[0]);

            $terrainDAO = new terrainDAO(DEBUG);
            $terrain = $terrainDAO->getTerrainDouble($matchDouble[0]);

            $joueurEquipeDAO = new joueurEquipeDAO(DEBUG);
            $joueurEquipe1 = $joueurEquipeDAO->getJoueurEquipe($equipe[0]);
            $joueurEquipe2 = $joueurEquipeDAO->getJoueurEquipe($equipe[1]);

            $list[] = new matchDouble($matchDouble[0], $matchDouble[1], $matchDouble[2], $equipe, $joueurEquipe1, $joueurEquipe2, $terrain);
        }
        return $list;
    } else {
        return false;
    }
}
}