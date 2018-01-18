<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."joueur.php";

class joueurDAO extends DAO {
public function getJoueurParMatch($ID_MATCH){
    $list = array();
    $args = array($ID_MATCH);
    $req = $this->queryAll("SELECT PRENOM_TENNISMAN, NOM_TENNISMAN
FROM TENNISMAN
INNER JOIN JOUE_SIMPLE
WHERE TENNISMAN.ID_TENNISMAN = JOUE_SIMPLE.ID_TENNISMAN
AND ID_MATCH_SIMPLE = ?", $args);
    if($req){
        foreach ($req as $joueur){
            $list[] = new joueur($joueur[0], $joueur[1]);
        }
        return $list;
    } else {
        return false;
    }
}
}