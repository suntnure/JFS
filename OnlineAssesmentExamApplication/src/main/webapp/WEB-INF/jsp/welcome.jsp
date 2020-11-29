<html>
<head>
<title>${title}</title>
</head>
<body>

<% if(request.getAttribute("userType").equals("Admin")){ %>
<h2 id = "msg">Select Reports</h2>
    <a href="/OnlineAssessment/users/all">View list of all candidates</a><br><br>
    <a href="/OnlineAssessment/tests/all">View list of all tests taken</a><br><br>
    <a href="/OnlineAssessment/index.html">Logout</a>
<% }else{ %>
 <div id = "msg">Select the test</div>
    <a href="/OnlineAssessment/springAssessment.html">Spring Assessment</a><br><br>
    <a href="/OnlineAssessment/hibernateAssessment.html">Hibernate Assessment</a><br><br>
    <a href="/OnlineAssessment/index.html">Logout</a>
<%}
%>
    
</body>
</html>