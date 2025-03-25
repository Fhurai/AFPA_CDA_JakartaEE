package fr.afpa.pompey.cda17.utilities;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Security {

    public static String estConnecte(final HttpServletRequest request,
                                     final String jsp){
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("currentUser") == null) {
            return "index.jsp";
        }

        return jsp;
    }
}
