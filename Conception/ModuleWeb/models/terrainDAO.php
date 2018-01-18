<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."joueur.php";

class terrainDAO extends DAO {

public function getTerrainSimple($ID_MATCH){
    $list = array();
    $args = array($ID_MATCH);
    $req = $this->queryAll("SELECT NOM_TERRAIN
FROM TERRAIN
INNER JOIN MATCHSIMPLE
WHERE TERRAIN.ID_TERRAIN = MATCHSIMPLE.ID_TERRAIN
AND ID_MATCH_SIMPLE = ?",$args);
    if($req){
        return new terrain($req[0]['NOM_TERRAIN']);
    } else {
        return false;
    }
}

public function getTerrainDouble($ID_MATCH){
    $list = array();
    $args = array($ID_MATCH);
    $req = $this->queryAll("SELECT NOM_TERRAIN
    FROM TERRAIN
    INNER JOIN MATCHDOUBLE
    WHERE TERRAIN.ID_TERRAIN = MATCHDOUBLE.ID_TERRAIN
    AND ID_MATCH_DOUBLE = ?",$ID_MATCH);
    if($req){
        foreach ($req as $terrain){
            $list[] = new terrain($terrain[0]);
        }
        return $list;
    } else {
        return false;
    }
}

}