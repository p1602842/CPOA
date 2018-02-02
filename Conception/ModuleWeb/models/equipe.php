<?php

class Equipe {
    private $ID_EQUIPE;

    public function __construct($ID_EQUIPE){
        $this->ID_EQUIPE = $ID_EQUIPE;
    }
    public function getIdEquipe(){
        return$this->ID_EQUIPE;
    }
}