<?php
require_once(PATH_MODELS."matchDoubleDAO.php");
require_once(PATH_MODELS."joueurEquipeDAO.php");
require_once(PATH_MODELS."terrainDAO.php");
require_once(PATH_MODELS."equipeDAO.php");

$m = new matchDoubleDAO(DEBUG);
$list = $m->getMatchDoubleVisiteur();

require_once(PATH_VIEWS.$page.'.php');