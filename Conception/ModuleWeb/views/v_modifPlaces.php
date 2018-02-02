<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{
    ?>
    <a href="index.php?page=billetAdmin"> Revenir au choix des modifications applicables aux billets. </a> </br>
	<?="<p>Match Simple : <br/></p>";?>


	<?="<p>Match Double : <br/></p>";?>

		
	<?="<p>Big Match : <br/></p>";?>
	

<?php
}
require_once(PATH_VIEWS.'footer.php');?>