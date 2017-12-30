
<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<header class="corps" >
  <section class="container" >
    <div class = "row">
      <div class="col-md-10 col-sm-10 col-xs-12">
        <h3><?= MESSAGE_BIENVENUE ?></h3>
      </div>
          <img src="<?= PATH_TENNIS ?>" alt="<?= TENNIS ?>" class="img-accueil">
    </div>
      <h4><?= MESSAGE_POUR_ADMIN ?></h4>
  </section>
</header>
<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');
