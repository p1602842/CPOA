<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'alert.php');?>

<?php
if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{
    echo "Niveau choisit : ".($_SESSION['choix']);
   ?>
   <form>
        <div>   
            Nouveau prix : 
            <INPUT type=text size=20 name=prix placeholder="saisir prix">
        </div>
        <br/><INPUT type=submit value="Valider les changements">
    </FORM>
    <?php
}
require_once(PATH_VIEWS.'footer.php');?>