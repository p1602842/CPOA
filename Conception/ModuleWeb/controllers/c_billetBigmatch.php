<?php
require_once(PATH_MODELS."bigMatchDAO.php");

$m1 = new bigMatchDAO(DEBUG);
$list = $m1->getBigMatchSimple();

$m2 = new bigMatchDAO(DEBUG);
$list = $m2->getBigMatchDouble();


require_once(PATH_VIEWS.$page.'.php');