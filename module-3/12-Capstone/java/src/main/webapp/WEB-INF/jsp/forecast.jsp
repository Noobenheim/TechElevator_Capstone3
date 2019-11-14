<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="five-day-forecast">
		<c:forEach items="${forecasts}" var="forecast">
			<div class="forecast-day-${forecast.fiveDayForecastValue}">
				<div class="weather-image">
					<img
						src="<c:url value="img/weather/${forecast.imageName}.png" />" />
				</div>
				<div class="forecast-high">${forecast.high}</div>
				<div class="forecast-low">${forecast.low}</div>
					<div>
					<c:forEach items="${forecast.advisories}" var="advisories">
				<div class="forecast-advisory">${advisories}</div>
					</c:forEach>
					</div>
			</div>
		</c:forEach>
	</div>
	