
<?php require_once(PATH_VIEWS.'header.php');?>

<?php require_once(PATH_VIEWS.'alert.php');?>


<?php 
    echo '<div class="divMatch"><br/><table>';
    echo '<tr>';
    echo '<td>';
    echo "Votre billet  <br/>"; 
    echo '</td>';
    echo '</tr>';
   
    echo '<tr>'; 
    echo '<td>';   
    echo "Prix du billet : " ;
    echo '</td>';
    echo '<td>' .$prices['regular'] .'$CAD <br />';
    echo '</td>';
    echo '</tr>';

echo '<tr>';
echo '<td>';
echo "Prix du billet après réductions : ";
echo '</td>';
echo '<td>'. $prices['reduced'] .'$CAD<br />';
echo '</td>';
echo '</tr>';


echo '<tr>';
echo '<td>';
echo "Prix total pour le nombre de place choisies : ";
echo '</td>';
echo '<td>'. $prices['total'] .'$CAD<br />';
echo '</td>';
echo '</tr>';?>

</table></div>
<?php require_once(PATH_VIEWS.'footer.php');?>