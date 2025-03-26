package fr.afpa.pompey.cda17.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a user entity in the system.
 */
@Entity
@Table(name = "users")
public final class User {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Unique username (non-nullable).
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * User's password (non-nullable).
     */
    @Column(nullable = false)
    private String password;

    /**
     * Authentication token.
     */
    private String token;

    /**
     * Constructs a User with specified details.
     *
     * @param idParam       Unique identifier
     * @param usernameParam Unique username
     * @param passwordParam User's password
     * @param tokenParam    Authentication token
     */
    public User(
            final int idParam,
            final String usernameParam,
            final String passwordParam,
            final String tokenParam) {
        this.id = idParam;
        this.username = usernameParam;
        this.password = passwordParam;
        this.token = tokenParam;
    }

    /**
     * Default constructor for JPA.
     */
    public User() {
    }

    /**
     * Returns the authentication token.
     *
     * @return String authentication token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the authentication token.
     *
     * @param tokenParam New authentication token
     */
    public void setToken(final String tokenParam) {
        this.token = tokenParam;
    }

    /**
     * Returns the user's password.
     *
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param passwordParam New password
     */
    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    /**
     * Returns the username.
     *
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param usernameParam New username
     */
    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    /**
     * Returns the user's unique identifier.
     *
     * @return int identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's unique identifier.
     *
     * @param idParam New identifier
     */
    public void setId(final int idParam) {
        this.id = idParam;
    }
}
