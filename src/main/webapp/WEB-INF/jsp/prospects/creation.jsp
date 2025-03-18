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
    <title>Création Prospects | Gestion Clients</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<main>
    <article>
        <header><h1>Création</h1></header>
        <section class="container" id="content"><span class="handlewidth">Quel nouveau prospect souhaitez vous créer ?</span>
        </section>
        <form action="#" method="post">
            <fieldset class="row modal-dialog-centered"><input type="hidden"
                                                               value=""
                                                               id="identifiantInput">
                <legend class="border-bottom mb-4">Partie société</legend>
                <div class="form-group col-md-6"><label
                        for="raisonSocialeInput">Raison Sociale</label><input
                        class="form-control" id="raisonSocialeInput" type="text"
                        pattern="^[A-Za-zÀ-ÿ' \-]+$"
                        placeholder="Raison Sociale" required="" size="30">
                </div>
                <div class="form-group col-md-6"><label for="telephoneInput">Téléphone</label><input
                        class="form-control" id="telephoneInput" type="text"
                        pattern="^(?:\+33|0033|0)[1-9](?:[ .\-]?\d{2}){4}$"
                        placeholder="Téléphone" size="12"></div>
                <div class="form-group col-md-6"><label for="adresseMailInput">Adresse
                    Mail</label><input class="form-control"
                                       id="adresseMailInput" type="text"
                                       pattern="^[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,}$"
                                       placeholder="Adresse Mail" size="30">
                </div>
                <div class="form-group col-md-12"><label
                        for="commentairesTextarea">Commentaires</label><textarea
                        class="form-control" id="commentairesTextarea"
                        placeholder="Commentaires sur le prospect"
                        rows="5"></textarea></div>
                <legend class="border-bottom mb-4 d-flex">Partie adresse
                </legend>
                <div class="map" id="map"></div>
                <div class="form-group col-md-6"><label for="numeroRueInput">Numéro
                    rue</label><input class="form-control" id="numeroRueInput"
                                      type="text"
                                      pattern="(?:\d{0,3} +(bis|ter|quat)|(?:^|\b))|(?:\b\d{0,3}[ab]*\b)"
                                      placeholder="Numero Rue" size="15"></div>
                <div class="form-group col-md-6"><label for="nomRueInput">Nom
                    rue</label><input class="form-control" id="nomRueInput"
                                      type="text"
                                      pattern="\b([a-zA-Z0-9]+(?:[.\- ']*[a-zA-Z0-9]+)*)\b"
                                      placeholder="Nom Rue" size="30"></div>
                <div class="form-group col-md-6"><label for="codePostalInput">Code
                    Postal</label><input class="form-control"
                                         id="codePostalInput" type="text"
                                         pattern="\b\d{5}\b"
                                         placeholder="Code Postal" size="5">
                </div>
                <div class="form-group col-md-6"><label
                        for="villeInput">Ville</label><input
                        class="form-control" id="villeInput" type="text"
                        pattern="\b([a-zA-Z]+(?:[.\- ']*[a-zA-Z]+)*)\b"
                        placeholder="Ville" size="30"></div>
                <legend class="border-bottom mb-4">Partie prospect</legend>
                <div class="form-group col-md-6"><label
                        for="dateProspectionInput">Date
                    Prospection</label><input class="form-control"
                                              id="dateProspectionInput"
                                              type="date" pattern=""
                                              placeholder="Date Prospection"
                                              size="10"></div>
                <div class="form-group col-md-6"><label
                        for="prospectInteresseInput">Prospect Interesse</label>
                    <div class="checkbox-custom"><input class="form-control"
                                                        id="prospectInteresseInput"
                                                        type="checkbox"
                                                        value=""><label
                            for="prospectInteresseInput"></label></div>
                </div>
                <hr class="mt-4">
                <div class="form-group col-md-12">
                    <button class="btn btn-primary float-end">Sauvegarder
                    </button>
                </div>
            </fieldset>
        </form>
    </article>
</main>
<jsp:include page="../components/footer.jsp"/>
<jsp:include page="../components/scripts.jsp"/>
</body>
</html>