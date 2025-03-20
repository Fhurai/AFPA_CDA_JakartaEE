<%--@elvariable id="client" type="fr.afpa.pompey.cda17.models.Client"--%>
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
<c:import url="../components/meta.jsp" />
<body>
<c:import url="../components/header.jsp" />
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
                            <c:if
                                    test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.raisonSociale}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.telephone}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.mail}"
                    >
                </div>
                <div class="form-group col-md-12">
                    <label for="commentairesTextarea">Commentaires</label>
                    <textarea
                            class="form-control"
                            id="commentairesTextarea"
                            placeholder="Commentaires sur le client"
                            rows="5"
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                    >${client.commentaires}</textarea>
                </div>
                <legend class="border-bottom mb-4 d-flex">
                    Partie adresse
                    <c:if test="${titlePage == 'Consultation'}"> -
                        <div id="labelAdresseMeteo">Météo changeante</div>
                        <div
                                class="btn btn-primary"
                                data-bs-target="#modal"
                                data-bs-toggle="modal"
                        >
                            Voir détails
                        </div>
                    </c:if>
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.adresse.numeroRue}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.adresse.nomRue}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.adresse.codePostal}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.adresse.ville}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.chiffreAffaires}"
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
                            <c:if test="${['Consultation', 'Suppression'].contains(titlePage)}">
                                disabled
                            </c:if>
                            value="${client.nbEmployes}"
                    >
                </div>
                <hr class="mt-4">

                <c:if test="${titlePage != 'Consultation'}">
                <div class="form-group col-md-12">
                    <button
                        class="btn btn-primary float-end">
                        <c:out value="${(titlePage == \"Suppression\" ?
                        \"Supprimer\" : \"Sauvegarder\")}"
                    /></button>
                </div>
                </c:if>
            </fieldset>
        </form>
        <c:if test="${titlePage == 'Consultation'}">
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
                            <div id="resultT"></div>
                        </div>
                        <div>
                            <h5>Pluie</h5>
                            <div id="resultP"></div>
                        </div>
                        <div>
                            <h5>Vent</h5>
                            <div id="resultV"></div>
                        </div>
                        <div>
                            <h5>Nébulosité</h5>
                            <div id="resultN"></div>
                        </div>
                        <div>
                            <h5>Humidité</h5>
                            <div id="resultH"></div>
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
        </c:if>
    </article>
</main>
<c:import url="../components/footer.jsp" />
<c:import url="../components/scripts.jsp" />
</body>
</html>