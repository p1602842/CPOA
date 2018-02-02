<?php

class JoueurEquipe {
    private $PRENOM_TENNISMAN;
    private $NOM_TENNISMAN;

    public function __construct($PRENOM_TENNISMAN, $NOM_TENNISMAN){
        $this->PRENOM_TENNISMAN = $PRENOM_TENNISMAN;
        $this->NOM_TENNISMAN = $NOM_TENNISMAN;
    }

    public function getPrenomJoueurEquipe(){
        return$this->PRENOM_TENNISMAN;
    }
    public function getNomJoueurEquipe(){
        return$this->NOM_TENNISMAN;
    }
}