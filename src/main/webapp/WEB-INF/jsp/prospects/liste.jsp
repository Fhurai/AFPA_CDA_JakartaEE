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
    <title>Liste Prospects | Gestion Clients</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<main>
    <article>
        <header>
            <h1>Bienvenue</h1>
        </header>
        <section class="container" id="content">
            <span class="handlewidth">sur la partie prospects</span>
            <a class="btn btn-primary float-end d-flex"
               href="?cmd=prospects/add">
                <div class="material-symbols-outlined danger">Add</div>
                <div class="handlewidth">Ajout d'un</div>&nbsp;prospect</a>
        </section>
        <div class="hovertable">
            <div class="hovertable-head">
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">#</div>
                    <div class="hovertable-cell ">Raison sociale</div>
                    <div class="hovertable-cell longer">Adresse postale</div>
                    <div class="hovertable-cell ">Téléphone</div>
                    <div class="hovertable-cell long">Adresse Mail</div>
                    <div class="hovertable-cell handlewidth">Date prospection
                    </div>
                    <div class="hovertable-cell handlewidth">Prospect
                        intéressé
                    </div>
                    <div class="hovertable-cell small">Actions</div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">
                        <input type="number" placeholder="..." step="1"
                               min="1">
                    </div>
                    <div class="hovertable-cell ">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell longer">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell ">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell long">
                        <input type="text" placeholder="...">
                    </div>
                    <div class="hovertable-cell handlewidth">
                        <input type="text" placeholder="jj/mm/aaaa">
                    </div>
                    <div class="hovertable-cell handlewidth">
                        <select>
                            <option default=""></option>
                            <option>Oui</option>
                            <option>Non</option>
                        </select>
                    </div>
                    <div class="hovertable-cell small"></div>
                </div>
            </div>
            <div class="hovertable-body">
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">1</div>
                    <div class="hovertable-cell ">Skeb</div>
                    <div class="hovertable-cell longer">28 Boulevard Albert 1er
                        54000 Nancy
                    </div>
                    <div class="hovertable-cell ">0388553370</div>
                    <div class="hovertable-cell long">contact@skeb.com</div>
                    <div class="hovertable-cell handlewidth">2025-10-09</div>
                    <div class="hovertable-cell handlewidth">false</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=prospects/view" title="Consulter">
                            <span class="material-symbols-outlined">
                                visibility</span>
                        </a>
                        <a href="?cmd=prospects/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">
                                edit
                            </span>
                        </a>
                        <a href="?cmd=prospects/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">
                                delete
                            </span>
                        </a>
                    </div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">2</div>
                    <div class="hovertable-cell ">Vgen</div>
                    <div class="hovertable-cell longer">80 ter Quai Voltaire
                        95870 Bezons
                    </div>
                    <div class="hovertable-cell ">0173260000</div>
                    <div class="hovertable-cell long">contact@vgen.com</div>
                    <div class="hovertable-cell handlewidth">2024-05-28</div>
                    <div class="hovertable-cell handlewidth">false</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=prospects/view" title="Consulter">
                            <span class="material-symbols-outlined">
                                visibility</span>
                        </a>
                        <a href="?cmd=prospects/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">
                                edit
                            </span>
                        </a>
                        <a href="?cmd=prospects/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">
                                delete
                            </span>
                        </a>
                    </div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">3</div>
                    <div class="hovertable-cell ">Gank</div>
                    <div class="hovertable-cell longer">276b Avenue du président
                        Wilson 93210 St-Denis
                    </div>
                    <div class="hovertable-cell ">0387172390</div>
                    <div class="hovertable-cell long">contact@gank.com</div>
                    <div class="hovertable-cell handlewidth">2024-10-10</div>
                    <div class="hovertable-cell handlewidth">true</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=prospects/view" title="Consulter">
                            <span class="material-symbols-outlined">
                                visibility</span>
                        </a>
                        <a href="?cmd=prospects/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">
                                edit
                            </span>
                        </a>
                        <a href="?cmd=prospects/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">
                                delete
                            </span>
                        </a>
                    </div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">4</div>
                    <div class="hovertable-cell ">Artistsnclients</div>
                    <div class="hovertable-cell longer">25 Rue Serpenoise 57000
                        Metz
                    </div>
                    <div class="hovertable-cell ">0354626299</div>
                    <div class="hovertable-cell long">
                        contact@artistsnclients.com
                    </div>
                    <div class="hovertable-cell handlewidth">2023-10-15</div>
                    <div class="hovertable-cell handlewidth">true</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=prospects/view" title="Consulter">
                            <span class="material-symbols-outlined">
                                visibility</span>
                        </a>
                        <a href="?cmd=prospects/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">
                                edit
                            </span>
                        </a>
                        <a href="?cmd=prospects/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">
                                delete
                            </span>
                        </a>
                    </div>
                </div>
                <div class="hovertable-row">
                    <div class="hovertable-cell smaller">5</div>
                    <div class="hovertable-cell ">Discord</div>
                    <div class="hovertable-cell longer">46 Rue des Rats 54000
                        Nancy
                    </div>
                    <div class="hovertable-cell ">0394135679</div>
                    <div class="hovertable-cell long">contact@discord.gg</div>
                    <div class="hovertable-cell handlewidth">2024-10-12</div>
                    <div class="hovertable-cell handlewidth">false</div>
                    <div class="hovertable-cell small">
                        <a href="?cmd=prospects/view" title="Consulter">
                            <span class="material-symbols-outlined">
                                visibility</span>
                        </a>
                        <a href="?cmd=prospects/update" title="Mettre à jour">
                            <span class="material-symbols-outlined warning">
                                edit
                            </span>
                        </a>
                        <a href="?cmd=prospects/delete" title="Supprimer">
                            <span class="material-symbols-outlined danger">
                                delete
                            </span>
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