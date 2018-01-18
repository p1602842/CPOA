<?php

class Licence{
    private $id_licence;

    public function __construct($id_licence){
        $this->id_licence = $id_licence;
    }

    public function getIdLicence(){
        return$this->id_licence;
    }

}