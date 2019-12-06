<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOUVELLE TACHE</title>
	<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid bg-primary">
		<div class ="row">
			<div class="col-md-1">
				<a class="text-white" href="/index">Home</a>
			</div>
			<div class="col-md-1">
				<a class="text-white" href="/index">Developpeurs</a>
			</div>	
		</div>
	</div>

<form action="ajouterTache" method="post">
<table>
<div>
	<tr>
        <td><label for="Intitule">Projet:</label></td>
    	<input type="hidden" name="idProjet" value=${projet.id}>
    	<td><label>${projet.nom}</label></td>
    </tr>
    <tr>
        <td><label for="Intitule">Intitulé:</label></td>
    	<td><textarea name="intitule" required></textarea></td>
    </tr>
    <tr>
        <td><label for="Colonne">Colonne:</label></td>
    	<td><select name="colonne">
        <c:forEach items="${colonnes}" var="c">
    		<option value="${c.id}">${c.contenu}</option>
    	</c:forEach>
		</select></td>
    </tr>
    <tr>
        <td><label for="typeTaches">Type de tache:</label></td>
        <td><select name="typeTache">
        <c:forEach items="${typeTaches}" var="t">
    		<option value="${t.id}">${t.nom}</option>
    	</c:forEach>
		</select></td>
	</tr>
    <tr>
        <td><label for="developpeurs">listes des developpeurs:</label></td>
        <td><select multiple name="developpeur" required>
	        <c:forEach items="${developpeurs}" var="d">
	        	<hidden name="developpeur_id">${d.id }</hidden>
	        	<option>${d.prenom} ${d.nom}
	    	</c:forEach>
	    	</select>
    	</td>
	</tr>
	<tr>
		<td><label for="Heures estimées">Heures estimées</label></td>
		<td><input type="number" required name="heuresEstimees"></td>
	</tr>
	</div>
</table>
	<div class="formulaireTache">
    <input type="submit" value ="Ajouter">
  </div>
</form>
</body>
</html>