<?php
require_once(PATH_MODELS."emplacementDAO.php");
require_once(PATH_MODELS."billetDAO.php");

$emp = new emplacementDAO(DEBUG);

$emplacements = $emp->getAllEmplacement();

$bil = new BilletDAO(DEBUG);

$billets = $bil->getSimpleMatchBillets(1);
$selectOption = [];

foreach($emplacements as $emplacement) {
    if (!array_key_exists($emplacement->getId(), $billets) || $emplacement->getMaxPlace() > $billets[$emplacement->getId()]) {
        $selectOption[] = $emplacement->getNomEmplacement();
    }
}

require_once(PATH_VIEWS.$page.'.php');

