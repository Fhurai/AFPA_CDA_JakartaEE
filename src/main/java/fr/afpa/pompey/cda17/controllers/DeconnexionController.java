package fr.afpa.pompey.cda17.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DeconnexionController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        String urlSuite = "deconnexion.jsp";
        HttpSession session = request.getSession(false);

        if(request.getParameterMap().containsKey("answer")) {
            if (session != null) {
                session.invalidate();
            }
        }

        if (request.getSession(false) == null) {
            urlSuite = "index.jsp";
        }

        request.setAttribute("titlePage", "Déconnexion");
        request.setAttribute("titleGroup", "Général");

        return urlSuite;
    }
}
