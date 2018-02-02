<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'alert.php');?>

<?php
if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{

    $selectOption = ["Niveau 0 - Rez de chaussée","Niveau 1 - Place numérotées","Niveau 2 - Place numérotées","Niveau 3 - Place non numérotées"];
    ?>

    <div> 
    
        <form method="post" action="index.php?page=modifPrix3">
        <td>Choisir le niveau d'emplacement sur lequel vous souhaitez modifier le prix :</td>
        <td>
			<select name="choix" onchange="this.form.submit()">
			<option selected="selected" disabled="disabled">Niveaux</option>
			<?php
				foreach ($selectOption as $option){
					echo "<option value='$option'>$option</option>";
				}
			?>
			</select>
	</td>
    </form>
    </div>

<?php
    
    
}
require_once(PATH_VIEWS.'footer.php');?>




