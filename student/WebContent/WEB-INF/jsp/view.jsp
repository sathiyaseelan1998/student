<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<title>student</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
	font-family: 'Poppins',sans-serif;
}

th{
background-color: navy;
color: white;
text-align: center;
border-color: black;
}
table ,th ,td{

border-collapse: collapse;
padding:7px;

}
table{

width: 100%;

}
tr{
transition:all 0.3s ease;

}

tr:nth-child(even){
	border: 1px solid gray;
	
}
tr:hover {
	color: blue;
}

.cap{

text-transform: capitalize;

}
.container{

	padding: 5px;
}
i:HOVER {
	
	color: white;
	cursor: pointer;
}
.edit,.delete{
	display:block;
	width: 100px;
	padding:7px;
	text-align:center;
	background-color: gray;
	border-radius: 3px;
	cursor: pointer;
	
}
.edit{
	background-color: #1e90ff;
}
.delete{
	background-color: #ff4757;
}
.add{
	width: 35px;
	height: 35px;
	box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
	border-radius: 50%;
	float: right;
	margin: 15px;
	display: flex;
	justify-content:center;
	align-items: center;
	color: black;
}
.add a{
	color: black;
}

</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="add"><a href="singIn"><i class="fa fa-plus" style="font-size:20px"></i>
</a></div>
<div class="container">
<table>

<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PASSWORD</th>
<th>ADDRESS</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>

<c:forEach items="${list}" var="l">
<tr>
<td>${l.id}</td>
<td>${l.name}</td>
<td>${l.email}</td>
<td>${l.password}</td>
<td>${l.address}</td>
<td><a href="edit?id=${l.id}" class="edit">Edit</a></td>
<td><a href="delete?id=${l.id}" class="delete">Delete</a></td>			
</tr>
</c:forEach>
</table>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>