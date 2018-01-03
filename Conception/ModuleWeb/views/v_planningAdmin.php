<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo('Cette page est accesible uniquement pour les administrateurs, merci de vous authentifier.');
}
else{
    require_once(PATH_VIEWS.'menuAdmin.php');
    ?>

    <div class="col-xs-8 col-sm-6 col-md-4">


    <form class="well" action="index.php?page=planningAdmin" method="post" enctype="multipart/form-data">

        <div class="form-group">
            <label><?= FORM_QUESTION_PLANNING_FICHIER ?></label>
            <input type="file" class="form-control-file" name="fichier" aria-describedby="fileHelp">
        </div>
        <button type="submit" class="btn btn-default"><?= BUTTON_ENVOYER ?></button>
        
    </form>
    </div>


<?php    
}
require_once(PATH_VIEWS.'footer.php');