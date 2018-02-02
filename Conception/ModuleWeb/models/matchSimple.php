<?php

class matchSimple{
	private $ID_MATCH_SIMPLE;
    private $HORAIRE_SIMPLE;
    private $PHASE_TOURNOI_SIMPLE;
    private $TENNISMAN; // liste d'objet
    private $TERRAIN; //objet

	
	
	public function __construct($ID_MATCH_SIMPLE, $HORAIRE_SIMPLE, $PHASE_TOURNOI_SIMPLE, $TENNISMAN, $TERRAIN){
		$this->ID_MATCH_SIMPLE = $ID_MATCH_SIMPLE;
        $this->TERRAIN = $TERRAIN;
        $this->TENNISMAN = $TENNISMAN;
        $this->HORAIRE_SIMPLE = $HORAIRE_SIMPLE;
        $this->PHASE_TOURNOI_SIMPLE = $PHASE_TOURNOI_SIMPLE;
    }
    
    public function getID_MATCH_SIMPLE() {
        return $this->ID_MATCH_SIMPLE;
    }

    public function getHORAIRE_SIMPLE() {
        return $this->HORAIRE_SIMPLE;
    }

    public function getPHASE_TOURNOI_SIMPLE() {
        return $this->PHASE_TOURNOI_SIMPLE;
    }

    public function getTENNISMAN() {
        return $this->TENNISMAN;
    }

    public function getTERRAIN() {
        return $this->TERRAIN;
    }


}