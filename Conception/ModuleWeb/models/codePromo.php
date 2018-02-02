<?php

class codePromo{
    private $id_codePromo;
    private $quantiteMax;
    private $reduction;

    public function __construct($id_codePromo, $quantiteMax, $reduction){
        $this->id_codePromo = $id_codePromo;
        $this->quantiteMax = $quantiteMax;
        $this->reduction = $reduction;
    }

    public function getIdCodePromo(){
        return$this->id_codePromo;
    }

    public function getReduction(){
        return $this->reduction;
    }
    public function getQuantiteMax(){
        return $this->quantiteMax;
    }
}