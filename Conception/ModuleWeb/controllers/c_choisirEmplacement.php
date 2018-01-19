<?php
require_once(PATH_MODELS."emplacementDAO.php");
require_once(PATH_MODELS."billetDAO.php");
require_once(PATH_MODELS.'matchSimpleDAO.php');
require_once(PATH_MODELS.'matchDoubleDAO.php');
require_once(PATH_MODELS.'bigMatchDAO.php');

$bil = new BilletDAO(DEBUG);

switch ($_GET['type']) {
    case 'simple':
        $resource = new matchSimpleDAO(DEBUG);
        $billets = $bil->getSimpleMatchBillets($_GET['idMatch']);
        break;
    case 'double':
        $resource = new matchDoubleDAO(DEBUG);
        $billets = $bil->getDoubleMatchBillets($_GET['idMatch']);
        break;
}

$match = $resource->getMatchById($_GET['idMatch']);
$_SESSION['idMatch'] = $_GET['idMatch'];
$_SESSION['type'] = $_GET['type'];

$emp = new emplacementDAO(DEBUG);

$emplacements = $emp->getAllEmplacement();

if ($emplacements) {
    $selectOption = [];
    foreach($emplacements as $emplacement) {
        if (!$billets || !array_key_exists($emplacement->getId(), $billets) || $emplacement->getMaxPlace() > $billets[$emplacement->getId()]) {
            $selectOption[] = $emplacement->getNomEmplacement();
        }
    }
    
}


require_once(PATH_VIEWS.$page.'.php');

