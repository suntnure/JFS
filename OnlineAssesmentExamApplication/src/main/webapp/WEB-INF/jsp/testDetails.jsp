<%@page import="com.wipro.model.*"%> 
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html>
<head>
<title>All Tests Details</title>
</head>
<body>
<div><h1>List of Candidates and Tests</h1>></div>>
    <table style="width:100%">
  <tr>
    <th>Test Date</th>
    <th>Assessment</th> 
    <th>Test Marks</th>
    <th>Email ID</th>
    <th>Total Marks</th>
    <th>Result</th>
  </tr>
<%ArrayList<TestDetails> std =  
            (ArrayList<TestDetails>)request.getAttribute("data"); 
        for(TestDetails s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getTestDate()%></td> 
                <td><%=s.getAssessment()%></td> 
                <td><%=s.getTestMarks()%></td>
                <td><%=s.getEmail()%></td> 
                <td><%=s.getTotalMarks()%></td>
                <td><%=s.getResult()%></td>
            </tr> 
            <%}%> 
</table>
    
</body>
</html>