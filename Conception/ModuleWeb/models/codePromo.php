<?php

class codePromo{
    private $id_codePromo;
    private $reduction;

    public function __construct($id_codePromo, $reduction){
        $this->id_codePromo = $id_codePromo;
        $this->reduction = $reduction;
    }

    public function getIdCodePromo(){
        return$this->id_codePromo;
    }

    public function getReduction(){
        return $this->reduction;
    }
}