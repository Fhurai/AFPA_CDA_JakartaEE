package fr.afpa.pompey.cda17.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a contract with an identifier, client ID, label, and monetary amount.
 */
public class Contrat {

    @Min(1)
    private int identifiant;

    @Min(1)
    private int idClient;

    @NotNull
    @NotBlank
    private String libelle;

    @Min(1)
    private double montant;

    /**
     * Constructs a Contrat with the specified identifier, client ID, label, and amount.
     *
     * @param identifiant the unique identifier of the contract
     * @param idClient the ID of the associated client
     * @param libelle the label/name of the contract
     * @param montant the monetary value of the contract
     */
    public Contrat(int identifiant, int idClient, String libelle, double montant) {
        this.setIdentifiant(identifiant);
        this.setIdClient(idClient);
        this.setLibelle(libelle);
        this.setMontant(montant);
    }

    /**
     * Constructs a Contrat with the specified client ID, label, and amount (identifier is auto-assigned).
     *
     * @param idClient the ID of the associated client
     * @param libelle the label/name of the contract
     * @param montant the monetary value of the contract
     */
    public Contrat(int idClient, String libelle, double montant) {
        this.setIdClient(idClient);
        this.setLibelle(libelle);
        this.setMontant(montant);
    }

    /**
     * Default constructor for Contrat.
     */
    public Contrat() {
    }

    /**
     * Returns the contract's identifier.
     *
     * @return the identifiant
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets the contract's identifier.
     *
     * @param identifiant the new identifier
     */
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Returns the client ID associated with the contract.
     *
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets the client ID associated with the contract.
     *
     * @param idClient the new client ID
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Returns the contract's label/name.
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the contract's label/name.
     *
     * @param libelle the new label/name
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Returns the contract's monetary amount.
     *
     * @return the montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Sets the contract's monetary amount.
     *
     * @param montant the new monetary amount
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Returns a string representation of the contract.
     *
     * @return formatted contract details
     */
    @Override
    public String toString() {
        return "Contrat n°" + this.getIdentifiant()
                + " pour le client n°" + this.getIdClient()
                + " nommé '" + this.getLibelle() + '\''
                + ", de valeur " + this.getMontant() + "€";
    }
}