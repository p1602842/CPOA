<?php

class Admin{
	private $IDENTIFIANT_ADMIN;
	private $MDP_ADMIN;



	public function __construct($IDENTIFIANT_ADMIN, $MDP_ADMIN){
		$this->$IDENTIFIANT_ADMIN=$IDENTIFIANT_ADMIN;
		$this->$MDP_ADMIN=$MDP_ADMIN;
	}

	public function getId(){
		return $this->IDENTIFIANT_ADMIN;
	}

    public function getPassword(){
		return htmlspecialchars($this->MDP_ADMIN);
	}

}
