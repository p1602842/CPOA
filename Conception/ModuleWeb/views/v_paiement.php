
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');?>
<p>
Prix du billet : <?= $prices['regular'] ?> $CAD <br />
Prix du billet après réductions : <?= $prices['reduced'] ?> $CAD<br />
Prix total pour le nombre de place choisies : <?= $prices['total'] ?> $CAD<br />
</p>
<?php require_once(PATH_VIEWS.'footer.php');?>