

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>



<h1>Employee Registration</h1>

<form action="helloServelet" method="post" >

    Enter your name: <input type="text" name="atr1" size="20" id="atr1">
    Enter your contact: <input type="text" name="atr2" size="20" id="atr2">
    Enter your address: <input type="text" name="atr3" size="20" id="atr3">
    <input hidden type="text" name="atr4" size="20" id="atr4" >
    
    <input type="submit" value="register"  name = "add" id = "addbutton"/>
    <input type="button" value="register"  name = "addd" id = "temp" onclick="changeState()"/>
    
</form>

<br>

<form action="helloServelet" method="get">
<input type="submit" value="view result"></input>
</form>

<br>



<%@page import="java.util.List"%>      <%--Importing all the dependent classes--%>
<%@page import="models.Employee"%>
<%@page import="java.util.Iterator"%> 
 
<% List<Employee> employeeList = (List) request.getAttribute("list"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>
 
<strong><a href="<%=request.getContextPath()%>/IteratorExample?type=getDetails">Show Employee Details</a></strong>
<br></br>
 
<table cellspacing="2" cellpadding="2">
 
<tr><th>Employee ID</th><th>Employee Name</th><th>Employee Contact</th><th>Employee Address</th></tr>
<%
// Iterating through subjectList
 
if(request.getAttribute("list") != null)  // Null check for the object
{
 Iterator<Employee> iterator = employeeList.iterator();  // Iterator interface
 
 while(iterator.hasNext())  // iterate through all the data until the last record
 {
 Employee empDetails = iterator.next(); //assign individual employee record to the employee class object
 %>
 
 <tr>
 <td><%=empDetails.getId()%></td>
 <td><%=empDetails.getName()%></td>
 <td><%=empDetails.getContact()%></td>
 <td><%=empDetails.getAddress()%></td>
 
 
 <td>
	
	<form name="frm" method="post" action="helloServelet">
		<input type="hidden" name="hdnbt" value = "<%=empDetails.getId()%>" />
		<button name="remove" value="remove" onclick="{document.frm.hdnbt.value=this.value;document.frm.submit();}">remove</button>
	</form>
 
 </td>
 

  <td>
		<button onclick="edit('<%=empDetails.getId()%>','<%=empDetails.getName()%>','<%=empDetails.getContact()%>','<%=empDetails.getAddress()%>');">edit</button> 
 </td>
 
 

 
 </tr>
 <%
 }
}
%>
</table>




<script>

document.getElementById("temp").style.visibility = "hidden";

function edit(id,name,contact,address){

	window.alert("clicked");
	console.log(id +"--"+name+"--"+contact);

	
	document.getElementById("atr1").value = name;
	document.getElementById("atr2").value = contact;
	document.getElementById("atr3").value = address;
	document.getElementById("atr4").value = id;

	document.getElementById("addbutton").setAttribute("name", "update");
	document.getElementById("addbutton").value = "update";
	document.getElementById("temp").style.visibility = "visible";

}

function changeState(){

	document.getElementById("temp").style.visibility = "hidden";
	document.getElementById("addbutton").setAttribute("name", "add");
	document.getElementById("addbutton").value = "register";

	
}

</script>








</body>
</html>