<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Student registration form</title>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName"/>
			<br/>
			Second name: <form:input path="secondName"/>
			<br/>
			<br/>
			Country:
			<form:select path="country">
				<!-- here can be <form:option value="ru" label="russia"/> -->
				<form:options items="${student.countryOptions }"/>
			</form:select>
			<br/>
			<br/>
			Favorite language:
			<br/>
			<br/>
				<!-- here can be <form:radiobutton path="favoriteLanguage" value="someValue"/> -->
				<form:radiobuttons path="favoriteLanguage" items="${student.languageOptions }" />
			<br/>
			<br/>
			Favorite operating systems:
				linux <form:checkbox path="favoriteOperatingSystems" value="Linux" />
				mac OS <form:checkbox path="favoriteOperatingSystems" value="mac OS" />
				Windows <form:checkbox path="favoriteOperatingSystems" value="Windows" />
			<br/>
			<br/>
			<input type="submit" value="Submit"/>
		</form:form>	
	</body>
</html>