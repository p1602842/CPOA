<!-- Menu du site -->

<nav id="nav">
	<ul>
		<li class="current" <?php echo ($page=='accueil' ? 'class="active"':'')?>>
		<a href="index.php">Accueil</a></li>
		
		<li <?php echo ($page=='billet' ? 'class="active"':'')?>>
		<a href="index.php?page=billet">Billet</a></li>
		
		<li<?php echo ($page=='planning' ? 'class="active"':'')?>>
		<a href="index.php?page=planning">Planning</a></li>
		
		<?php if(isset($_SESSION['logged'])){?>
		<li<?php echo ($page=='administrateur' ? 'class="active"':'')?>>
		<a href="index.php?page=administrateur"> Administrateur</a></li>
		<?php }?>	

		<?php if(empty($_SESSION['logged'])){ ?>
		<li <?php echo ($page=='connexion' ? 'class="active"':'')?>>
		<a href="index.php?page=connexion">Connexion Administrateur</a></li>

		<?php } else { ?>
        <li>
            <a href="index.php?page=deconnexion">Se déconnecter</a>
        </li>
        <?php } ?>
		<li>
			<a href="#">About us</a>
			<ul>
				<li>Simon Lecutiez</li>
				<li>Antoine Henrionnet</li>
				<li>Claire Mathez</li>
			</ul>
		</li>
	</ul>
</nav>
<nav class="navbar navbar-default">
