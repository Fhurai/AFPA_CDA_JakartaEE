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
    <title>Index | Gestion Clients</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>
<main>
    <article>
        <header><h1>Bienvenue</h1></header>
        <section class="container" id="content">
            <span class="handlewidth">Vous trouverez ici les outils pour
                permettre de créer un client, un prospect et de les modifier en
                fonction de l'avancée du client.</span>
        </section>
    </article>
</main>
<jsp:include page="components/footer.jsp"/>
<jsp:include page="components/scripts.jsp"/>
</body>
</html>