
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');
require_once(PATH_VIEWS.'menuBillet.php'); 

foreach ($list as $match){
    echo '<div class="divMatch"><br/><table>'; ?>

        <tr>
            <td>Numéro du match :</td>
            <td><?= $match->getID_MATCH_SIMPLE() ?></td>
        </tr>
        <tr>
            <td>Horaire :</td>
            <td><?= $match->getHORAIRE_SIMPLE() ?></td>
        </tr>
        <tr>
            <td>Phase tournoi :</td>
            <td><?= $match->getPHASE_TOURNOI_SIMPLE() ?></td>
        </tr>
    <?php

    $tennismen=$match->getTENNISMAN();
    if ($tennismen!=NULL){
        ?>
        <tr>
            <td>Tennisman n°1</td>
            <td><?= $tennismen[0]->getNomTennisman() ?></td>
        </tr>
        <tr>
            <td>Tennisman n°2 :</td>
            <td><?= $tennismen[1]->getNomTennisman() ?></td>
        </tr>
    <?php
    }
    if(!empty($match->getTERRAIN())){ ?>
        <tr>
            <td>Terrain :</td>
            <td><?= $match->getTERRAIN()->getNomTerrain() ?></td>
        </tr>
        <?php
    }

    echo '</table>';

    echo '<button onclick=\'document.location.href="index.php?page=choisirEmplacement&idMatch='.$match->getID_MATCH_SIMPLE().'&type=simple"\'>Choisir ce match</button>';
    echo '<br/>';
    echo '</div>';
    
    


}



require_once(PATH_VIEWS.'footer.php');?>