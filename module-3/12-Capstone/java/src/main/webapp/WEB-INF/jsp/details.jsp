<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="css" value="details" />
</c:import>

<div class="park-details">
<c:if test="${ park == null }">
	<h1>Park does not exist</h1>
</c:if>
<c:if test="${ park != null }">
	<div class="park-name">
		<span class="value">${park.parkName}</span>
	</div>
	<div class="park-details-header">
		<div class="park-image">
			<img src="<c:url value="/img/parks/${park.parkCode.toLowerCase()}.jpg" />" />
		</div>
		<div class="park-information">
			<div class="park-state">
				<span class="label">State: </span>
				<span class="value">${park.state}</span>
			</div>
			<div class="park-acreage">
				<span class="label">Acreage: </span>
				<span class="value"><fmt:formatNumber value="${park.acreage}" /></span>
			</div>
			<div class="park-elevation">
				<span class="label">Elevation (ft): </span>
				<span class="value">${park.elevationInFeet}</span>
			</div>
			<div class="park-miles">
				<span class="label">Trail Miles: </span>
				<span class="value">${park.milesOfTrail}</span>
			</div>
			<div class="park-campsites">
				<span class="label">Number of Campsites: </span>
				<span class="value">${park.numberOfCampsites}</span>
			</div>
			<div class="park-climate">
				<span class="label">Climate: </span>
				<span class="value">${park.climate}</span>
			</div>
			<div class="park-year">
				<span class="label">Year Founded: </span>
				<span class="value">${park.yearFounded}</span>
			</div>
			<div class="park-visitors">
				<span class="label">Annual Visitor Count: </span>
				<span class="value"><fmt:formatNumber value="${park.annualVisitorCount}" /></span>
			</div>
			<div class="park-entry">
				<span class="label">Entry Fee: </span>
				<span class="value">${park.entryFee}</span>
			</div>
			<div class="park-animals">
				<span class="label">Number of Animal Species: </span>
				<span class="value"><fmt:formatNumber value="${park.numberOfAnimalSpecies}" /></span>
			</div>
		</div>
		<div class="park-quote">
			<span class="value">${park.inspirationalQuote}</span>
			<div class="park-quote-source">
				${park.inspirationalQuoteSource}
			</div>
		</div>
	</div>
	<div class="park-description">
		<span class="value">${park.parkDescription}</span>
	</div>
</c:if>

<c:import url="/WEB-INF/jsp/forecast.jsp">
</c:import>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp">
</c:import>