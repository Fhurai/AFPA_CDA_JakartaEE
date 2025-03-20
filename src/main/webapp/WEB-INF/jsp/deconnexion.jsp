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
    <title>Déconnexion | Gestion Clients</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>

<main>
    <article>
        <header>
            <h1>Déconnexion</h1>
        </header>

        <section class="container" id="content">
                <span class="handlewidth">
                    Souhaitez-vous vous déconnecter de l'application ?
                </span>
        </section>

        <form action="#" method="post">
            <fieldset class="row modal-dialog-centered">
                <div class="form-group col-md-6 d-flex justify-content-center">
                    <input type="submit"
                           class="btn btn-success float-end"
                           name="answer"
                           value="Oui">
                </div>
                <div class="form-group col-md-6 d-flex justify-content-center">
                    <input type="submit"
                           class="btn btn-danger float-end"
                           name="answer"
                           value="Non">
                </div>
            </fieldset>
        </form>
    </article>
</main>

<jsp:include page="components/footer.jsp"/>
<jsp:include page="components/scripts.jsp"/>
</body>
</html>