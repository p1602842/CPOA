<?php

class Emplacement
{
    private $ID_EMPLACEMENT;
    private $NOM_EMPLACEMENT;
    private $surcout;
    private $capacite_max;

    public function __construct($ID_EMPLACEMENT,$NOM_EMPLACEMENT,$surcout,$capacite_max){
        $this->ID_EMPLACEMENT=$ID_EMPLACEMENT;
        $this->NOM_EMPLACEMENT=$NOM_EMPLACEMENT;
        $this->surcout=$surcout;
        $this->capacite_max=$capacite_max;
    }

    public function getNomEmplacement(){
        return $this->NOM_EMPLACEMENT;
    }

    public function getMaxPlace()
    {
        return $this->capacite_max;
    }

    public function getId(){
        return  $this->ID_EMPLACEMENT;
    }
}