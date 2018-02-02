<?php 

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."emplacement.php";

class emplacementDAO extends DAO{
    public function getAllEmplacement(){
        $list = array();
        $req = $this->queryAll("SELECT * FROM EMPLACEMENT");
        if($req){
        foreach ($req as $emplacement){
            $list[] = new emplacement($emplacement[0],$emplacement[1],$emplacement[2],$emplacement[3]);
        }
        return $list;
    } else {
        return false;
    }
    }
    public function getCapaciteEmplacement($idEmplacement){
        $req = $this->queryRow("select ID_EMPLACEMENT, CAPACITE_MAX FROM EMPLACEMENT WHERE ID_EMPLACEMENT=?",[$idEmplacement]);
        return $req;
    }


}