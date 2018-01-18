
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');
require_once(PATH_VIEWS.'menuBillet.php'); 

foreach ($list as $match){
    
    echo "Numéro du match : " . $match->getIdMatchDouble().'<br/>';
    echo "Horaire : ".$match->getHoraireDouble().'<br/>';
    echo "Phase tournoi : ".$match->getPhaseTournoiDouble().'<br/>';
    $equipe=$match->getEquipe();
    $joueurEquipe1=$match->getJoueurEquipe($equipe[0]);
    $joueurEquipe2=$match->getJoueurEquipe($equipe[1]);
    
    if ($equipe!=NULL){
        echo "Equipe n°: ". $equipe[0]->getIdEquipe().'<br/>'.
        "Tennisman n°1: ".$joueurEquipe1[0]->getPrenomJoueurEquipe()." ".$joueurEquipe1[0]->getNomJoueurEquipe().'<br/>'.
        "Tennisman n°2: ".$joueurEquipe1[1]->getPrenomJoueurEquipe()." ".$joueurEquipe1[1]->getNomJoueurEquipe().'<br/>';

        echo "Equipe n°: ".$equipe[1]->getIdEquipe().'<br/>'.
        "Tennisman n°1: ".$joueurEquipe2[0]->getPrenomJoueurEquipe()." ".$joueurEquipe2[0]->getNomJoueurEquipe().'<br/>'.
        "Tennisman n°2: ".$joueurEquipe2[1]->getPrenomJoueurEquipe()." ".$joueurEquipe2[1]->getNomJoueurEquipe().'<br/>';
    }


    if($match->getTerrain()){
        echo "Terrain: ".$match->getTerrain()->getTerrain().'<br/>';
    }
    echo '<a href="index.php?page=choisirEmplacement">Choisir ce match</a>';
    echo '<br/>' ;
    echo '<br/>' ;


}



require_once(PATH_VIEWS.'footer.php');?>