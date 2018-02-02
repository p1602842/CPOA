/*
    Attention, il faudra convertir la phase (tour du tournoi) en 16èmes, 8èmes, …
    Idem pour les horaires, il faut les convertir en trucs compréhensibles
*/
SELECT ID_MATCH_SIMPLE, HORAIRE_SIMPLE, PHASE_TOURNOI_SIMPLE
FROM MATCHSIMPLE
WHERE PHASE_TOURNOI_SIMPLE = 8
AND ACCESSIBLE_SIMPLE = 1
AND JOUE_SIMPLE = 0;

/*
    ?1 -> ID du match pour lequel tu veux récupérer les joueurs
*/
SELECT PRENOM_TENNISMAN, NOM_TENNISMAN
FROM TENNISMAN
INNER JOIN JOUE_SIMPLE
WHERE TENNISMAN.ID_TENNISMAN = JOUE_SIMPLE.ID_TENNISMAN
AND ID_MATCH_SIMPLE = ?1;

/*
    ?1 -> ID du match pour lequel tu veux récupérer le nom du terrain
*/
SELECT NOM_TERRAIN
FROM TERRAIN
INNER JOIN MATCHSIMPLE
WHERE TERRAIN.ID_TERRAIN = MATCHSIMPLE.ID_TERRAIN
AND ID_MATCH_SIMPLE = ?1;

/*
    Attention, il faudra convertir la phase (tour du tournoi) en 16èmes, 8èmes, …
    Idem pour les horaires, il faut les convertir en trucs compréhensibles
*/
SELECT ID_MATCH_DOUBLE, HORAIRE_DOUBLE, PHASE_TOURNOI_DOUBLE
FROM MATCHDOUBLE
WHERE PHASE_TOURNOI_DOUBLE = 5
AND ACCESSIBLE_DOUBLE = 1
AND JOUE_DOUBLE = 0;

/*
    ?1 -> ID du match pour lequel tu veux récupérer les équipes
*/
SELECT ID_EQUIPE
FROM JOUE_DOUBLE
WHERE ID_MATCH_DOUBLE = ?1;

/*
    ?1 -> ID de l'équipe pour laquelle tu veux récupérer les joueurs
*/
SELECT PRENOM_TENNISMAN, NOM_TENNISMAN
FROM TENNISMAN
WHERE ID_EQUIPE = ?1;

/*
    ?1 -> ID du match pour lequel tu veux récupérer le nom du terrain
*/
SELECT NOM_TERRAIN
FROM TERRAIN
INNER JOIN MATCHDOUBLE
WHERE TERRAIN.ID_TERRAIN = MATCHDOUBLE.ID_TERRAIN
AND ID_MATCH_DOUBLE = ?1;