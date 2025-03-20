package fr.afpa.pompey.cda17.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Represents a physical address with validation constraints.
 * This class includes details such as street number, street name,
 * postal code, and city, ensuring data integrity through annotations.
 */
public class Adresse {

    private int identifiant;

    @NotBlank
    @Pattern(regexp = "(?:\\d{0,3} +(bis|ter|quat)|\\G(?<!^))|(?:\\b\\d{0,3}"
            + "(?:a|b)*\\b)")
    private String numeroRue;

    @NotBlank
    @Pattern(regexp = "\\b([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*"
            + "[a-zA-Z\\u0080-\\u024F]*(?:[0-9]+)*([a-zA-Z\\u0080-\\u024F])*\\b")
    private String nomRue;

    @NotBlank
    @Size(min = 5, max = 5)
    @Pattern(regexp = "\\b\\d{5}\\b")
    private String codePostal;

    @NotBlank
    @Pattern(regexp = "\\b([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*"
            + "[a-zA-Z\\u0080-\\u024F]*\\b")
    private String ville;

    /**
     * Constructs an address with specified details.
     *
     * @param identifiant Unique identifier for the address
     * @param numeroRue   Street number (with optional suffix like bis, ter)
     * @param nomRue      Street name
     * @param codePostal  5-digit postal code
     * @param ville       City name
     */
    public Adresse(int identifiant, String numeroRue, String nomRue,
                   String codePostal, String ville) {
        setIdentifiant(identifiant);
        setNumeroRue(numeroRue);
        setNomRue(nomRue);
        setCodePostal(codePostal);
        setVille(ville);
    }

    /**
     * Default constructor for frameworks requiring no-args initialization.
     */
    public Adresse() {
    }

    /**
     * Retrieves the unique identifier.
     *
     * @return Address identifier
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets the unique identifier.
     *
     * @param identifiant Address identifier
     */
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Retrieves the street number.
     *
     * @return Street number with optional suffix
     */
    public String getNumeroRue() {
        return numeroRue;
    }

    /**
     * Sets the street number with validation.
     *
     * @param numeroRue Street number (e.g., "123 bis")
     */
    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    /**
     * Retrieves the street name.
     *
     * @return Street name
     */
    public String getNomRue() {
        return nomRue;
    }

    /**
     * Sets the street name with validation.
     *
     * @param nomRue Street name
     */
    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    /**
     * Retrieves the 5-digit postal code.
     *
     * @return Postal code
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the postal code ensuring 5 digits.
     *
     * @param codePostal 5-digit code
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Retrieves the city name.
     *
     * @return City name
     */
    public String getVille() {
        return ville;
    }

    /**
     * Sets the city name with validation.
     *
     * @param ville City name
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Provides a formatted string representation of the address.
     *
     * @return Address in "numeroRue nomRue, codePostal ville" format
     */
    @Override
    public String toString() {
        return getNumeroRue() + " " + getNomRue() + ", " + getCodePostal()
                + " " + getVille();
    }
}