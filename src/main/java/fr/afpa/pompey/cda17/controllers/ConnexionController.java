package fr.afpa.pompey.cda17.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import fr.afpa.pompey.cda17.dao.mysql.UserMySqlDAO;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class ConnexionController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {
        User user = new User();
        ArrayList<String> errors = new ArrayList<>();
        String urlSuite = "connexion.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Populate user object for form repopulation
        user.setUsername(username != null ? username : "");

        if (username != null && password != null) {
            // Validate required fields
            if (username.isEmpty()) errors.add("Username est requis");
            if (password.isEmpty()) errors.add("Password est requis");

            if (errors.isEmpty()) {
                String appSecret = System.getenv("APP_SECRET");
                UserMySqlDAO dao = new UserMySqlDAO();
                User dbUser = dao.find(username);

                if (dbUser != null) {
                    Argon2 argon2 = Argon2Factory.create();
                    char[] passwordWithSecret =
                            (appSecret + password).toCharArray();
                    LogManager.logs.info("Password: " + passwordWithSecret);
                    LogManager.logs.info("DB user: " + dbUser.getPassword());

                    try {
                        if (argon2.verify(dbUser.getPassword(), passwordWithSecret)) {
                            request.getSession().setAttribute("currentUser", dbUser);
                            urlSuite = "index.jsp";
                        } else {
                            errors.add("Username ou password incorrecte");
                        }
                    } finally {
                        argon2.wipeArray(passwordWithSecret);
                    }
                } else {
                    errors.add("Username inconnu.");
                }
            }

            if(!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                LogManager.logs.warning("Erreur de connexion pour l'utilisateur: " + username);
            }
        }

        request.setAttribute("titlePage", "Connexion");
        request.setAttribute("titleGroup", "Général");
        request.setAttribute("user", user);

        return urlSuite;
    }
}
