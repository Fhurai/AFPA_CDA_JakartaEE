package fr.afpa.pompey.cda17.utilities;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 */
public final class Security {

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe utilitaire.
     */
    private Security() {
        throw new IllegalStateException("Classe utilitaire, ne pas instancier");
    }

    /**
     *
     * @param request
     * @param jsp
     * @return the accessible jsp filename.
     */
    public static String estConnecte(final HttpServletRequest request,
                                     final String jsp) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("currentUser") == null) {
            return "index.jsp";
        }

        return jsp;
    }
}
