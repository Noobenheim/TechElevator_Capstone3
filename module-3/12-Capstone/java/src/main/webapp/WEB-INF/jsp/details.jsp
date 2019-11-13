<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="common/header.jsp" %>

<c:if test="${ park == null }">
	<h1>Park does not exist</h1>
</c:if>
<c:if test="${ park != null }">
	<h1>Park ${ park.parkName }</h1>
</c:if>


<%@include file="common/footer.jsp" %>