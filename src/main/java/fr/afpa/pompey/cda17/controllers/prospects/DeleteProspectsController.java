package fr.afpa.pompey.cda17.controllers.prospects;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ProspectMySqlDAO;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.Prospect;
import fr.afpa.pompey.cda17.utilities.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class DeleteProspectsController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        String jsp = "prospects/view.jsp";
        String urlSuite = Security.estConnecte(request, jsp);

        if(jsp.equals(urlSuite)) {
            request.setAttribute("titlePage", "Suppression");
            request.setAttribute("titleGroup", "Prospects");

            String prospectId = request.getParameter("prospectId");
            Prospect prospect = new ProspectMySqlDAO().findById(Integer.parseInt(prospectId));

            if (request.getParameterMap().containsKey("delete")) {
                (new ProspectMySqlDAO()).delete(prospect);
                urlSuite = "redirect:?cmd=prospects";
            }

            request.setAttribute("prospect", prospect);
        }

        return urlSuite;
    }
}