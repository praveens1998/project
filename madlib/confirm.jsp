
<html>
<body style="background-color:lightblue;font-size:25px;">
<%
String name=request.getParameter("uname");
out.print("Hello "+name);
out.print(" your order has been placed successfully");
%>
</body>
</html>