<?php

function choixAlert($message, $arg=null)
{
  $alert = array();
  switch($message)
  {
    //Erreurs
      case 'connexion_bdd':
          $alert['messageAlert'] = ERREUR_CONNECT_BDD;
          break;
      case 'query' :
          $alert['messageAlert'] = ERREUR_QUERY_BDD;
          break;
      case 'url_non_valide' :
          $alert['messageAlert'] = TEXTE_PAGE_404;
          break;      
      case 'nonAdmin' :
          $alert['messageAlert']= ERREUR_IS_CO;
          break;
      case 'cat_empty' :
          $alert['messageAlert'] = ERREUR_FORM_CAT_EMPTY;
          break;
       case 'cat_already_exist' :
          $alert['messageAlert'] = ERREUR_FORM_CAT_ALREADYEXIST;
          break;
       case 'cat_longueur' :
          $alert['messageAlert'] = ERREUR_FORM_CAT_LONGUEUR;
          break;
       case 'login_id' :
          $alert['messageAlert'] = ERREUR_FORM_CONNEXION_UNKNOWID;
          break;
       case 'login_pass' :
          $alert['messageAlert'] = ERREUR_FORM_CONNEXION_PASSWORD;
          break;
       case 'photo_badid' :
          $alert['messageAlert'] = ERREUR_PHOTO_BADID;
          break;
       case 'photo_delete' :
          $alert['messageAlert'] = ERREUR_PHOTO_DELETE;
          break;
       case 'photo_modif' :
          $alert['messageAlert'] = ERREUR_PHOTO_MODIF;
          break;
       case 'photo_vandale' :
          $alert['messageAlert'] = ERREUR_PHOTO_VANDALE;
          break;

    //Informations
      case 'selectedPhotos':
          $alert['messageAlert'] = $arg." ".TEXTE_SELECTED_PHOTOS;
          $alert["classAlert"] = "success";
      break;
       case 'add_cat':
          $alert['messageAlert'] =TEXTE_FORM_CAT_SUCCESS;
          $alert["classAlert"] = "success";
      break;
       case 'add_photo':
          $alert['messageAlert'] = TEXTE_FORM_PHOTO_SUCCESS;
          $alert["classAlert"] = "success";
      break;
       case 'connexion':
          $alert['messageAlert'] =TEXTE_FORM_CONNEXION_SUCCESS1.$arg.TEXTE_FORM_CONNEXION_SUCCESS2;
          $alert["classAlert"] = "success";
      break;
        case 'inscription':
          $alert['messageAlert'] =TEXTE_FORM_INSCRIPTION_SUCCESS1.$arg.TEXTE_FORM_INSCRIPTION_SUCCESS2;
          $alert["classAlert"] = "success";
      break;
        case 'photo_delete_success':
          $alert['messageAlert'] = TEXTE_PHOTO_DELETE_SUCCESS;
          $alert["classAlert"] = "success";
      break;
        case 'photo_modif_success':
          $alert['messageAlert'] =TEXTE_PHOTO_MODIF_SUCCESS;
          $alert["classAlert"] = "success";
      break;








    default :
      $alert['messageAlert'] = MESSAGE_ERREUR;
  }
  return $alert;
}
