<nav class="navbar navbar-default">
    <div class="container-fluid">
      <ul class="nav navbar-nav">
                  <li <?php echo ($page=='billetSimple' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetSimple">
                          Match Simple
                      </a>
                  </li>
                  <li <?php echo ($page=='billetDouble' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetDouble">
                          Match Double
                      </a>
                  </li>
                <li <?php echo ($page=='billetBigmatch' ? 'class="active"':'')?>>
                      <a href="index.php?page=billetBigmatch">
                          Big Match
                      </a>
                  </li>
      </ul>
    </div>
</nav>
