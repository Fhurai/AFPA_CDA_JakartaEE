package fr.afpa.pompey.cda17.controllers.prospects;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ProspectMySqlDAO;
import fr.afpa.pompey.cda17.models.Prospect;
import fr.afpa.pompey.cda17.utilities.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public final class ListeProspectsController implements ICommand {

    @Override
    public String execute(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws Exception {
        request.setAttribute("titlePage", "Liste");
        request.setAttribute("titleGroup", "Prospects");
        String jsp = "prospects/liste.jsp";

        String urlSuite = Security.estConnecte(request, jsp);

        if (jsp.equals(urlSuite)) {
            ArrayList<Prospect> prospects = (new ProspectMySqlDAO()).findAll();
            request.setAttribute("prospects", prospects);
        }

        return urlSuite;
    }
}
