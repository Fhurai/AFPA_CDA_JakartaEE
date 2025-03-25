package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ClientMySqlDAO;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.utilities.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class ListeClientsController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        request.setAttribute("titlePage", "Liste");
        request.setAttribute("titleGroup", "Clients");
        String jsp = "clients/liste.jsp";

        String urlSuite = Security.estConnecte(request, jsp);

        if(jsp.equals(urlSuite)) {
            ArrayList<Client> clients = (new ClientMySqlDAO()).findAll();
            request.setAttribute("clients", clients);
        }

        return urlSuite;
    }
}
