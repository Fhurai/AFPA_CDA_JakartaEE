package fr.afpa.pompey.cda17.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import fr.afpa.pompey.cda17.dao.mysql.UserMySqlDAO;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

public class SigninController implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User user = new User();

        String appSecret = System.getenv("APP_SECRET");

        if(request.getParameterMap().containsKey("username")) {
            LogManager.logs.info(request.getParameter("username"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<User>> violations =
                    validator.validate(user);

            request.setAttribute("violations", violations);

            if(violations.isEmpty()) {
                UserMySqlDAO dao = new UserMySqlDAO();

                Argon2 argon2 = Argon2Factory.create();
                char[] cast = (appSecret + user.getPassword()).toCharArray();
                String hash = argon2.hash(
                        2, 65536, 1,
                        cast
                );

                user.setPassword(hash);

                if(dao.save(user)){
                    LogManager.logs.info(user.getUsername());
                    response.sendRedirect("/?cmd=connexion");
                }
            }else{
                request.setAttribute("violations", violations);
            }
        }

        request.setAttribute("titlePage", "Signin");
        request.setAttribute("titleGroup", "Général");
        request.setAttribute("user", user);

        return "connexion.jsp";
    }
}
