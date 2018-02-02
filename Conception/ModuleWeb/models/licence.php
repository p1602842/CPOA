<?php

class Licence{
    private $id_licence;
    private $reduction;

    public function __construct($id_licence, $reduction){
        $this->id_licence = $id_licence;
        $this->reduction = $reduction;
    }

    public function getIdLicence(){
        return$this->id_licence;
    }

    public function getReduction(){
        return $this->reduction;
    }

}