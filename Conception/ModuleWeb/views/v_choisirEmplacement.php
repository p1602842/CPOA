
<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'alert.php');?>

    <body>
    <div align="center">
        <img src="<?= PATH_EMPLACEMENT ?>" alt="Emplacement" class="img-accueil">  
    
        <form method="post" action="index.php?page=licencie">
        <td align="center"> <? echo(CHOIX_EMPLACEMENT) ?></td>
        <td>
			<select name="choix" onchange="this.form.submit()">
			<option selected="selected" disabled="disabled">Emplacements</option>
			<?php
				foreach ($selectOption as $option){
					echo "<option value='$option'>$option</option>";
				}
			?>
			</select>
	</td>
    </form>
    </div>

<?php require_once(PATH_VIEWS.'footer.php');?>