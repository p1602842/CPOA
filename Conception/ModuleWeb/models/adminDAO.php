<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."admin.php";

class AdminDAO extends DAO {

    public function connexion($username, $pass){

		$user = $this->queryRow("select * from ADMINISTRATEUR where IDENTIFIANT_ADMIN = ? and MDP_ADMIN= ?;", array($username, $pass));
		if ($user){
				return new Admin($user[0], $user[1]);
		} else {
			return false;
        }
    }
}
