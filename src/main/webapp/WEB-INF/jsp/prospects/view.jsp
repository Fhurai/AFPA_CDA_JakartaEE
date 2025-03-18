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
    <title>Consultation Prospects | Gestion Clients</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<main>
    <article>
        <header><h1>Consultation</h1></header>
        <section class="container" id="content"><span class="handlewidth">Vous consultez les données actuellement disponibles pour le prospect n°1 :</span>
        </section>
        <form action="#" method="post">
            <fieldset class="row modal-dialog-centered"><input type="hidden"
                                                               value="1"
                                                               id="identifiantInput">
                <legend class="border-bottom mb-4">Partie société</legend>
                <div class="form-group col-md-6"><label
                        for="raisonSocialeInput">Raison Sociale</label><input
                        class="form-control" id="raisonSocialeInput" type="text"
                        pattern="^[A-Za-zÀ-ÿ' \-]+$"
                        placeholder="Raison Sociale" required="" size="30"
                        disabled=""></div>
                <div class="form-group col-md-6"><label for="telephoneInput">Téléphone</label><input
                        class="form-control" id="telephoneInput" type="text"
                        pattern="^(?:\+33|0033|0)[1-9](?:[ .\-]?\d{2}){4}$"
                        placeholder="Téléphone" size="12" disabled=""></div>
                <div class="form-group col-md-6"><label for="adresseMailInput">Adresse
                    Mail</label><input class="form-control"
                                       id="adresseMailInput" type="text"
                                       pattern="^[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,}$"
                                       placeholder="Adresse Mail" size="30"
                                       disabled=""></div>
                <div class="form-group col-md-12"><label
                        for="commentairesTextarea">Commentaires</label><textarea
                        class="form-control" id="commentairesTextarea"
                        placeholder="Commentaires sur le prospect" rows="5"
                        disabled=""></textarea></div>
                <legend class="border-bottom mb-4 d-flex">Partie adresse -
                    <div id="labelAdresseMeteo">Météo claire et ensoleillée
                    </div>
                    <div class="btn btn-primary" data-bs-target="#modal"
                         data-bs-toggle="modal">Voir détails
                    </div>
                </legend>
                <div id="map">
                </div>
                <div class="form-group col-md-6"><label for="numeroRueInput">Numéro
                    rue</label><input class="form-control" id="numeroRueInput"
                                      type="text"
                                      pattern="(?:\d{0,3} +(bis|ter|quat)|(?:^|\b))|(?:\b\d{0,3}[ab]*\b)"
                                      placeholder="Numero Rue" size="15"
                                      disabled="" value="28"></div>
                <div class="form-group col-md-6"><label for="nomRueInput">Nom
                    rue</label><input class="form-control" id="nomRueInput"
                                      type="text"
                                      pattern="\b([a-zA-Z0-9]+(?:[.\- ']*[a-zA-Z0-9]+)*)\b"
                                      placeholder="Nom Rue" size="30"
                                      disabled="" value="Boulevard Albert 1er"></div>
                <div class="form-group col-md-6"><label for="codePostalInput">Code
                    Postal</label><input class="form-control"
                                         id="codePostalInput" type="text"
                                         pattern="\b\d{5}\b"
                                         placeholder="Code Postal" size="5"
                                         disabled="" value="54000"></div>
                <div class="form-group col-md-6"><label
                        for="villeInput">Ville</label><input
                        class="form-control" id="villeInput" type="text"
                        pattern="\b([a-zA-Z]+(?:[.\- ']*[a-zA-Z]+)*)\b"
                        placeholder="Ville" size="30" disabled=""
                        value="Nancy"></div>
                <legend class="border-bottom mb-4">Partie prospect</legend>
                <div class="form-group col-md-6"><label
                        for="dateProspectionInput">Date
                    Prospection</label><input class="form-control"
                                              id="dateProspectionInput"
                                              type="date" pattern=""
                                              placeholder="Date Prospection"
                                              size="10" disabled=""></div>
                <div class="form-group col-md-6"><label
                        for="prospectInteresseInput">Prospect Interesse</label>
                    <div class="checkbox-custom"><input class="form-control"
                                                        id="prospectInteresseInput"
                                                        type="checkbox"
                                                        disabled=""><label
                            for="prospectInteresseInput"></label></div>
                </div>
                <hr class="mt-4">
            </fieldset>
        </form>
        <div aria-hidden="true" class="modal fade" id="modal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header"><h1 class="modal-title fs-5"
                                                  id="modalMeteo">Météo claire
                        et ensoleillée</h1>
                        <button aria-label="Close" class="btn-close"
                                data-bs-dismiss="modal" type="button"></button>
                    </div>
                    <div class="modal-body">
                        <div><h5>Température</h5>
                            <div id="resultT">11°C - Frais</div>
                        </div>
                        <div><h5>Pluie</h5>
                            <div id="resultP">0mm - Aucune</div>
                        </div>
                        <div><h5>Vent</h5>
                            <div id="resultV">13km/h - Léger</div>
                        </div>
                        <div><h5>Nébulosité</h5>
                            <div id="resultN">0% - Dégagé</div>
                        </div>
                        <div><h5>Humidité</h5>
                            <div id="resultH">43% - Sec</div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary"
                                data-bs-dismiss="modal" type="button">Close
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