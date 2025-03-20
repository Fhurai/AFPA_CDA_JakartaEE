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

    @NotNull
    private int identifiant;

    @NotNull
    @NotBlank
    private String raisonSociale;

    @NotNull
    @Valid
    private Adresse adresse;

    @NotNull
    @Pattern(regexp = "^(?:(?:\\+|00)33|0)\\s*[1-9]"
            + "(?:[\\s.-]*\\d{2}){4}")
    private String telephone;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+"
            + "@[a-zA-Z0-9.-]+$")
    private String mail;

    private String commentaires;

    /**
     * Constructs a Societe with all fields including identifiant.
     *
     * @param identifiant the unique identifier
     * @param raisonSociale the company's legal name
     * @param adresse the company's address
     * @param telephone the company's phone number
     * @param mail the company's email
     * @param commentaires additional comments about the company
     */
    public Societe(int identifiant, String raisonSociale, Adresse adresse,
                   String telephone, String mail, String commentaires) {
        setIdentifiant(identifiant);
        setRaisonSociale(raisonSociale);
        setAdresse(adresse);
        setTelephone(telephone);
        setMail(mail);
        setCommentaires(commentaires);
    }

    /**
     * Constructs a Societe without specifying identifiant (defaults to 0).
     *
     * @param raisonSociale the company's legal name
     * @param adresse the company's address
     * @param telephone the company's phone number
     * @param mail the company's email
     * @param commentaires additional comments about the company
     */
    public Societe(String raisonSociale, Adresse adresse, String telephone,
                   String mail, String commentaires) {
        this.identifiant = 0;
        setRaisonSociale(raisonSociale);
        setAdresse(adresse);
        setTelephone(telephone);
        setMail(mail);
        setCommentaires(commentaires);
    }

    /**
     * Default constructor for Societe.
     */
    public Societe() {
    }

    /**
     * Retrieves the comments about the company.
     *
     * @return the commentaires
     */
    public String getCommentaires() {
        return commentaires;
    }

    /**
     * Sets the comments about the company.
     *
     * @param commentaires the commentaires to set
     */
    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    /**
     * Retrieves the company's email address.
     *
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the company's email address.
     *
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Retrieves the company's phone number.
     *
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the company's phone number.
     *
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retrieves the company's address.
     *
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Sets the company's address.
     *
     * @param adresse the adresse to set
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Retrieves the company's legal name.
     *
     * @return the raisonSociale
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Sets the company's legal name.
     *
     * @param raisonSociale the raisonSociale to set
     */
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    /**
     * Retrieves the company's identifier.
     *
     * @return the identifiant
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets the company's identifier.
     *
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

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