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
    <jsp:include page="../components/meta.jsp"/>
    <title>Liste Clients | Gestion Clients</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<main>
    <article>
        <header><h1>Bienvenue</h1></header>
        <section class="container" id="content">
            <span class="handlewidth">sur la partie clients</span>
            <a class="btn btn-primary float-end d-flex"
               href="?cmd=clients/add">
                <div class="material-symbols-outlined danger">Add</div>
                <div class="handlewidth">Ajout d'un</div>&nbsp;client
            </a>
        </section>
        <div class="hovertable">
            <div class="hovertable-head">
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">#</div>
                    <div class="hovertable-cell">Raison sociale</div>
                    <div class="hovertable-cell longer">Adresse postale</div>
                    <div class="hovertable-cell">Téléphone</div>
                    <div class="hovertable-cell long">Adresse Mail</div>
                    <div class="hovertable-cell handlewidth">
                        Chiffre d'affaires
                    </div>
                    <div class="hovertable-cell handlewidth">Nb Employés</div>
                    <div class="hovertable-cell small">Actions</div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">
                        <input type="number"
                               placeholder="..."
                               step="1"
                               min="1">
                    </div>
                    <div class="hovertable-cell">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell longer">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell long">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell handlewidth">
                        <input type="number"
                               placeholder="..."
                               step="0.01"
                               min="250">
                    </div>
                    <div class="hovertable-cell handlewidth">
                        <input type="number"
                               placeholder="..."
                               step="1"
                               min="1">
                    </div>
                    <div class="hovertable-cell small"></div>
                </div>
            </div>
            <div class="hovertable-body">
                <!-- Client Rows (repeated structure) -->
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">1</div>
                    <div class="hovertable-cell">Falcom</div>
                    <div class="hovertable-cell longer">
                        2 bis rue Ardant du Picq 57004 Metz
                    </div>
                    <div class="hovertable-cell">0387543400</div>
                    <div class="hovertable-cell long">contact@falcom.com</div>
                    <div class="hovertable-cell handlewidth">999999.99</div>
                    <div class="hovertable-cell handlewidth">80</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=clients/view" title="Consulter">
                            <span class="material-symbols-outlined">visibility</span>
                        </a>
                        <a href="?cmd=clients/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">edit</span>
                        </a>
                        <a href="?cmd=clients/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">delete</span>
                        </a>
                    </div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">2</div>
                    <div class="hovertable-cell">Capcom</div>
                    <div class="hovertable-cell longer">
                        25 rue de la Taye 57130 Jussy
                    </div>
                    <div class="hovertable-cell">0387758575</div>
                    <div class="hovertable-cell long">contact@capcom.com</div>
                    <div class="hovertable-cell handlewidth">4813</div>
                    <div class="hovertable-cell handlewidth">6</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=clients/view" title="Consulter">
                            <span class="material-symbols-outlined">visibility</span>
                        </a>
                        <a href="?cmd=clients/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">edit</span>
                        </a>
                        <a href="?cmd=clients/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">delete</span>
                        </a>
                    </div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">3</div>
                    <div class="hovertable-cell">Monolith Software</div>
                    <div class="hovertable-cell longer">
                        3 rue des Michottes 54000 Nancy
                    </div>
                    <div class="hovertable-cell">0383375640</div>
                    <div class="hovertable-cell long">contact@monolith-soft.com</div>
                    <div class="hovertable-cell handlewidth">50000</div>
                    <div class="hovertable-cell handlewidth">1</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=clients/view" title="Consulter">
                            <span class="material-symbols-outlined">visibility</span>
                        </a>
                        <a href="?cmd=clients/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">edit</span>
                        </a>
                        <a href="?cmd=clients/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">delete</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </article>
</main>
<jsp:include page="../components/footer.jsp"/>
<jsp:include page="../components/scripts.jsp"/>
</body>
</html>