<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'alert.php');?>

	<body>
        <div>
            <?php echo(CHOIX_ZONE), $_POST['choix'];?>
            
	    </div>
        <div>
            <br/><?php echo(FORM_LICENCIE) ?>
            <FORM Method="POST" Action="index.php?page=licencie">
                <?php echo(FORM_LICENCIE_NUMERO) ?> <br/>
                <INPUT type=text size=20 name=numLicence placeholder="facultatif">
        </div>
        <div>   
                <br/><?php echo(FORM_CODE_PROMO_QUESTION) ?> <br/>
                <?php echo(FORM_CODE_PROMO_NUMERO) ?> <br/>
                <INPUT type=text size=20 name=codePromo placeholder="facultatif">
                <INPUT type=hidden name=choix value=<?= $_POST['choix']?>>
        </div>
                <br/><INPUT type=submit value=Ajouter>
                <INPUT type=submit value=Suivant>
            </FORM>

            <?php foreach ($errors as $e){
                echo $e;
            }
            ?>
	</body>

    
<?php require_once(PATH_VIEWS.'footer.php');?>