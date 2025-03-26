package fr.afpa.pompey.cda17.builders;

import fr.afpa.pompey.cda17.models.Adresse;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.models.Contrat;
import fr.afpa.pompey.cda17.models.SocieteEntityException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Classe constructrice Client.
 */
public class ClientBuilder extends SocieteBuilder<Client> {

    /**
     * Constructor.
     */
    public ClientBuilder() {
        super(new Client());
    }

    /**
     * New builder from static call.
     *
     * @return new ClientBuilder
     */
    @Contract(" -> new")
    public static @NotNull ClientBuilder getNewClientBuilder() {
        return new ClientBuilder();
    }

    /**
     * Setter identifiant.
     *
     * @param identifiant Nouvel identifiant.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the identifiant setter.
     */
    public ClientBuilder dIdentifiant(final int identifiant)
            throws SocieteEntityException {
        this.getEntity().setIdentifiant(identifiant);
        return this;
    }

    /**
     * Setter identifiant.
     *
     * @param identifiant Nouvel identifiant.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the identifiant setter.
     */
    public ClientBuilder dIdentifiant(final String identifiant)
            throws SocieteEntityException {
        return dIdentifiant(Integer.parseInt(identifiant));
    }

    /**
     * Setter Raison Sociale.
     *
     * @param raisonSociale Nouvelle raison sociale.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the raisonSociale setter.
     */
    public ClientBuilder deRaisonSociale(final String raisonSociale)
            throws SocieteEntityException {
        this.getEntity().setRaisonSociale(raisonSociale);
        return this;
    }

    /**
     * Setter Adresse.
     *
     * @param adresse Nouvelle adresse.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the adresse setter.
     */
    public ClientBuilder dAdresse(final Adresse adresse)
            throws SocieteEntityException {
        this.getEntity().setAdresse(adresse);
        return this;
    }

    /**
     * Setter Adresse.
     *
     * @param identifiant Nouvel identifiant.
     * @param numRue Nouveau numéro de rue.
     * @param nomRue Nouveau nom de rue.
     * @param codePostal Nouveau code postal.
     * @param ville Nouvelle ville.
     * @return This builder.
     * @throws SocieteEntityException Exception set by one of Adresse setter.
     */
    public ClientBuilder avecAdresse(
            final String identifiant,
            final String numRue,
            final String nomRue,
            final String codePostal,
            final String ville) throws SocieteEntityException {
        this.getEntity().setAdresse(AdresseBuilder.getNewAdresseBuilder()
                .dIdentifiant(identifiant)
                .deNumeroRue(numRue)
                .deNomRue(nomRue)
                .deCodePostal(codePostal)
                .deVille(ville)
                .build());
        return this;
    }

    /**
     * Setter Telephone.
     *
     * @param telephone Nouveau numéro de téléphone.
     * @return This builder.
     * @throws SocieteEntityException Exception set by telephone setter.
     */
    public ClientBuilder deTelephone(final String telephone)
            throws SocieteEntityException {
        this.getEntity().setTelephone(telephone);
        return this;
    }

    /**
     * Setter Mail.
     *
     * @param mail Nouveau mail.
     * @return This builder.
     * @throws SocieteEntityException Exception set by mail setter.
     */
    public ClientBuilder deMail(final String mail)
            throws SocieteEntityException {
        this.getEntity().setMail(mail);
        return this;
    }

    /**
     * Setter Commentaires.
     *
     * @param commentaires Nouveaux commentaires.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the commentaires setter.
     */
    public ClientBuilder deCommentaires(final String commentaires)
            throws SocieteEntityException {
        this.getEntity().setCommentaires(commentaires);
        return this;
    }

    /**
     * Setter Chiffres d'Affaires.
     *
     * @param chiffreAffaires Nouveau chiffre d'affaires.
     * @return This builder.
     * @throws SocieteEntityException Exception set par le setter.
     */
    public ClientBuilder deChiffreAffaires(final long chiffreAffaires)
            throws SocieteEntityException {
        this.getEntity().setChiffreAffaires(chiffreAffaires);
        return this;
    }

    /**
     * Setter Chiffres d'Affaires.
     *
     * @param chiffreAffaires Nouveau chiffre d'affaires.
     * @return This builder.
     * @throws SocieteEntityException Exception set par le setter.
     */
    public ClientBuilder deChiffreAffaires(final String chiffreAffaires)
            throws SocieteEntityException {
        double ca = Double.parseDouble(chiffreAffaires);
        return this.deChiffreAffaires((long) ca);
    }

    /**
     * Setter Nombre Employés.
     *
     * @param nombreEmployes Nouveau nombre d'employés.
     * @return This builder.
     * @throws SocieteEntityException Exception set par le setter.
     */
    public ClientBuilder deNombreEmployes(final int nombreEmployes)
            throws SocieteEntityException {
        this.getEntity().setNbEmployes(nombreEmployes);
        return this;
    }

    /**
     * Setter Nombre Employés.
     *
     * @param nombreEmployes Nouveau nombre d'employés.
     * @return This builder.
     * @throws SocieteEntityException Exception set par le setter.
     */
    public ClientBuilder deNombreEmployes(final String nombreEmployes)
            throws SocieteEntityException {
        this.getEntity().setNbEmployes(Integer.parseInt(nombreEmployes));
        return this;
    }

    /**
     * Setter Contrats.
     *
     * @param contrats Nouvelle liste des contrats.
     * @return This builder.
     */
    public ClientBuilder deContrats(final ArrayList<Contrat> contrats) {
        this.getEntity().setContrats(contrats);
        return this;
    }

    /**
     * Ajout un contrat au client.
     *
     * @param contrat Nouveau contrat à ajouter.
     * @return This builder.
     */
    public ClientBuilder ajouterContrat(final Contrat contrat) {
        this.getEntity().getContrats().add(contrat);
        return this;
    }

    /**
     * Getter Client construit.
     *
     * @return Client construit.
     */
    public Client build() {
        return this.getEntity();
    }
}
