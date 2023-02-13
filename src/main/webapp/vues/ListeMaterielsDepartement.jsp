<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Materiels</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
Bienvenue <sec:authentication property="name"/>
(<a href="<c:url value="/logout"/>"> Logout</a>)
</sec:authorize>
<h3>Liste des matériels</h3>
<h3>Département choisi:"${dept.titre}"</h3>
<sec:authorize access="hasAnyRole('AGENT','ADMIN')"> 
<p><a href="/TP2SPRINGDATA/ajout">Ajouter un matériel</a></p>
</sec:authorize>
<table border="1">
<tr><td>ID</td><td>Série</td><td>Etat</td><td>Titre</td><td>Type</td></tr>
<c:forEach items="${liste}" var="m">

<tr>
<td>${m.id}</td>
<td>${m.serialNumber}</td>
<td>${m.state}</td>
<td>${m.title}</td>
<td>${m.type}</td>

<sec:authorize access="hasRole('ADMIN')" >
<td><a href="/TP2SPRINGDATA/delete/${m.id}">Supprimer</a>
</sec:authorize>


</td>
</tr>
</c:forEach>
</table>

</body>
</html>