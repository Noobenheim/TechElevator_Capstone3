<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="five-day-forecast">
		<a href="?unit=${oppositeTemperature}">Switch to ${oppositeTemperature}</a>
		<c:forEach items="${forecasts}" var="forecast">
			<div class="forecast-day-${forecast.fiveDayForecastValue}">
				<div class="weather-image">
					<img
						src="<c:url value="/img/weather/${forecast.imageName}.png" />" />
				</div>
				<div class="forecast-high">
					<c:if test="${ tempInF }">
					${forecast.high}
					</c:if>
					<c:if test="${ !tempInF }">
					${forecast.highInCelsius}
					</c:if>
					&#176;${temperatureUnit}
				</div>
				<div class="forecast-low">
					<c:if test="${ tempInF }">
					${forecast.low}
					</c:if>
					<c:if test="${ !tempInF }">
					${forecast.lowInCelsius}
					</c:if>
					&#176;${temperatureUnit}
				</div>
					<div>
					<c:forEach items="${forecast.advisories}" var="advisories">
				<div class="forecast-advisory">${advisories}</div>
					</c:forEach>
					</div>
			</div>
		</c:forEach>
	</div>
	