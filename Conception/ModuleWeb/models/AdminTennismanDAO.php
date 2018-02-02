<?php

require_once('DAO.php');

class AdminTennismanDAO extends DAO {
	
	public function getTennismanbyID($ID){
		return $this -> queryRow('SELECT * FROM `tennisman` where `idTennisMan`=?', array($ID));
	}
}
?>