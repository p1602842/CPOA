<?php
require_once(PATH_MODELS."licenceDAO.php");
require_once(PATH_MODELS."codePromoDAO.php");
$bool = false;
$bool2= false;

if (isset($_POST["numLicence"])){
    $l = $_POST["numLicence"];
       
    $lDAO = new licenceDAO(DEBUG);
    $list = $lDAO->getAllLicence();
    if ($list){
        foreach($list as $item){
            if ($item == $l){
                $bool = true;
            }
        }
    }
   
}

if (isset($_POST["codePromo"])){
    $c = $_POST["codePromo"];
    $cDAO = new codePromoDAO(DEBUG);
    $list = $cDAO->getAllCodePromo();
    if ($list){
        foreach($list as $item){
            if ($item == $c){
                $bool2 = true;
            }
        }
    }
    
}
else{
    $bool2=true;
}

require_once(PATH_VIEWS.$page.'.php');