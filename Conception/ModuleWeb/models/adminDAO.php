<?php

require_once PATH_MODELS."DAO.php";
require_once PATH_MODELS."admin.php";

class AdminDAO extends DAO {

    public function connexion($username, $hash){

		$user = $this->queryRow("select * from USER where username = ? and password= ?;", array($username, $hash));
		if ($user){
				return new User($user[0], $user[1], $user[2], $user[3]);
		} else {
			return false;
        }
    }
}
