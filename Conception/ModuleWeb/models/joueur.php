<?php

class Tennisman{
    private $ID_TENNISMAN;
    private $ID_EQUIPE;
    private $NOM_TENNISMAN;
    private $PRENOM_TENNISMAN;
    private $RANG;

    public function __construct($NOM_TENNISMAN,$PRENOM_TENNISMAN){
        $this->NOM_TENNISMAN = $NOM_TENNISMAN;
        $this->PRENOM_TENNISMAN = $PRENOM_TENNISMAN;
    }

    public function getNomTennisman(){
        return$this->NOM_TENNISMAN;
    }

    public function getPrenomTennisman(){
        return$this->PRENOM_TENNISMAN;
    }

}