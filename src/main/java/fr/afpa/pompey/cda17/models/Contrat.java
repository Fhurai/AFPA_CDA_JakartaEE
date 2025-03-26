package fr.afpa.pompey.cda17.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a contract with an identifier, client ID, label,
 * and monetary amount.
 */
public class Contrat {

    /**
     * Unique identifier for the contract (must be ≥1).
     */
    @Min(1)
    private int identifiant;

    /**
     * ID of the associated client (must be ≥1).
     */
    @Min(1)
    private int idClient;

    /**
     * Label/name of the contract (non-blank).
     */
    @NotNull
    @NotBlank
    private String libelle;

    /**
     * Monetary value of the contract (must be ≥1).
     */
    @Min(1)
    private double montant;

    /**
     * Constructs a Contrat with specified details.
     *
     * @param idParam      Unique identifier of the contract
     * @param clientIdParam ID of the associated client
     * @param libelleParam  Label/name of the contract
     * @param montantParam  Monetary value of the contract
     */
    public Contrat(
            final int idParam,
            final int clientIdParam,
            final String libelleParam,
            final double montantParam) {
        this.setIdentifiant(idParam);
        this.setIdClient(clientIdParam);
        this.setLibelle(libelleParam);
        this.setMontant(montantParam);
    }

    /**
     * Constructs a Contrat with client ID, label, and amount.
     *
     * @param clientIdParam ID of the associated client
     * @param libelleParam  Label/name of the contract
     * @param montantParam  Monetary value of the contract
     */
    public Contrat(
            final int clientIdParam,
            final String libelleParam,
            final double montantParam) {
        this.setIdClient(clientIdParam);
        this.setLibelle(libelleParam);
        this.setMontant(montantParam);
    }

    /**
     * Default constructor.
     */
    public Contrat() {
    }

    /**
     *
     * @return Identifiant du contrat.
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets the contract's identifier.
     *
     * @param idParam New identifier
     */
    public void setIdentifiant(final int idParam) {
        this.identifiant = idParam;
    }

    /**
     *
     * @return Identifiant du client du contrat.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets the client ID.
     *
     * @param clientIdParam New client ID
     */
    public void setIdClient(final int clientIdParam) {
        this.idClient = clientIdParam;
    }

    /**
     *
     * @return Libellé du contrat.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the contract's label.
     *
     * @param libelleParam New label
     */
    public void setLibelle(final String libelleParam) {
        this.libelle = libelleParam;
    }

    /**
     *
     * @return Montant du contrat.
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Sets the monetary amount.
     *
     * @param montantParam New amount
     */
    public void setMontant(final double montantParam) {
        this.montant = montantParam;
    }

    /**
     *
     * @return Représentation de l'instance d'objet sous forme d'une chaine
     * de caractères.
     */
    @Override
    public String toString() {
        return "Contrat n°" + this.getIdentifiant()
                + " pour le client n°" + this.getIdClient()
                + " nommé '" + this.getLibelle() + '\''
                + ", de valeur " + this.getMontant() + "€";
    }
}
