<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."licence.php";

class licenceDAO extends DAO {
public function getAllLicence(){
    $list = array();
    $req = $this->queryAll("SELECT NUMLICENCIE FROM LICENCIE");
    if($req){
        foreach ($req as $licence){
            $list[] = new licence($licence[0]);
        }
        return $list;
    } else {
        return false;
    }
}
public function getLicence($licence){
    $req = $this->queryRow("SELECT * FROM LICENCIE WHERE NUMLICENCIE = ?",[$licence]);
    return $req;
}

}