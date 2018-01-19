<?php

class matchDouble{
    private $ID_MATCH_DOUBLE;
    private $HORAIRE_DOUBLE;
    private $PHASE_TOURNOI_DOUBLE;
    private $EQUIPE;
    private $JOUEUR_EQUIPE1;
    private $JOUEUR_EQUIPE2;
    private $TERRAIN;

	
	
	public function __construct($ID_MATCH_DOUBLE, $HORAIRE_DOUBLE, $PHASE_TOURNOI_DOUBLE, $EQUIPE, $JOUEUR_EQUIPE1,$JOUEUR_EQUIPE2, $TERRAIN){
        $this->ID_MATCH_DOUBLE = $ID_MATCH_DOUBLE;
        $this->HORAIRE_DOUBLE = $HORAIRE_DOUBLE;
        $this->PHASE_TOURNOI_DOUBLE = $PHASE_TOURNOI_DOUBLE;
        $this->EQUIPE = $EQUIPE;
        $this->JOUEUR_EQUIPE1 = $JOUEUR_EQUIPE1;
        $this->JOUEUR_EQUIPE2 = $JOUEUR_EQUIPE2;
        $this->TERRAIN = $TERRAIN;

    }
    
    public function getIdMatchDouble(){
        return$this->ID_MATCH_DOUBLE;
    }
    public function getHoraireDouble(){
        return$this->HORAIRE_DOUBLE;
    }
    public function getPhaseTournoiDouble(){
        return$this->PHASE_TOURNOI_DOUBLE;
    }
    public function getEquipe(){
        return$this->EQUIPE;
    }
    public function getJoueurEquipe1(){
        return$this->JOUEUR_EQUIPE1;
    }
    public function getJoueurEquipe2(){
        return$this->JOUEUR_EQUIPE2;
    }
    public function getTerrain(){
        return$this->TERRAIN;
    }

}