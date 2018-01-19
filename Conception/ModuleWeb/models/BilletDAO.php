<?php 

require_once PATH_MODELS."DAO.php";

class billetDAO extends DAO{
    public function getSimpleMatchBillets($idMatch){
        $list = array();
        $req = $this->queryAll("SELECT count(id_billet) as total, id_emplacement FROM BILLET WHERE ID_MATCH_SIMPLE = ? group by id_emplacement", array($idMatch));
        if($req){
            foreach ($req as $billet){
                $list[$billet['id_emplacement']] = $billet['total'];
            }
            return $list;
        } else {
            return false;
        }
    }

    public function getDoubleMatchBillets($idMatch){
        $list = array();
        $req = $this->queryAll("SELECT count(id_billet) as total, id_emplacement FROM BILLET WHERE ID_MATCH_DOUBLE = ? group by id_emplacement", array($idMatch));
        if($req){
            foreach ($req as $billet){
                $list[$billet['id_emplacement']] = $billet['total'];
            }
            return $list;
        } else {
            return false;
        }
    }


}