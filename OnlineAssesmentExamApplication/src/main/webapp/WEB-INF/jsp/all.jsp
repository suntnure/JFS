<%@page import="com.wipro.model.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html>
<head>
<title>First Web Application</title>
</head>
<body>
    <table style="width:100%">
  <tr>
    <th>First Name</th>
    <th>Last Name</th> 
    <th>Email ID</th>
    <th>User Type</th>
  </tr>
<%
	ArrayList<Users> std =  
            (ArrayList<Users>)request.getAttribute("data"); 
        for(Users s:std){
%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <span Id=”firstName1” > <td><%=s.getName()%></td> </span>
                <td><%=s.getLastName()%></td> 
                <td><%=s.getEmail()%></td> 
                 <td><%=s.getUserType()%></td>
            </tr> 
            <%}%> 
</table>
    
</body>
</html>