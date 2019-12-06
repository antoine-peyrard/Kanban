<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Tableau Kanban</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container-fluid"> Test</div>
		<h1>Tableau Kanban</h1>
		<ul>
			<c:forEach items="${pageDeTaches.content}" var="tache">
			<li>${tache.intitule} (${tache.dateCreation})</li>
			</c:forEach>
		</ul>
		<c:if test ="${!pageDeTaches.first}">
			<a href = "index?page=0">Première Page</a>
			<a href ="index?page=${pageDeTaches.number-1}">Page précédente</a>
		</c:if>
		<c:if test="${!pageDeTaches.last}">
			<a href ="index?page=${pageDeTaches.number+1}">Page suivante</a>
		</c:if>
			<a href ="index?page=${pageDeTaches.last}">Dernière page</a>
			<a class="btn btn-primary" type=button href="ajouterTache?idProjet=1">Nouvelle tache</a>
	</body>
</html>