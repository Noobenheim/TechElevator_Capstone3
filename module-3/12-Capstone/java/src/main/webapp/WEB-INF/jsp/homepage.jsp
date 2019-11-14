<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@include file="common/header.jsp" %>

	<div class="park-list">
		<c:forEach items="${parks}" var="park">
			<a href="details/${park.parkCode}">
			<div class="park-info">
				<div class="park-image">
					<img
						src="<c:url value="img/parks/${park.parkCode.toLowerCase()}.jpg" />" />
				</div>
				<div class="park-name">${park.parkName}</div>
				<div class="park-state">${park.state}</div>
				<div class="park-description">${park.parkDescription}</div>
			</div>
			</a>
		</c:forEach>
	</div>
	
<%@include file="common/footer.jsp" %>