
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');
require_once(PATH_VIEWS.'menuBillet.php'); 

foreach ($list as $match){
    
    echo "Numéro du match : " . $match->getID_MATCH_SIMPLE().'<br/>';
    echo "Horaire : ".$match->getHORAIRE_SIMPLE().'<br/>';
    echo "Phase tournoi : ".$match->getPHASE_TOURNOI_SIMPLE().'<br/>';
    $tennismen=$match->getTENNISMAN();
    if ($tennismen!=NULL){
        echo "Tennisman n°1: ".$tennismen[0]->getNomTennisman();
        echo " ".$tennismen[0]->getPrenomTennisman().'<br/>';
        echo "Tennisman n°2: ".$tennismen[1]->getNomTennisman();
        echo " ".$tennismen[1]->getPrenomTennisman().'<br/>';
    }
    if($match->getTERRAIN()){
        echo "Terrain: ".$match->getTERRAIN()->getNomTerrain().'<br/>';
    }


    echo '<a href="index.php?page=choisirEmplacement&idMatch='.$match->getID_MATCH_SIMPLE().'&type=simple">Choisir ce match</a>';
    echo '<br/>' ;
    echo '<br/>' ;


}



require_once(PATH_VIEWS.'footer.php');?>