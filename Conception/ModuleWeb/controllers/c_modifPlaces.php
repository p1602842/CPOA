<?php

require_once(PATH_MODELS.'matchSimpleDAO.php');
require_once(PATH_MODELS.'matchDoubleDAO.php');
require_once(PATH_MODELS."bigMatchDAO.php");

require_once(PATH_MODELS."joueurEquipeDAO.php");
require_once(PATH_MODELS."terrainDAO.php");
require_once(PATH_MODELS."equipeDAO.php");

$mS = new matchSimpleDAO(DEBUG);
$listS = $mS->getMatchSimpleVisiteur();

$mD = new matchDoubleDAO(DEBUG);
$listD = $mD->getMatchDoubleVisiteur();


$mBM = new bigMatchDAO(DEBUG);
$listBM = [];
if ($listsimple = $mBM->getBigMatchSimple()) {
    $listBM = array_merge($listBM, $listsimple);
}
if ($listdouble = $mBM->getBigMatchDouble()) {
    $listBM = array_merge($listBM, $listdouble);
}



if (isset($_SESSION["logged"]) && $_SESSION["logged"]){
	require_once(PATH_VIEWS.'modifPlaces.php');
}else {
	require_once(PATH_VIEWS.'404.php');
}
?>