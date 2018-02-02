<?php
if(!$_SESSION['logged']){
    echo(TEXTE_ACCES_REFUSE);
}else{
?>
<nav class="navbar navbar-default">
    <div class="container-fluid">
      <ul class="nav navbar-nav">

                  <li <?php echo ($page=='billetAdmin' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetAdmin">
                          <?= MENU_BILLET ?>
                      </a>
                  </li>
                <li <?php echo ($page=='planningAdmin' ? 'class="active"':'')?>>
                      <a href="index.php?page=planningAdmin">
                          <?= MENU_PLANNING ?>
                      </a>
                  </li>
      </ul>
    </div>
</nav>
<?php } ?>