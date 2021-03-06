<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/css/animatedWeather.css" />" rel="stylesheet" />

	<div class="five-day-forecast">
		<div class="unit-switch">
			<h2>Unit</h2>
			<form>
				&#176;F
				<label class="switch">
					<input type="hidden" name="unit" value="${ oppositeTemperature }" />
					<input type="checkbox"<c:if test="${ !tempInF }">checked="checked"</c:if> onchange="this.parentElement.parentElement.submit();" />
					<span class="slider round"></span>
				</label>
				&#176;C
			</form>
		</div>
		<c:forEach items="${forecasts}" var="forecast">
			<div class="forecast-day-${forecast.fiveDayForecastValue}">
				<div class="weather-image">
					<c:choose>
						<c:when test="${ forecast.forecast == 'snow' }">
							<div class="icon flurries">
 								<div class="cloud"></div>
								 <div class="cloud"></div>
								 <div class="snow">
									<div class="flake"></div>
									<div class="flake"></div>
								</div>
							</div>
						</c:when>
						<c:when test="${ forecast.forecast == 'partly cloudy' }">
							<div class="icon sun-shower">
								<div class="cloud"></div>
								<div class="cloud"></div>
								<div class="sun">
									<div class="rays"></div>
								</div>
							</div>
						</c:when>
						<c:when test="${ forecast.forecast == 'cloudy' }">
							<div class="icon cloudy">
								<div class="cloud"></div>
								<div class="cloud"></div>
							</div>
						</c:when>
						<c:when test="${ forecast.forecast == 'rain' }">
							<div class="icon rainy">
								<div class="cloud"></div>
								<div class="rain"></div>
							</div>
						</c:when>
						<c:when test="${ forecast.forecast == 'sunny' }">
							<div class="icon sunny">
								<div class="sun">
									<div class="rays"></div>
								</div>
							</div>
						</c:when>
						<c:when test="${ forecast.forecast == 'thunderstorms' }">
							<div class="icon thunder-storm">
								<div class="cloud"></div>
								<div class="lightning">
									<div class="bolt"></div>
									<div class="bolt"></div>
								</div>
							</div>
						</c:when>
					</c:choose>
					<img src="<c:url value="/img/weather/${forecast.imageName}.png" />" />
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
			</div>
			<div class="forecast-advisories-${forecast.fiveDayForecastValue}">
			<c:forEach items="${forecast.advisories}" var="advisories">
				<div class="forecast-advisory">${advisories}</div>
			</c:forEach>
			</div>
		</c:forEach>
	</div>
	