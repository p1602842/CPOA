<?php

class codePromo{
    private $id_codePromo;

    public function __construct($id_codePromo){
        $this->id_codePromo = $id_codePromo;
    }

    public function getIdCodePromo(){
        return$this->id_codePromo;
    }
}