<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
</c:import>

<div class="survey-form">
	<form:form action="survey" method="POST" modelAttribute="survey">
		<div class="survey-parks">
			<form:label path="parkCode">Favorite National Park</form:label>
			<form:select path="parkCode" items="${parks}" />
			<form:errors path="parkCode" cssClass="error" />
		</div>
		<div class="survey-email">
			<form:label path="emailAddress">Your email</form:label>
			<form:input path="emailAddress" type="email" />
			<form:errors path="emailAddress" cssClass="error" />
		</div>
		<div class="survey-state">
			<form:label path="state">State of residence</form:label>
			<form:select path="state" items="${states}" />
			<form:errors path="state" />
		</div>
		<div class="survey-activity">
			<form:label path="activityLevel">Activity Level</form:label>
			<form:radiobuttons path="activityLevel" items="${activityLevels}" />
			<form:errors path="activityLevel" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp">
</c:import>