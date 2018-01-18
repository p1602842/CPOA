<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."codePromo.php";

class codePromoDAO extends DAO {
public function getAllCodePromo(){
    $list = array();
    $req = $this->queryAll("SELECT CODE FROM CODEPROMO");
    if($req){
        foreach ($req as $codePromo){
            $list[] = new codePromo($codePromo[0]);
        }
        return $list;
    } else {
        return false;
    }
}
}