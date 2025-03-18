package routeur;

import controllers.ICommand;
import controllers.IndexController;
import controllers.ContactController;
import controllers.ConnexionController;
import controllers.DeconnexionController;
import controllers.clients.CreationClientsController;
import controllers.clients.DeleteClientsController;
import controllers.clients.ListeClientsController;
import controllers.clients.UpdateClientsController;
import controllers.clients.ViewClientsController;
import controllers.prospects.CreationProspectsController;
import controllers.prospects.DeleteProspectsController;
import controllers.prospects.ListeProspectsController;
import controllers.prospects.UpdateProspectsController;
import controllers.prospects.ViewProspectsController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "front", value = "/front")
public final class FrontController extends HttpServlet {

    /**
     *
     */
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     *
     */
    private final HashMap<String, Object> commands = new HashMap<>();

    /**
     *
     */
    public void init() {
        // Partie générale
        commands.put("index", new IndexController());
        commands.put("contact", new ContactController());
        commands.put("connexion", new ConnexionController());
        commands.put("deconnexion", new DeconnexionController());

        // Partie clients
        commands.put("clients", new ListeClientsController());
        commands.put("clients/add", new CreationClientsController());
        commands.put("clients/delete", new DeleteClientsController());
        commands.put("clients/update", new UpdateClientsController());
        commands.put("clients/view", new ViewClientsController());

        // Partie prospects
        commands.put("prospects", new ListeProspectsController());
        commands.put("prospects/add", new CreationProspectsController());
        commands.put("prospects/delete", new DeleteProspectsController());
        commands.put("prospects/update", new UpdateProspectsController());
        commands.put("prospects/view", new ViewProspectsController());
    }

    /**
     *
     * @param request
     * @param response
     */
    private void processRequest(final HttpServletRequest request,
                                final HttpServletResponse response) {
        String urlSuite = "";

        try {
            // cmd correspond au nom du paramètre passé avec l’url
            String cmd = request.getParameter("cmd");

            // on récupère l’objet de la classe du contrôleur voulu
            ICommand com = (ICommand) commands.get(cmd);

            // on récupère dans urlSuite la JSP à dispatcher en exécutant
            // le contrôleur appelé par l’URL
            urlSuite = com.execute(request, response);
        } catch (Exception e) {
            urlSuite = "error.jsp";
        } finally {
            try {
                request.getRequestDispatcher("WEB-INF/jsp/"
                        + urlSuite).forward(request, response);
            } catch (ServletException e) {
                logger.log(Level.SEVERE, "ServletException", e);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "IOException", e);
            }
        }
    }

    /**
     *
     * @param request
     * @param response
     */
    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response) {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     */
    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response) {
        processRequest(request, response);
    }

    /**
     *
     */
    public void destroy() {
    }
}
