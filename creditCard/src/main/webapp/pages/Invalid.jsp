<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
</head>
<body>
<div id="msg">
${Msg}<br>
<a href="<%=request.getContextPath()%>/checkEligibility" id="index">Enter again</a>
</div>
</body>
</html>