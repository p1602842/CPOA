<?php


//regarde si image
if(isset($_POST["envoyer"])){

    $success = move_uploaded_file($_FILES['fichier']['tmp_name'], 'assets/images/planning.png');

}


//appel de la vue
require_once(PATH_VIEWS.$page.'.php');