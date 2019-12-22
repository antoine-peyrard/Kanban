<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>liste des developpeurs</title>
	<link href="style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="style/bootstrap//js/bootstrap.min.js"></script>
</head>
	<div class="container-fluid bg-primary">
		<div class ="row">
			<div class="col-md-1">
				<a class="text-white" href="/index">Home</a>
			</div>
			<div class="col-md-1">
				<a class="text-white" href="/developpeurs">Developpeurs</a>
			</div>	
			<div class="col-md-1">
				<a class="text-white" href="ajouterTache?idProjet=1">Nouvelle tache</a>
			</div>
		</div>
	</div>
<body>
    <div  class="container" id="accordeon">
      <div class="card">
        <div class="card-body">
          <h4 class="card-title">Liste des développeurs</h4>
        </div>
        <c:forEach items="${developpeurs}" var="d">
        	<div class="card-header">
          		<a href="#collapse${d.id }" class="card-link" data-toggle="collapse" data-parent="#accordeon">${d.prenom} ${d.nom}</a>
        	</div>
        	<div class="collapse" id="collapse${d.id }">
          		<div class="card-body">
          			<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Tache</th>
					      <th scope="col">Etat</th>
					      <th scope="col">Début</th>
					    </tr>
					  </thead>
					  <tbody>
						  <c:forEach items="${d.taches}" var="tache">
						    <tr>
						      <th scope="row">${tache.id}</th>
						      <td>${tache.intitule}</td>
						      <td>${tache.colonne.contenu}</td>
						      <td>${tache.dateCreation}</td>
						    </tr>
					    </c:forEach>
					  </tbody>
					</table>
            		<p>Email : ${d.email}</p>
            		<p> Date d'arrivée: ${d.dateDebutContrat}</p>
          		</div>
        	</div>
       	</c:forEach>
    </div>
</body>
</html>