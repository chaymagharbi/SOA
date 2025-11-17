<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Étudiant</title>
</head>
<body>
  
  <form action="controller" method="GET">
    <h1>afficher tout etudiants:</h1>
    <button name="mybtn" value="get">get all</button>
  </form>

  <br>
  <h1>chercher par id:</h1>
  <form action="controller" method="GET">
    <label>ID :</label>
    <input type="number" name="id">
    <button name="getid" value="getid">get etudiant</button>
  </form>

  <br>
  <h1>ajouter etudiant:</h1>
  <form action="controller" method="POST">
    <label>ID :</label>
    <input type="number" name="id"><br>
    <label>Nom :</label>
    <input type="text" name="nom"><br>
    <label>Moyenne :</label>
    <input type="text" name="moyenne"><br>
    <button name="ajouter" value="ajouter">ajouter</button>
  </form>

  <br>
  <h1>modifier etudiant:</h1>
  <form action="controller" method="POST">
    <label>ID :</label>
    <input type="number" name="id"><br>
    <label>Nom :</label>
    <input type="text" name="nom"><br>
    <label>Moyenne :</label>
    <input type="text" name="moyenne"><br>
    <button name="modifier" value="modifier">modifier</button>
  </form>
  
  <h1>Supprimer etudiant:</h1>
  <form action="controller" method="POST">
  <label>ID :</label>
  <input type="number" name="id"><br>
  <button name="supprimer" value="supprimer">supprimer</button>
  </form>

</body>
</html>
