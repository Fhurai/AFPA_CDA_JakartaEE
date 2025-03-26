package fr.afpa.pompey.cda17.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Represents a company entity in the system.
 * This abstract class serves as a base for specific types of companies.
 */
public abstract class Societe {

    /**
     * Unique identifier for the company.
     */
    @NotNull
    private int identifiant;

    /**
     * Legal name of the company (non-blank).
     */
    @NotNull
    @NotBlank
    private String raisonSociale;

    /**
     * Physical address of the company.
     */
    @NotNull
    @Valid
    private Adresse adresse;

    /**
     * Valid French phone number.
     */
    @NotNull
    @Pattern(regexp = "^(?:(?:\\+|00)33|0)\\s*[1-9]"
            + "(?:[\\s.-]*\\d{2}){4}")
    private String telephone;

    /**
     * Valid email address.
     */
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+"
            + "@[a-zA-Z0-9.-]+$")
    private String mail;

    /**
     * Additional comments about the company.
     */
    private String commentaires;

    /**
     * Constructs a Societe without identifier.
     *
     * @param raisonSoc Legal name
     * @param adr      Physical address
     * @param tel      French phone number
     * @param email    Valid email
     * @param comment  Additional comments
     */
    public Societe(
            final String raisonSoc,
            final Adresse adr,
            final String tel,
            final String email,
            final String comment) {
        this.identifiant = 0;
        setRaisonSociale(raisonSoc);
        setAdresse(adr);
        setTelephone(tel);
        setMail(email);
        setCommentaires(comment);
    }

    /**
     * Default constructor.
     */
    public Societe() {
    }

    /**
     *
     * @return Les commentaires sur la société.
     */
    public String getCommentaires() {
        return commentaires;
    }

    /**
     * Sets additional comments.
     *
     * @param comment New comments
     */
    public void setCommentaires(final String comment) {
        this.commentaires = comment;
    }

    /**
     *
     * @return Le mail de la société.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets email address.
     *
     * @param email New email
     */
    public void setMail(final String email) {
        this.mail = email;
    }

    /**
     *
     * @return Le téléphone de la société.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets phone number.
     *
     * @param tel New phone number
     */
    public void setTelephone(final String tel) {
        this.telephone = tel;
    }

    /**
     *
     * @return L'adresse de la société.
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Sets physical address.
     *
     * @param adr New address
     */
    public void setAdresse(final Adresse adr) {
        this.adresse = adr;
    }

    /**
     *
     * @return La raison sociale de la société.
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Sets legal name.
     *
     * @param raisonSoc New legal name
     */
    public void setRaisonSociale(final String raisonSoc) {
        this.raisonSociale = raisonSoc;
    }

    /**
     *
     * @return Identifiant de la société.
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets unique identifier.
     *
     * @param id New identifier
     */
    public void setIdentifiant(final int id) {
        this.identifiant = id;
    }

    /**
     * {@inheritDoc}
     * Provides a string representation of the company.
     * Subclasses should use {@code super.toString()} and
     * append additional fields.
     */
    @Override
    public String toString() {
        return "identifiant=" + getIdentifiant()
                + ", raisonSociale='" + getRaisonSociale() + '\''
                + ", adresse=" + getAdresse()
                + ", telephone='" + getTelephone() + '\''
                + ", mail='" + getMail() + '\''
                + ", commentaires='" + getCommentaires() + '\'';
    }
}
