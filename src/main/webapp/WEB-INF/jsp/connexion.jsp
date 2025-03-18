<%--
  Created by IntelliJ IDEA.
  User: CDA-01
  Date: 18/03/2025
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="components/meta.jsp"/>
    <title>Connexion | Gestion Clients</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>
<main>
    <article>
        <header><h1>Connexion</h1></header>
        <section class="container" id="content">
            <span class="handlewidth">Page de connexion sur Reverso.</span>
        </section>
        <form action="#" method="post">
            <fieldset class="row modal-dialog-centered">
                <div class="form-group col-md-6">
                    <label for="adresseMailInput">Adresse Mail</label>
                    <input class="form-control"
                           id="adresseMailInput" type="text"
                           pattern="^[A-Za-z0-9._%+\-]+@[A-Za-z0-9]+.[A-Za-z0-9.\-]{2,}"
                           placeholder="Adresse mail" required=""
                           size="30"></div>
                <div class="form-group col-md-6">
                    <label for="passwordInput">Mot de passe</label>
                    <input class="form-control"
                           id="passwordInput" type="password"
                           pattern="" placeholder="Mot de passe"
                           required="" size="30"></div>
                <hr>
                <div class="form-group col-md-12">
                    <button class="btn btn-primary float-end">Envoyer</button>
                </div>
            </fieldset>
        </form>
    </article>
</main>
<jsp:include page="components/footer.jsp"/>
<jsp:include page="components/scripts.jsp"/>
</body>
</html>