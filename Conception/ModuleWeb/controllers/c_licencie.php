<?php
require_once(PATH_MODELS."licenceDAO.php");
require_once(PATH_MODELS."codePromoDAO.php");
$errors = array();
$_SESSION['choix'] = $_POST['choix'];
unset($_SESSION['licence']);
unset($_SESSION['codePromo']);

if (!empty($_POST["numLicence"])){
    $l = $_POST["numLicence"];
    $lDAO = new licenceDAO(DEBUG);
    $exist = $lDAO->getLicence($l);
    if (!$exist) {
        $errors[] = "Licence invalide";
        
    } else {
        $_SESSION['licence']=$exist;
    }
}


if (!empty($_POST["codePromo"])){
    $c = $_POST["codePromo"];
    $cDAO = new codePromoDAO(DEBUG);
    $exist = $cDAO->getCodePromo($c); 
    if (!$exist) {
        $errors[] = "Code promo invalide";
    }
    else{
        $_SESSION['codePromo']=$exist;
    }

}


if (!count($errors) && array_key_exists('codePromo', $_POST)){
    $page='recapBillet';
    header('Location: index.php?page='.$page);
}

else{
    require_once(PATH_VIEWS.$page.'.php');
}


