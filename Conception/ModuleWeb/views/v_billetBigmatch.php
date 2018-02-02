
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');
require_once(PATH_VIEWS.'menuBillet.php'); 

foreach ($list as $match){
    if (get_class($match) =="matchSimple" ) {
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

    if (get_class($match) =="matchDouble" ) {
        echo '<div class="divMatch"><br/><table>'; ?>

<tr>
    <td>Numéro du match : </td>
    <td><?= $match->getIdMatchDouble() ?></td>
</tr>
<tr>
    <td>Horaire : </td>
    <td><?= $match->getHoraireDouble() ?></td>
</tr>
<tr>
    <td>Phase tournoi : </td>
    <td><?= $match->getPhaseTournoiDouble() ?></td>
</tr>
<?php
$equipe=$match->getEquipe();
$joueurEquipe1=$match->getJoueurEquipe1($equipe[0]);
$joueurEquipe2=$match->getJoueurEquipe2($equipe[1]);
if ($equipe!=NULL){
?>
<tr>
    <td> Equipe n° : </td>
    <td><?=$equipe[0]->getIdEquipe()?></td>
</tr>
<tr>
    <td>Tennisman n°1</td>
    <td><?= $joueurEquipe1[0]->getPrenomJoueurEquipe()." ".$joueurEquipe1[0]->getNomJoueurEquipe() ?></td>
</tr>
<tr>
    <td>Tennisman n°2</td>
    <td><?= $joueurEquipe1[1]->getPrenomJoueurEquipe()." ".$joueurEquipe1[1]->getNomJoueurEquipe() ?></td>
</tr>

<tr>

    <td> Equipe n° :  </td>
    <td><?=$equipe[1]->getIdEquipe()?></td>
</tr>
<tr>
    <td>Tennisman n°1 : </td>
    <td><?= $joueurEquipe2[0]->getPrenomJoueurEquipe()." ".$joueurEquipe2[0]->getNomJoueurEquipe() ?></td>
</tr>
<tr>
    <td>Tennisman n°2 : </td>
    <td><?= $joueurEquipe2[1]->getPrenomJoueurEquipe()." ".$joueurEquipe2[1]->getNomJoueurEquipe() ?></td>
</tr>
<?php
}
if($terrain = current($match->getTerrain())){ ?>
<tr>
    <td>Terrain : </td>
    <td><?= $terrain->getNomTerrain() ?></td>
</tr>
<?php
}

echo '</table>';

echo '<button onclick=\'document.location.href="index.php?page=choisirEmplacement&idMatch='.$match->getIdMatchDouble().'&type=double"\'>Choisir ce match</button>';
echo '<br/>';
echo '</div>';
    }


}



require_once(PATH_VIEWS.'footer.php');?>