<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student</title>
</head>
 <style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
	font-family: 'Poppins',sans-serif;
}
body{
	width: 100vw;
	height: 81vh;
}
.main{
width: 100%;
	height: 100%;
	display: flex;
    justify-content: center;
    align-items: center;
}
.container{
	text-align: center;
}
.container h3{
	font-size: 40px;
	font-weight: 500;
	margin-bottom: 20px;
	text-transform: uppercase;
}
.container a{
	display: inline-block;
	text-decoration: none;
	width:100px;
	height:40px;
	line-height:40px;
	background-color: purple;
	border-radius:3px;
	margin-left:10px;
	color: white;
}
</style>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="main">
	<div class="container">
		<h3>Welcome to our web page</h3>
	<div class="btn">
		<a href="singIn">SignUp</a>
		<a href="login">Login</a>
	</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>