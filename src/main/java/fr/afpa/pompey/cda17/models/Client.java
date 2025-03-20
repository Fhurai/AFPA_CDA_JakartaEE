package fr.afpa.pompey.cda17.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a client entity extending Societe with specific business attributes.
 */
public class Client extends Societe {

    @Min(250)
    private long chiffreAffaires;

    @Min(1)
    private int nbEmployes;

    @NotNull
    @Valid
    private List<Contrat> contrats;

    /**
     * Constructs a Client with specified details.
     *
     * @param identifiant     the unique identifier
     * @param raisonSociale   the company name
     * @param adresse         the address
     * @param telephone       the contact number
     * @param mail            the email address
     * @param commentaires    additional comments
     * @param chiffreAffaires the annual turnover (must be ≥250)
     * @param nbEmployes      the employee count (must be ≥1)
     */
    public Client(int identifiant, String raisonSociale, Adresse adresse, String telephone,
                  String mail, String commentaires, long chiffreAffaires, int nbEmployes) {
        super(identifiant, raisonSociale, adresse, telephone, mail, commentaires);
        setChiffreAffaires(chiffreAffaires);
        setNbEmployes(nbEmployes);
        setContrats(new ArrayList<>());
    }

    /**
     * Constructs a Client without an identifier.
     *
     * @param raisonSociale   the company name
     * @param adresse         the address
     * @param telephone       the contact number
     * @param mail            the email address
     * @param commentaires    additional comments
     * @param chiffreAffaires the annual turnover (must be ≥250)
     * @param nbEmployes      the employee count (must be ≥1)
     */
    public Client(String raisonSociale, Adresse adresse, String telephone, String mail,
                  String commentaires, long chiffreAffaires, int nbEmployes) {
        super(raisonSociale, adresse, telephone, mail, commentaires);
        setChiffreAffaires(chiffreAffaires);
        setNbEmployes(nbEmployes);
        setContrats(new ArrayList<>());
    }

    /**
     * Default constructor initializing contrats list.
     */
    public Client() {
        super();
        setContrats(new ArrayList<>());
    }

    /**
     * Returns the annual turnover.
     *
     * @return the chiffreAffaires
     */
    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    /**
     * Sets the annual turnover.
     *
     * @param chiffreAffaires the turnover to set (must be ≥250)
     */
    public void setChiffreAffaires(long chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }

    /**
     * Returns the employee count.
     *
     * @return the nbEmployes
     */
    public int getNbEmployes() {
        return nbEmployes;
    }

    /**
     * Sets the employee count.
     *
     * @param nbEmployes the count to set (must be ≥1)
     */
    public void setNbEmployes(int nbEmployes) {
        this.nbEmployes = nbEmployes;
    }

    /**
     * Returns the list of contracts.
     *
     * @return the contrats list
     */
    public List<Contrat> getContrats() {
        return contrats;
    }

    /**
     * Sets the list of contracts.
     *
     * @param contrats the list to set
     */
    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    @Override
    public String toString() {
        return super.toString()
                + " chiffreAffaires=" + getChiffreAffaires()
                + ", nbEmployes=" + getNbEmployes();
    }
}