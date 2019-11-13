<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="common/header.jsp" %>

<c:if test="${ park == null }">
	<h1>Park does not exist</h1>
</c:if>
<c:if test="${ park != null }">
	<div class="park-name">
		${park.parkName}
	</div>
	<div class="park-state">
		<span>State: </span>
		${park.state}
	</div>
	<div class="park-acreage">
		<span>Acreage: </span>
		${park.acreage}
	</div>
	<div class="park-elevation">
		<span>Elevation (ft): </span>
		${park.elevationInFeet}
	</div>
	<div class="park-miles">
		<span>Trail Miles: </span>
		${park.milesOfTrail}
	</div>
	<div class="park-campsites">
		<span>Number of Campsites: </span>
		${park.numberOfCampsites}
	</div>
	<div class="park-climate">
		<span>Climate: </span>
		${park.climate}
	</div>
	<div class="park-year">
		<span>Year Founded: </span>
		${park.yearFounded}
	</div>
	<div class="park-visitors">
		<span>Annual Visitor Count: </span>
		${park.annualVisitorCount}
	</div>
	<div class="park-quote">
		${park.inspirationalQuote}	
		<div class="park-quote-source">
			${park.inspirationalQuoteSource}
		</div>
	</div>
	<div class="park-description">
		${park.parkDescription}
	</div>
	<div class="park-entry">
		<span>Entry Fee: </span>
		${park.entryFee}
	</div>
	<div class="park-animals">
		<span>Number of Animal Species: </span>
		${park.numberOfAnimalSpecies}
	</div>
</c:if>


<%@include file="common/footer.jsp" %>