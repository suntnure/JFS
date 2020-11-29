<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body bgcolor="Lightskyblue">
<h1>Check for Credit Card Eligibility</h1>
    <form id = "checkEligibility"  action = "<%=request.getContextPath()%>/checkEligibility/" method="POST">
         <label>Enter PAN Number</label>
 <input type="text" id="panNo" name="panNo" pattern="[A-Za-z0-9]{10}" title="10 character alphanumeric" required/> <br>    
<br> <br>    

 <input type="submit" value="Check" id="submit"/><br>
 <br><br>
 
 </form>

</body>
</html>