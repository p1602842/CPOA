<?php
require_once(PATH_MODELS."bigMatchDAO.php");

$m = new bigMatchDAO(DEBUG);
$list = [];
if ($listsimple = $m->getBigMatchSimple()) {
    $list = array_merge($list, $listsimple);
}
if ($listdouble = $m->getBigMatchDouble()) {
    $list = array_merge($list, $listdouble);
}



require_once(PATH_VIEWS.$page.'.php');