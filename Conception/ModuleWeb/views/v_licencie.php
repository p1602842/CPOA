<?php require_once(PATH_VIEWS.'header.php');?>
<?php require_once(PATH_VIEWS.'alert.php');?>

	<body>
        <div>
            <?php echo(CHOIX_ZONE), $_POST['choix'];?>
	    </div>
            <?php echo(FORM_LICENCIE) ?>
            <FORM Method="POST" Action="index.php?page=licencie">
                <?php echo(FORM_LICENCIE_NUMERO) ?>
                <INPUT type=text size=20 name=numLicence>
                
                <?php echo(FORM_CODE_PROMO_QUESTION) ?>
                <?php echo(FORM_CODE_PROMO_NUMERO) ?>
                <INPUT type=text size=20 name=codePromo>
                
                <INPUT type=submit value=Envoyer>
            </FORM>

            <?php if (!$bool){ 
                echo "Numero de licence incorrect.";
            }
            if (!$bool2){
                echo "Code promo invalide.";
            }
            ?>
	</body>

    
<?php require_once(PATH_VIEWS.'footer.php');?>