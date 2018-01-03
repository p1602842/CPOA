<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo('Cette page est accesible uniquement pour les administrateurs, merci de vous authentifier.');
}
else{
    require_once(PATH_VIEWS.'menuAdmin.php');
    
}
require_once(PATH_VIEWS.'footer.php');
