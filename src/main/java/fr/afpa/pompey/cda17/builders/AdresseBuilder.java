package fr.afpa.pompey.cda17.builders;

import fr.afpa.pompey.cda17.models.Adresse;
import fr.afpa.pompey.cda17.models.SocieteEntityException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Classe constructrice Adresse.
 */
public class AdresseBuilder extends Builder<Adresse> {

    /**
     * Constructor.
     */
    public AdresseBuilder() {
        super(new Adresse());
    }

    /**
     * New builder from static call.
     *
     * @return new AdresseBuilder.
     */
    @Contract(" -> new")
    public static @NotNull AdresseBuilder getNewAdresseBuilder() {
        return new AdresseBuilder();
    }

    /**
     * Setter identifiant.
     *
     * @param identifiant Nouvel identifiant.
     * @return This builder.
     * @throws SocieteEntityException Exception set by the identifiant setter.
     */
    public AdresseBuilder dIdentifiant(final int identifiant)
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
    public AdresseBuilder dIdentifiant(final String identifiant)
            throws SocieteEntityException {
        return this.dIdentifiant(Integer.parseInt(identifiant));
    }

    /**
     * Setter Numéro Rue.
     *
     * @param numeroRue Nouveau numéro rue.
     * @return This builder.
     * @throws SocieteEntityException Exception set by numRue setter.
     */
    public AdresseBuilder deNumeroRue(final String numeroRue)
            throws SocieteEntityException {
        this.getEntity().setNumeroRue(numeroRue);
        return this;
    }

    /**
     * Setter Nom Rue.
     *
     * @param nomRue Nouveau nom rue.
     * @return This builder.
     * @throws SocieteEntityException Exception set by nomRue setter.
     */
    public AdresseBuilder deNomRue(final String nomRue)
            throws SocieteEntityException {
        this.getEntity().setNomRue(nomRue);
        return this;
    }

    /**
     * Setter Code Postal.
     *
     * @param codePostal Nouveau code postal.
     * @return This builder.
     * @throws SocieteEntityException Exception set by codePostal setter.
     */
    public AdresseBuilder deCodePostal(final String codePostal)
            throws SocieteEntityException {
        this.getEntity().setCodePostal(codePostal);
        return this;
    }

    /**
     * Setter Ville.
     *
     * @param ville Nouvelle ville.
     * @return This builder.
     * @throws SocieteEntityException Exception set by ville setter.
     */
    public AdresseBuilder deVille(final String ville)
            throws SocieteEntityException {
        this.getEntity().setVille(ville);
        return this;
    }

    /**
     * Getter Adresse construite.
     *
     * @return Adresse construite.
     */
    public Adresse build() {
        return this.getEntity();
    }
}
