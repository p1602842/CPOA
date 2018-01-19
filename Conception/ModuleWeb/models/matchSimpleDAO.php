<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."matchSimple.php";
require_once PATH_MODELS."joueur.php";
require_once PATH_MODELS."terrain.php";
require_once PATH_MODELS."joueurDAO.php";
require_once PATH_MODELS."terrainDAO.php";

class matchSimpleDAO extends DAO {

public function getMatchSimpleVisiteur(){
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
public function getMatchById($idMatch){
    $req=$this->queryRow("select * FROM MATCHSIMPLE WHERE ID_MATCH_SIMPLE = ?",[$idMatch]);
    return $req;
}

}
