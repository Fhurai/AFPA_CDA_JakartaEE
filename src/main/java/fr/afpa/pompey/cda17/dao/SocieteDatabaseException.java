package fr.afpa.pompey.cda17.dao;

/**
 * Exception sur la base de données du project.
 */
public final class SocieteDatabaseException extends Exception {

    /**
     * Constructor.
     *
     * @param message Message d'erreur concernant la base de données.
     */
    public SocieteDatabaseException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message Message d'erreur concernant la base de données.
     * @param cause La cause de l'exception.
     */
    public SocieteDatabaseException(final String message,
                                    final Throwable cause) {
        super(message, cause);
    }
}
