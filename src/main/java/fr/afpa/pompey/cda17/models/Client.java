package fr.afpa.pompey.cda17.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 *
 */
public class Client extends Societe {
    /**
     *
     */
    private static final long MIN_CHIFFRE_AFFAIRES = 250L;

    /**
     *
     */
    @Min(MIN_CHIFFRE_AFFAIRES)
    private long chiffreAffaires;

    /**
     *
     */
    @Min(1)
    private int nbEmployes;

    /**
     * List of associated contracts.
     */
    @NotNull
    @Valid
    private List<Contrat> contrats;

    /**
     * Constructs a Client without identifier.
     *
     * @param raisonSociale  company name
     * @param adr            address
     * @param tel            contact number
     * @param email          email address
     * @param comment        additional comments
     * @param caValue        annual turnover (≥250)
     * @param employesCount  employee count (≥1)
     */
    public Client(final String raisonSociale, final Adresse adr,
                  final String tel, final String email, final String comment,
                  final long caValue, final int employesCount) {
        super(raisonSociale, adr, tel, email, comment);
        setChiffreAffaires(caValue);
        setNbEmployes(employesCount);
        setContrats(new ArrayList<>());
    }

    /**
     * Default constructor initializing contracts list.
     */
    public Client() {
        super();
        setContrats(new ArrayList<>());
    }

    /**
     *
     * @return Le chiffre d'affaires
     */
    public long getChiffreAffaires() {
        return chiffreAffaires;
    }

    /**
     * Sets annual turnover.
     *
     * @param caValue the turnover to set (must be ≥250)
     */
    public void setChiffreAffaires(final long caValue) {
        this.chiffreAffaires = caValue;
    }

    /**
     *
     * @return Le nombre d'employés
     */
    public int getNbEmployes() {
        return nbEmployes;
    }

    /**
     * Sets employee count.
     *
     * @param employesCount the count to set (must be ≥1)
     */
    public void setNbEmployes(final int employesCount) {
        this.nbEmployes = employesCount;
    }

    /**
     *
     * @return Les contrats du client.
     */
    public List<Contrat> getContrats() {
        return contrats;
    }

    /**
     * Sets contracts list.
     *
     * @param contratsList the list to set
     */
    public void setContrats(final List<Contrat> contratsList) {
        this.contrats = contratsList;
    }

    /**
     * {@inheritDoc}
     * Provides string representation with business metrics.
     */
    @Override
    public String toString() {
        return super.toString()
                + " chiffreAffaires=" + getChiffreAffaires()
                + ", nbEmployes=" + getNbEmployes();
    }
}
