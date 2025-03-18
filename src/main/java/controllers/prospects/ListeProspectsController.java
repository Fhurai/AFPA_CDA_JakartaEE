package controllers.prospects;

import controllers.ICommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class ListeProspectsController implements ICommand {

    @Override
    public String execute(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws Exception {
        return "prospects/liste.jsp";
    }
}
