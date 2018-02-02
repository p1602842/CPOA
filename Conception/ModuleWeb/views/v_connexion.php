<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<?php if(!isset($_SESSION["logged"])){ ?>


<div id="intro-wrapper" class="wrapper style2">
<h1><?= TITRE_PAGE_CONNEXION ?></h1>
    <form action="index.php?page=connexion" method="post" class="well">
         <div>
             <label><?= FORM_CONNEXION_IDENTIFIANT ?></label>
             <input type="text" name="username">
        </div>

         <div >
             <label><?= FORM_CONNEXION_MDP ?></label>
             <input type="password" name="pass">
        </div>


        <input class="btn" type="submit" value="<?= BUTTON_CONNEXION ?>">

    </form>
</div>

<?php } ?>

<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');
