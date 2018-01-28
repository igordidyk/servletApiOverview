<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
login page
<br>
<form action="/j_security_check" method="post">
    <input type="text" name="j_username" placeholder="input name"/>
    <input type="text" name="password" placeholder="input name"/>
    <input type="submit" value="login">
</form>
</body>
</html>
