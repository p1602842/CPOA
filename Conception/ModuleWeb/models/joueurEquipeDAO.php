<?php 

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."joueurEquipe.php";

class joueurEquipeDAO extends DAO{
    public function getJoueurEquipe($ID_EQUIPE){
        $list = array();
        $args = array($ID_EQUIPE);
        $req = $this->queryAll("SELECT PRENOM_TENNISMAN, NOM_TENNISMAN
        FROM TENNISMAN
        WHERE ID_EQUIPE = ?", $args);
        if($req){
            foreach ($req as $joueurEquipe){
                $list[] =  new joueurEquipe($joueurEquipe[0], $joueurEquipe[1]);
            }
            return $list;
        } else {
            return false;
        }
    }
}