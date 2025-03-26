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

    /**
     *
     */
    private final int postalLength = 5;

    /**
     *
     */
    private int identifiant;

    /**
     *
     */
    @NotBlank
    @Pattern(regexp = "(?:\\d{0,3} +(bis|ter|quat)|\\G(?<!^))|(?:\\b\\d{0,3}"
            + "(?:a|b)*\\b)")
    private String numeroRue;

    /**
     *
     */
    @NotBlank
    @Pattern(regexp = "\\b([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*"
            + "[a-zA-Z\\u0080-\\u024F]*(?:[0-9]+)*"
            + "([a-zA-Z\\u0080-\\u024F])*\\b")
    private String nomRue;

    /**
     *
     */
    @NotBlank
    @Size(min = postalLength, max = postalLength)
    @Pattern(regexp = "\\b\\d{5}\\b")
    private String codePostal;

    /**
     *
     */
    @NotBlank
    @Pattern(regexp = "\\b([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*"
            + "[a-zA-Z\\u0080-\\u024F]*\\b")
    private String ville;

    /**
     * Constructs an address with specified details.
     *
     * @param id Unique identifier for the address
     * @param numero   Street number (with optional suffix like bis, ter)
     * @param nom      Street name
     * @param code      5-digit postal code
     * @param villeParam       City name
     */
    public Adresse(final int id,
                   final String numero,
                   final String nom,
                   final String code,
                   final String villeParam) {
        this.setIdentifiant(id);
        this.setNumeroRue(numero);
        this.setNomRue(nom);
        this.setCodePostal(code);
        this.setVille(villeParam);
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
     * @param id Address identifier
     */
    public void setIdentifiant(final int id) {
        this.identifiant = id;
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
     numero
     * @param numero Street number (e.g., "123 bis")
     */
    public void setNumeroRue(final String numero) {
        this.numeroRue = numero;
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
     * @param nom Street name
     */
    public void setNomRue(final String nom) {
        this.nomRue = nom;
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
     * @param code 5-digit code
     */
    public void setCodePostal(final String code) {
        this.codePostal = code;
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
     * @param villeParam City name
     */
    public void setVille(final String villeParam) {
        this.ville = villeParam;
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
