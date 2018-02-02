
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');?>

<p>Récapitulatif de votre billet :</p>

    <?php 
    echo "Emplacement sélectionné : ", $_SESSION['choix'].'<br/>';
    echo "Numéro de match : ".$match['id'].'<br/>';
    echo "Horaire du match : ".$match['horaire'].'<br/>';
    echo "Phase de tounoi : ".$match['phase'].'<br/>';
    
    if (isset($_SESSION['codePromo'])){
        echo "Code Promo : ", $_SESSION['codePromo']['CODE'].'<br/>';
    }
    if (isset($_SESSION['NumLicence'])){
        echo "Numéro de licence donnant lieu à une réduction : ",$_SESSION['NumLicence'].'<br/>';
    }
    ?>

    <FORM Method="POST" Action="index.php?page=paiement">
    <p> Nombre de billets :
    <INPUT type=text value=1 name=nbPlace></p>
    <INPUT type=submit value=Valider>
    </FORM>



<?php require_once(PATH_VIEWS.'footer.php');?>
