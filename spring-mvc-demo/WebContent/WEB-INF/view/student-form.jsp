<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Student registration form</title>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName"/>\
			<br/>
			Second name: <form:input path="secondName"/>
			<br/>
			<input type="submit" value="Submit"/>
		</form:form>	
	</body>
</html>