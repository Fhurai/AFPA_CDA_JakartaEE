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
    <title>Consultation Clients | Gestion Clients</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<main>
    <article>
        <header>
            <h1><c:out value="${ titlePage }" /></h1>
        </header>
        <section class="container" id="content">
                <span class="handlewidth">
                    Vous consultez les données actuellement disponibles pour le client n°1 :
                </span>
        </section>
        <form action="#" method="post">
            <fieldset class="row modal-dialog-centered">
                <input type="hidden" value="1" id="identifiantInput">
                <legend class="border-bottom mb-4">Partie société</legend>
                <div class="form-group col-md-6">
                    <label for="raisonSocialeInput">Raison Sociale</label>
                    <input
                            class="form-control"
                            id="raisonSocialeInput"
                            type="text"
                            pattern="^[A-Za-zÀ-ÿ' \-]+$"
                            placeholder="Raison Sociale"
                            required
                            size="30"
                            disabled
                            value="Falcom"
                    >
                </div>
                <div class="form-group col-md-6">
                    <label for="telephoneInput">Téléphone</label>
                    <input
                            class="form-control"
                            id="telephoneInput"
                            type="text"
                            pattern="^(?:\+33|0033|0)[1-9](?:[ .\-]?\d{2}){4}$"
                            placeholder="Téléphone"
                            size="12"
                            disabled
                            value="0387543400"
                    >
                </div>
                <div class="form-group col-md-6">
                    <label for="adresseMailInput">Adresse Mail</label>
                    <input
                            class="form-control"
                            id="adresseMailInput"
                            type="text"
                            pattern="^[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,}$"
                            placeholder="Adresse Mail"
                            size="30"
                            disabled
                            value="contact@falcom.com"
                    >
                </div>
                <div class="form-group col-md-12">
                    <label for="commentairesTextarea">Commentaires</label>
                    <textarea
                            class="form-control"
                            id="commentairesTextarea"
                            placeholder="Commentaires sur le client"
                            rows="5"
                            disabled
                    >La drogue avec Trails</textarea>
                </div>
                <legend class="border-bottom mb-4 d-flex">
                    Partie adresse -
                    <div id="labelAdresseMeteo">Météo changeante</div>
                    <div
                            class="btn btn-primary"
                            data-bs-target="#modal"
                            data-bs-toggle="modal"
                    >
                        Voir détails
                    </div>
                </legend>
                <div id="map"></div>
                <div class="form-group col-md-6">
                    <label for="numeroRueInput">Numéro rue</label>
                    <input
                            class="form-control"
                            id="numeroRueInput"
                            type="text"
                            pattern="(?:\d{0,3} +(bis|ter|quat)|(?:^|\b))|(?:\b\d{0,3}[ab]*\b)"
                            placeholder="Numero Rue"
                            size="15"
                            disabled
                            value="2 bis"
                    >
                </div>
                <div class="form-group col-md-6">
                    <label for="nomRueInput">Nom rue</label>
                    <input
                            class="form-control"
                            id="nomRueInput"
                            type="text"
                            pattern="\b([a-zA-Z0-9]+(?:[.\- ']*[a-zA-Z0-9]+)*)\b"
                            placeholder="Nom Rue"
                            size="30"
                            disabled
                            value="rue Ardant du Picq"
                    >
                </div>
                <div class="form-group col-md-6">
                    <label for="codePostalInput">Code Postal</label>
                    <input
                            class="form-control"
                            id="codePostalInput"
                            type="text"
                            pattern="\b\d{5}\b"
                            placeholder="Code Postal"
                            size="5"
                            disabled
                            value="57004"
                    >
                </div>
                <div class="form-group col-md-6">
                    <label for="villeInput">Ville</label>
                    <input
                            class="form-control"
                            id="villeInput"
                            type="text"
                            pattern="\b([a-zA-Z]+(?:[.\- ']*[a-zA-Z]+)*)\b"
                            placeholder="Ville"
                            size="30"
                            disabled
                            value="Metz"
                    >
                </div>
                <legend class="border-bottom mb-4">Partie client</legend>
                <div class="form-group col-md-6">
                    <label for="chiffreAffairesInput">Chiffre Affaires</label>
                    <input
                            class="form-control"
                            id="chiffreAffairesInput"
                            type="number"
                            placeholder="Chiffre Affaires"
                            size="15"
                            disabled
                            value="999999.99"
                    >
                </div>
                <div class="form-group col-md-6">
                    <label for="nbEmployesInput">Nb Employes</label>
                    <input
                            class="form-control"
                            id="nbEmployesInput"
                            type="number"
                            placeholder="Nb Employes"
                            size="5"
                            disabled
                            value="80"
                    >
                </div>
                <hr class="mt-4">
            </fieldset>
        </form>
        <div
                aria-hidden="true"
                class="modal fade"
                id="modal"
                tabindex="-1"
        >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="modalMeteo">
                            Météo changeante
                        </h1>
                        <button
                                aria-label="Close"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                type="button"
                        ></button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <h5>Température</h5>
                            <div id="resultT">9°C - Froid</div>
                        </div>
                        <div>
                            <h5>Pluie</h5>
                            <div id="resultP">0mm - Aucune</div>
                        </div>
                        <div>
                            <h5>Vent</h5>
                            <div id="resultV">21km/h - Modéré</div>
                        </div>
                        <div>
                            <h5>Nébulosité</h5>
                            <div id="resultN">0% - Dégagé</div>
                        </div>
                        <div>
                            <h5>Humidité</h5>
                            <div id="resultH">49% - Sec</div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button
                                class="btn btn-secondary"
                                data-bs-dismiss="modal"
                                type="button"
                        >
                            Close
                        </button>
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