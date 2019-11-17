<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="css" value="favoriteparks" />
</c:import>

<div class="favorite-parks">
	<div class="park-image"></div>
	<div class="title favorite-park-name">Park Name</div>
	<div class="title favorite-park-count">Favorites:</div>
	<c:forEach items="${parks}" var="park">
		<div class="park-image">
			<img
				src="<c:url value="img/parks/${park.park.parkCode.toLowerCase()}.jpg" />" />
		</div>
		<div class="favorite-park-name">
			${park.park.parkName}
		</div>
		<div class="favorite-park-count"> 
			${park.count} votes
		</div>
	</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp">
</c:import>