<?php 

define('LICENCEPROMO', 0.2);

$_SESSION['nbPlace'] = $_POST['nbPlace'];

require_once(PATH_MODELS.'matchSimpleDAO.php');
require_once(PATH_MODELS.'matchDoubleDAO.php');
require_once(PATH_MODELS.'bigMatchDAO.php');

switch ($_SESSION['type']) {
    case 'simple':
        $resource = new matchSimpleDAO(DEBUG);
        
        break;
    case 'double':
        $resource = new matchDoubleDAO(DEBUG);
                
        break;
}

$match = $resource->getMatchById($_SESSION['idMatch']);
$prices = [];
$prices['regular']=  $match['PRIX_DE_BASE'];
$reduction = 0;

if (!empty($_SESSION['codePromo'])) {
    $reduction += $_SESSION['codePromo']['REDUCTION'];
}
if (!empty($_SESSION['licence'])) {
    $reduction += LICENCEPROMO;
}

$prices['reduced'] = $match['PRIX_DE_BASE'] * (1-$reduction);
$prices['total'] = $_POST['nbPlace'] * $prices['reduced'];

?>
<?php require_once(PATH_VIEWS.$page.'.php');
