package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ClientMySqlDAO;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.utilities.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DeleteClientsController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        String jsp = "clients/view.jsp";
        String urlSuite = Security.estConnecte(request, jsp);

        if (jsp.equals(urlSuite)) {
            request.setAttribute("titlePage", "Suppression");
            request.setAttribute("titleGroup", "Clients");

            String clientId = request.getParameter("clientId");
            Client client = new ClientMySqlDAO()
                                .findById(Integer.parseInt(clientId));

            if (request.getParameterMap().containsKey("delete")) {

                (new ClientMySqlDAO()).delete(client);
                urlSuite = "redirect:?cmd=clients";
            }

            request.setAttribute("client", client);
        }

        return urlSuite;
    }
}
