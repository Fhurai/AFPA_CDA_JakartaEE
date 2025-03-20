package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.controllers.ICommand;
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

        request.setAttribute("titlePage", "Suppression");
        request.setAttribute("titleGroup", "Clients");

//        request.setAttribute("client", Clients.getClient());

        return "clients/view.jsp";
    }
}
