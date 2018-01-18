/*
    La liste de tous les emplacements
*/
SELECT ID_EMPLACEMENT
FROM EMPLACEMENT;

/*
    Retourne le nombre de billets pris pour un emplacement pour un match (donc à faire pour tous les emplacements)
    ?1 -> l'id du match en question
    ?2 -> l'id de l'emplacement en question
*/
SELECT COUNT(ID_BILLET)
FROM BILLET
WHERE ID_MATCH_SIMPLE = ?1
AND ID_EMPLACEMENT = ?2;

/*
    ?1 -> le résultat du count juste au-dessus
*/
SELECT ID_EMPLACEMENT, NOM_EMPLACEMENT
FROM EMPLACEMENT
WHERE EMPLACEMENT.CAPACITE_MAX >= ?1;

/*
___________________________

OU SI C'EST UN MATCH DOUBLE
___________________________

*/

/*
    La liste de tous les emplacements
*/
SELECT ID_EMPLACEMENT
FROM EMPLACEMENT;

/*
    Retourne le nombre de billets pris pour un emplacement pour un match (donc à faire pour tous les emplacements)
    ?1 -> l'id du match en question
    ?2 -> l'id de l'emplacement en question
*/
SELECT COUNT(ID_BILLET)
FROM BILLET
WHERE ID_MATCH_DOUBLE = ?1
AND ID_EMPLACEMENT = ?2;

/*
    ?1 -> le résultat du count juste au-dessus
*/
SELECT ID_EMPLACEMENT, NOM_EMPLACEMENT
FROM EMPLACEMENT
WHERE EMPLACEMENT.CAPACITE_MAX >= ?1;