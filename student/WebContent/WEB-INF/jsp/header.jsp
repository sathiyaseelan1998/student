<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


</head>
<script type="text/javascript">
	var myVar = setInterval(function() {
		myTimer()
	}, 1000);
	var counter = 0;
	function myTimer() {
		var date = new Date();
		document.getElementById("Date").innerHTML = date.toDateString();
		document.getElementById("time").innerHTML = date.toLocaleTimeString();
	}
</script>
 <style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
	font-family: 'Poppins',sans-serif;
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
}
.header{
	background-color: rgb(3, 30, 65);
	height: 70px;
	display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 15px;
}
a{
	text-decoration: none;
	color: white;
}
.input-group input{
	width: 100%;
	padding: 10px;
	margin:5px 0;
	border-radius: 3px;
	outline: none;
	border: 1px solid gray;
}
.logout{

	width: 70px;
	height:30px;
	color: white;
    background-color: rgb(255, 219, 13);
	border-radius: 3px;
	margin-bottom: 10px;
	text-align: center;
	margin-right: 5px;
}
.logout a{
	width: 100%;
	height: 100%;
	display: block;
	color: black;
}

.head{
	line-height: 70px;
	display: flex;
	justify-content:center;
	align-items:center;
}
.head i{

	width: 50px;
	height: 50px;
	background-color: white;
	color: red;
	border-radius:50%; 
	font-size: 30px;
	line-height: 50px;
	text-align: center;
	margin-right: 7px;
	
}
</style>
<body>

<div class="header">

<div class="head">
<i class='fas fa-school'></i>
<a href="#" >School Management</a></div>

<div>
	<span id="Date" style="color: #fff;"></span>-
	<span id="time" style="color: #fff;">
	</span>
</div>

<c:if test="${role.equals('admin') && view.equals('view')}">
<div>
<form:form action="search" modelAttribute="studentBo" method="post">
		<div class="input-group">
		<form:input path="name" placeholder="Search"/>
		</div>
	</form:form>

</div>
</c:if>

<c:if test="${role.equals('admin') or role.equals('student')}">

<div class="logout">
<a href="logout">Logout
</a>
</div>
</c:if>
</div>

</body>
</html>