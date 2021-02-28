<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Bienvenue sur notre Site" %>
</h1>
<p> <%= "Veuillez vous enregistrez ou vous connectez si vous possédez déjà un compte" %></p>
<br/>
<a href="register">Inscription</a>
<br/>
<a href="login">Connection</a>
<br/>
<a href="listuser">Liste des utilisateurs</a>
<br/>
<a href="deleteAccount">Supprimer son compte</a>
<a href="page1.jsp">page1</a>
</body>
</html>