<nav class="navbar navbar-default">
    <div class="container-fluid">
      <ul class="nav navbar-nav">
                  <li <?php echo ($page=='billetSimple' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetSimple">
                          <?= MENU_SIMPLE ?>
                      </a>
                  </li>
                  <li <?php echo ($page=='billetDouble' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetDouble">
                          <?= MENU_DOUBLE ?>
                      </a>
                  </li>
                <li <?php echo ($page=='billetBigmatch' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetBigmatch">
                          <?= MENU_BIGMATCH ?>
                      </a>
                  </li>
      </ul>
    </div>
</nav>