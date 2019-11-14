<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jsp"%>

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

<%@include file="common/footer.jsp"%>