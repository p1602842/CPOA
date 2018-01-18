<?php

class Terrain{
    private $NOM_TERRAIN;

    public function __construct($NOM_TERRAIN){
        $this->NOM_TERRAIN = $NOM_TERRAIN;
    }
    public function getNomTerrain(){
        return $this->NOM_TERRAIN;
    }
}