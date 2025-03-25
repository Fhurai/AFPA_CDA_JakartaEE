package fr.afpa.pompey.cda17.controllers.prospects;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ClientMySqlDAO;
import fr.afpa.pompey.cda17.dao.mysql.ProspectMySqlDAO;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.models.Prospect;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

public final class ListeProspectsController implements ICommand {

    @Override
    public String execute(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws Exception {
        String urlSuite = "prospects/liste.jsp";

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("currentUser") == null) {
            urlSuite = "connexion.jsp";
        }

        ArrayList<Prospect> prospects = (new ProspectMySqlDAO()).findAll();

        request.setAttribute("prospects", prospects);

        return urlSuite;
    }
}
