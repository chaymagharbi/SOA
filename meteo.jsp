<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>get all villes:</h2>
    <form action="controller" method="GET">
        <button name="btn1" value="getall">get all villes:</button>
    </form>
            <br>
        <br>
    <h2>get meteo ville:</h2>
    <form action="controller" method="GET">
        <label for="ville">ville</label><br>
        <input type="text" name="ville">
        <br> <br>
        <button name="btn2" value="get">consulter meteo</button>
    </form>
            <br>
        <br>
    <h2>ajouter ville :</h2>
    <form  action ="controller" method="POST">
        <label for="ville">ville</label>
        <br>
        <input type="text" name="ville" >
        <br>        <br>

        <label for="temp">mesure temperature</label>
        <br>
       <input type="number" name="temp" step="0.01">
        <br>        <br>
        <label for="date">date</label>
        <br>
        <input type="date" name="date" value="date">
        <br> <br>
        <button name="btn3" value="ajouter">ajouter meteo</button>
    </form>
    
</body>
</html>