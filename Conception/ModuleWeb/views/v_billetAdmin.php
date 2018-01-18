<?php require_once(PATH_VIEWS.'header.php');

if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}
else{
    require_once(PATH_VIEWS.'menuAdmin.php');
    
}
require_once(PATH_VIEWS.'footer.php');