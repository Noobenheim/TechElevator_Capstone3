<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>National Park Geek</title>
</head>
<body>
<img src="<c:url value="img/logo.png" />" />
	<div class="park-list">
		<c:forEach items="${parks}" var="park">
			<div class="park-info">
				<div class="park-image">
					<img
						src="<c:url value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />" />
				</div>
				<div class="park-name">${park.parkName}</div>
				<div class="park-state">${park.state}</div>
				<div class="park-description">${park.parkDescription}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>