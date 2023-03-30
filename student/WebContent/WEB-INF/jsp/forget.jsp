<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<title>student</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
 <style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
	font-family: 'Poppins',sans-serif;
}
body{
		font-family: serif,sans-serif,fantasy;
		width: 100vw;
		height: 100Vh;
}
.container{
	width: 500px;
	border: none;
	margin:50px auto ;
	padding: 15px;
	border-radius: 10px;
	box-shadow: 5px 0px 5px 0px black;	
}

h3{
	text-align: center;
	margin-bottom: 10px;
	font-weight: 500;
}

.input-group label{
	display: block;
	color: gray;
}
.input-group input{
	width: 100%;
	padding: 10px;
	margin:5px 0;
	border-radius: 3px;
	outline: none;
	border: 1px solid gray;
}
.btn{
	width: 100%;
	text-align: center;
}
button{
	width: 200px;
	padding: 10px;
    background-color: rgb(3, 30, 65);
    color: white;
    border-radius: 3px;
    border:none;
    outline:none;
	text-transform: capitalize;
	cursor: pointer;
}

.input-group{
	margin-bottom: 10px;
}
 .error{
	color: red;
	text-align: center;
}
 .success{
	color: green;
	text-align: center;
}
.input-group .error{
	color: red;
}
</style>

<body>
	<div class="container">
		<h3>Reset Password</h3>
	<form:form action="forget" modelAttribute="studentBo" method="post">
		
		
		<div class="input-group">
		<label>Email</label>
		<form:input path="email" placeholder="Enter your Email"/>
		<form:errors path="email" class="error"></form:errors>
		</div>
		
		<div class="input-group">
		<label>New Password</label>
		<form:input path="password" placeholder="Enter your Password"/>
		<form:errors path="password" class="error"></form:errors>
		</div>
		
		<div class="input-group">
		<label>Retype Password</label>
		<form:input path="confirmPassword" placeholder="Enter your Confirm Password"/>
		<form:errors path="confirmPassword" class="error"></form:errors>
		</div>
		
		
		<div class="btn">
		<form:button>Submit</form:button>
		</div>
	
	</form:form>
	</div>
	<span class="error">${errorMsg}</span>
	<span class="success">${successMsg}</span>
</body><br><br>
<jsp:include page="footer.jsp"></jsp:include>

</html>