<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."statistiques.php";

class statistiquesDAO extends DAO {

    public function (){

		$req = $this->queryRow("select * from ADMINISTRATEUR where IDENTIFIANT_ADMIN = ? and MDP_ADMIN= ?;", array($username, $pass));
		if ($req){
				return new Statistiques();
		} else {
			return false;
        }
    }
}