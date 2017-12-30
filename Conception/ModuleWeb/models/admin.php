<?php

class Admin{
	private $id;
	private $username;



	public function __construct($id, $username, $password){
		$this->id = $id;
		$this->username = $username;
		$this->password = $password;
	}

	public function getId(){
		return $this->id;
	}

	public function getUsername(){
		return htmlspecialchars($this->username);
	}

    public function getPassword(){
		return htmlspecialchars($this->password);
	}

}
