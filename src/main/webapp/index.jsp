<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
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
			<div class="col-md-1">
				<a class="text-white" href="ajouterTache?idProjet=1">Nouvelle tache</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<h1>Kanban: ${projets[0].nom}</h1>
		</div>
		<div class="row">
			<ul class="list-group">
			<c:forEach items="${pageDeTaches.content}" var="tache">
			<li class="list-group-item">${tache.intitule} (${tache.colonne.contenu})</li>
			</c:forEach>
			</ul>
		</div>
		<div class="card-body">
			<table class="table table-striped table-bordered table-dark table_taches">
				<thead>
					<tr>
						<c:forEach items="${colonnes}" var="colonne">
							<th scope="col"><font color="white">${colonne.contenu}</font></th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageDeTaches.content}" var="tache">
						<tr>
							<c:if test="${tache.colonne.id eq 1}">
								<td>
									<div>${tache.intitule}</div>
								 	<form action="/modifColonne" method="post">
								 		<input type="hidden" name="id" value=${tache.id}>
										<button type="submit" class="btn btn-${tache.typeTache.couleur}">></button>
									</form>
								</td>
							</c:if>
							<c:if test="${tache.colonne.id ne 1}">
								<td></td>
							</c:if>
							<c:if test="${tache.colonne.id eq 2}">
								<td>
									<div>${tache.intitule}</div>
								 	<form action="/modifColonne" method="post">
								 		<input type="hidden" name="id" value=${tache.id}>
										<button type="submit" class="btn btn-${tache.typeTache.couleur}">></button>
									</form>
								</td>
							</c:if>
							<c:if test="${tache.colonne.id ne 2}">
								<td></td>
							</c:if>
							<c:if test="${tache.colonne.id eq 3}">
								<td>
									<div>${tache.intitule}</div>
								 	<form action="/modifColonne" method="post">
								 		<input type="hidden" name="id" value=${tache.id}>
										<button type="submit" class="btn btn-${tache.typeTache.couleur}">></button>
									</form>
								</td>
							</c:if>
							<c:if test="${tache.colonne.id ne 3}">
								<td></td>
							</c:if>
							<c:if test="${tache.colonne.id eq 4}">
								<td>
									<div>${tache.intitule}</div>
								 	<form action="/modifColonne" method="post">
								 		<input type="hidden" name="id" value=${tache.id}>
										<button type="submit" class="btn btn-${tache.typeTache.couleur}">></button>
									</form>
								</td>
							</c:if>
							<c:if test="${tache.colonne.id ne 4}">
								<td></td>
								</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>
</html>