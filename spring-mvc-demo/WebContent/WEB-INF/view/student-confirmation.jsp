<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

	<head>
		<title>Student confirmation:</title>
	</head>
	
	<body>
		The student is confirmed: ${student.firstName} ${student.secondName} and you're from ${student.country }
		<br/>
		<br/>
		Favorite language of the student is ${student.favoriteLanguage } and favorite systems is/are:
		<br/>
		<br/>
		<ul>
				<c:forEach var="temp" items="${student.favoriteOperatingSystems }">
					<li> ${temp} </li>
				</c:forEach>
		</ul>
	</body>

</html>