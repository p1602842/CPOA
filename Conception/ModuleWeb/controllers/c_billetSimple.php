<?php
require_once(PATH_MODELS."matchSimpleDAO.php");
require_once(PATH_MODELS."joueurDAO.php");
require_once(PATH_MODELS."terrainDAO.php");

$m = new matchSimpleDAO(DEBUG);
$list = $m->getMatchSimpleVisiteur();

require_once(PATH_VIEWS.$page.'.php');