package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ClientMySqlDAO;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.Client;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

public final class ListeClientsController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        String urlSuite = "clients/liste.jsp";

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("currentUser") == null) {
            urlSuite = "connexion.jsp";
        }

        ArrayList<Client> clients = (new ClientMySqlDAO()).findAll();

        request.setAttribute("clients", clients);

        return urlSuite;
    }
}
