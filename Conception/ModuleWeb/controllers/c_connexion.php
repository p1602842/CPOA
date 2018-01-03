<?php

if($_SESSION['logged'])header("Refresh:0; url=index.php");


if (isset($_POST['username'])){

    require_once(PATH_MODELS."adminDAO.php");
    $u = new AdminDAO(DEBUG);
    

    $user = $u->connexion($_POST['username'], ($_POST['pass']));

	if(!$user){
        $alert = choixAlert('login_pass');
		require_once(PATH_VIEWS.$page.'.php');
        exit();
	}
   
    $alert = choixAlert('connexion', $user->getId());

	$_SESSION['logged'] = true;
    $_SESSION['user'] = $user;

    header("Refresh:2; url=index.php");
};

require_once(PATH_VIEWS.$page.'.php');
