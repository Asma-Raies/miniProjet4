<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modifier un Produit</title>
</head>
<body>
<div class="container mt-5">
<div class="card-body">
<form action="updateMakeUp" method="post">


<div class="form-group">
 <label class="control-label">Refrence makeUp</label> <input type="text" name="refMakeUp" value="${produit.refMakeUp}" readonly class="form-control"/>
</div>
<div class="form-group">
 <label class="control-label">nom MakeUp </label><input type="text" name="nomMakeUp" value="${produit.nomMakeUp}" class="form-control"/></div>
<div class="form-group">
 <label class="control-label">prix makeUp </label><input type="text" name="prixMakeUp" value="${produit.prixMakeUp}" class="form-control"/></div>
<div class="form-group">
 <label class="control-label">quantite </label><input type="text" name="quantite" value="${produit.quantite}" class="form-control"/></div>
<div class="form-group">
 <label class="control-label">date de creation </label>
 <fmt:formatDate pattern="yyyy-MM-dd" value="${produit.dateCreation}"
var="formatDate" />
 <input type="date" name="date" value="${formatDate}" class="form-control"/></div>
<div><input type="submit" class="btn btn-primary" value="Modifier"></div>

</form></div>
<br/>
<br/>
<a href="ListeMakeUp">Liste MakeUp</a></div>
</body>
</html>