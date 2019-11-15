<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/scripts/scroll.js" />"></script>
<link rel="stylesheet" href="<c:url value="/css/header.css" />" />
<c:if test="${ param.css != null }">
	<link rel="stylesheet" href="<c:url value="/css/${ param.css }.css" />" />
</c:if>
<title>National Park Geek</title>
</head>
<body>
<header>
	<div class="logo">
		<img src="<c:url value="/img/logo.png" />" id="logo" />
	</div>
	<nav>
		<ul>
			<li><a href="<c:url value="/"/>" />Home</a></li>
			<li><a href="<c:url value="/survey"/>" /> Survey</a></li>
		</ul>
	</nav>
</header>
<section>