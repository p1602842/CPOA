<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{
    ?>
	<div id="intro-wrapper" class="wrapper style2">
	<a href="index.php?page=billetAdmin"> Revenir au choix des modifications applicables aux billets. </a> </br>
	
	

	<button onclick=\'document.location.href="index.php?page=modifPrix2"\'>Match Simple</button>	
		
	<button onclick=\'document.location.href="index.php?page=modifPrix2"\'>Match Double</button>
		
	<button onclick=\'document.location.href="index.php?page=modifPrix2"\'>Big Match</button>
	</div>
	<?php



	


}
require_once(PATH_VIEWS.'footer.php');?>