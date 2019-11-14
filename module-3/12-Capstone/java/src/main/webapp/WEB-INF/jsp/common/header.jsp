<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/header.css" />" />
<c:if test="${ param.css != null }">
	<link rel="stylesheet" href="<c:url value="/css/${ param.css }.css" />" />
</c:if>
<title>National Park Geek</title>
</head>
<body>
<div class="logo">
<img src="<c:url value="/img/logo.png" />" />
</div>
<nav>
<ul>
  <li><a href="<c:url value="/"/>" />Home</a></li>
  <li><a href="<c:url value="/survey"/>" /> Survey</a></li>
</ul>
</nav>
