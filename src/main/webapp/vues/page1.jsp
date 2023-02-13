<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Spring Data</title>
</head>
<body>
<h3>Liste des Départements</h3>
<table>
<tr><th>Id</th><th>Titre</th></tr>
  <c:forEach items="${listeDepartement}" var="dep">
<tr>
<td>${dep.id }</td>
<td>${dep.titre }</td>

</tr>
</c:forEach>
</table>
</body>
</html>