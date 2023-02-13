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
<title>Add materiel</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
Bienvenue <sec:authentication property="name"/>
(<a href="<c:url value="/logout"/>"> Logout</a>)
</sec:authorize>
<h1>Ajouter un matériel</h1>
<form:form method="post" action="save/${mat.depts.id }" modelAttribute="mat">
<p>SERIE:<form:input path="serialNumber"/></p>
<p>Etat:<form:input path="state"/></p>
<p>title:<form:input path="title"/></p>
<p>type:<form:input path="type"/></p>
<p>Departement:<form:select  path="depts.id" items="${lp}" itemLabel="titre" itemValue="id"/></p>
<input type="submit" value="Ajouter"/>
</form:form>


</body>
</html>