package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.models.Adresse;
import fr.afpa.pompey.cda17.models.Client;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

public final class CreationClientsController implements ICommand {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        if (request.getParameterMap().containsKey("raisonSociale")) {
            Client client = new Client();
            Adresse adresse = new Adresse();
            ArrayList<Object> errors = new ArrayList<>();

            // Set Adresse fields from request parameters
            adresse.setNumeroRue(request.getParameter("numeroRue"));
            adresse.setNomRue(request.getParameter("nomRue"));
            adresse.setCodePostal(request.getParameter("codePostal"));
            adresse.setVille(request.getParameter("ville"));

            // Set Client fields
            client.setRaisonSociale(request.getParameter("raisonSociale"));
            client.setTelephone(request.getParameter("telephone"));
            client.setMail(request.getParameter("mail"));
            client.setCommentaires(request.getParameter("commentaires"));
            client.setAdresse(adresse);

            try {
                client.setChiffreAffaires(Long.parseLong(request.getParameter("chiffreAffaires")));
            } catch (NumberFormatException e) {
                errors.add("Invalid chiffre d'affaires");
            }

            try {
                client.setNbEmployes(Integer.parseInt(request.getParameter("nbEmployes")));
            } catch (NumberFormatException e) {
                errors.add("Invalid number of employees");
            }

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Client>> violations = validator.validate(client);

            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
            }

            if (violations.isEmpty() && errors.isEmpty()) {
                // Persist the client

                return "clients/liste.jsp";
            } else {
                request.setAttribute("violations", violations);
                logger.warning("Validation issues: " + violations);
            }
        }

        request.setAttribute("titlePage", "Création");
        request.setAttribute("titleGroup", "Clients");

        return "clients/view.jsp";
    }
}
