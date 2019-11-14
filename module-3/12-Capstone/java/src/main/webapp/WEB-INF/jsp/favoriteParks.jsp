<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
</c:import>

<div class="favorite-parks">
	<c:forEach items="${parks}" var="park">
		<div class="favorite-park">
			<div class="park-image">
				<img
					src="<c:url value="img/parks/${park.park.parkCode.toLowerCase()}.jpg" />" />
			</div>
			<div class="favorite-park-name">
				Name: ${park.park.parkName}
			</div>
			<div class="favorite-park-count"> 
				Number of favorites: ${park.count}
			</div>
		</div>
	</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp">
</c:import>