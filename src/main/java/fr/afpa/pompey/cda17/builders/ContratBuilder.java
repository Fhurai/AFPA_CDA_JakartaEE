package fr.afpa.pompey.cda17.builders;

import fr.afpa.pompey.cda17.models.Contrat;
import fr.afpa.pompey.cda17.models.SocieteEntityException;
import org.jetbrains.annotations.NotNull;

/**
 * Classe constructrice Contrat.
 */
public class ContratBuilder extends Builder<Contrat> {

    /**
     * Constructor.
     */
    ContratBuilder() {
        super(new Contrat());
    }

    /**
     * New builder from static call.
     *
     * @return new ContratBuilder.
     */
    public static @NotNull ContratBuilder getNewContratBuilder() {
        return new ContratBuilder();
    }

    /**
     * Setter identifiant.
     *
     * @param identifiant Nouvel identifiant.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the identifiant setter.
     */
    public ContratBuilder dIdentifiant(final int identifiant)
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
    public ContratBuilder dIdentifiant(@NotNull final String identifiant)
            throws SocieteEntityException {
        return this.dIdentifiant(Integer.parseInt(identifiant));
    }

    /**
     * Setter libellé.
     *
     * @param libelle Nouveau libellé.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the libelle setter.
     */
    public ContratBuilder deLibelle(final String libelle)
            throws SocieteEntityException {
        this.getEntity().setLibelle(libelle);
        return this;
    }

    /**
     * Setter Montant.
     *
     * @param montant Nouveau montant.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the montant setter.
     */
    public ContratBuilder deMontant(final double montant)
            throws SocieteEntityException {
        this.getEntity().setMontant(montant);
        return this;
    }

    /**
     * Setter Montant.
     *
     * @param montant Nouveau montant.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the montant setter.
     */
    public ContratBuilder deMontant(final String montant)
            throws SocieteEntityException {
        return this.deMontant(Float.parseFloat(montant));
    }

    /**
     * Setter id client.
     *
     * @param idClient Nouvel identifiant client.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the idClient setter.
     */
    public ContratBuilder dIdClient(final int idClient)
            throws SocieteEntityException {
        this.getEntity().setIdClient(idClient);
        return this;
    }

    /**
     * Setter id client.
     * @param idClient Nouvel identifiant client.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the idClient setter.
     */
    public ContratBuilder dIdClient(final String idClient)
            throws SocieteEntityException {
        return this.dIdClient(Integer.parseInt(idClient));
    }

    /**
     * Getter Contrat construit.
     * @return Contrat construit.
     */
    public Contrat build() {
        return this.getEntity();
    }
}
