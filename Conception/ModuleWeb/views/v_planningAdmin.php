<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{
    require_once(PATH_VIEWS.'menuAdmin.php');

    if(isset($success) && $success)
        echo '<p>Ajout du planning effectué</p>';
    
    else {
        
?>

    <form class="well" action="index.php?page=planningAdmin" method="post" enctype="multipart/form-data">

        <div class="form-group">
            <label><?= FORM_QUESTION_PLANNING_FICHIER ?></label>
            <input type="file" class="form-control-file" name="fichier" aria-describedby="fileHelp">
        </div>
        <button type="submit" name="envoyer" class="btn btn-default"><?= BUTTON_ENVOYER ?></button>
        
    </form>
    </div>


<?php 
    }   
}
require_once(PATH_VIEWS.'footer.php');