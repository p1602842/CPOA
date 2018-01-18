<!-- Menu du site -->
<nav class="navbar navbar-default">
  
  <div class="container-fluid">
    <ul class="nav navbar-nav">
				<li <?php echo ($page=='accueil' ? 'class="active"':'')?>>
					<a href="index.php">
						<?= MENU_ACCUEIL ?>
                    </a>
				</li>
				<li <?php echo ($page=='billet' ? 'class="active"':'')?>>
					<a href="index.php?page=billet">
                        <?= MENU_BILLET ?>
                    </a>
				</li>
                <li <?php echo ($page=='planning' ? 'class="active"':'')?>>
					<a href="index.php?page=planning">
						<?= MENU_PLANNING ?>
                    </a>
				</li>

				<?php if($_SESSION['logged']){?>
				<li <?php echo ($page=='administrateur' ? 'class="active"':'')?> >
					<a href="index.php?page=administrateur">
						<?= MENU_ADMIN ?>
					</a>
				</li>
				<?php } ?>
    </ul>
	<ul class="nav navbar-nav navbar-right">
        <?php if(!$_SESSION['logged']){ ?>
        <li <?php echo ($page=='connexion' ? 'class="active"':'')?> >
            <a href="index.php?page=connexion"><?= MENU_CONNEXION ?></a>
        </li>

        <?php } else { ?>
        <li>
            <a href="index.php?page=deconnexion"><?= MENU_DECONNEXION ?></a>
        </li>


        <?php } ?>
	</ul>
  </div>
</nav>