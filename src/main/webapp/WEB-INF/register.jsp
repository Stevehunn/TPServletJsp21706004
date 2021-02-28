<%--
  Created by IntelliJ IDEA.
  User: steve
  Date: 27/02/2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<p>Inscription</p>
<FORM Method="POST" Action="register">

    Nom : 		<INPUT type=text size=20 name=nom><BR>

    Prénom : 	<INPUT type=text size=20 name=prenom><BR>

    Nom d'utilisateur : 		<INPUT type=text size=20 name=nomutilisateur><BR>

    Mot de passe : 		<INPUT type=password size=2 name=mdp><BR>

    Confirmation du mot de passe :  <INPUT type=password size=2 name=mdp2><BR>

    <INPUT type=submit value=Inscription>

    <BR>
    Déjà inscrit ?
    <BR>

    <a href="login">Connection</a>

</FORM>
<p></p>

</body>
</html>
