<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{
    require_once(PATH_VIEWS.'menuAdmin.php');?>
    <a href="index.php?page=modifPrix"> Modifier les prix Grand Public en fonction des niveaux. </a> </br>
    <a href="index.php?page=modifPlaces"> Modifier le nombre de places par catégorie de billet.</a> </br>
    <a href="index.php?page=modifReduc"> Modifier les taux de réduction, et de la quantité totale pour chaque code de réduction</a> </br>
    <a href="index.php?page=modifPromo"> Créer ou supprimer un code promo </a> </br>
<?php    
}
require_once(PATH_VIEWS.'footer.php');