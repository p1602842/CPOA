<?php 

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."equipe.php";

class equipeDAO extends DAO{
    public function getEquipe($ID_MATCH){
        $list = array();
        $args = array($ID_MATCH);
        $req = $this->queryAll("SELECT ID_EQUIPE
        FROM JOUE_DOUBLE
        WHERE ID_MATCH_DOUBLE = ?", $args);
        if($req){
        foreach ($req as $equipe){
            $list[] = new equipe($equipe[0]);
        }
        return $list;
    } else {
        return false;
        }
    }

}