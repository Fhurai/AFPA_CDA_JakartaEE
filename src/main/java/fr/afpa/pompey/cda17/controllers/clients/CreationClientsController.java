package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.builders.AdresseBuilder;
import fr.afpa.pompey.cda17.builders.ClientBuilder;
import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.Adresse;
import fr.afpa.pompey.cda17.models.Client;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;

public final class CreationClientsController implements ICommand {

    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        if (request.getParameterMap().containsKey("raisonSociale")) {
            Client client;
            Adresse adresse;

            // Set Adresse fields from request parameters
            adresse = AdresseBuilder.getNewAdresseBuilder()
                    .deNumeroRue(request.getParameter("numeroRue"))
                    .deNomRue(request.getParameter("nomRue"))
                    .deCodePostal(request.getParameter("codePostal"))
                    .deVille(request.getParameter("ville"))
                    .build();

            // Set Client fields
            client = ClientBuilder.getNewClientBuilder()
                    .deRaisonSociale(request.getParameter("raisonSociale"))
                    .deTelephone(request.getParameter("telephone"))
                    .deMail(request.getParameter("mail"))
                    .deCommentaires(request.getParameter("commentaire"))
                    .dAdresse(adresse)
                    .deChiffreAffaires(request.getParameter("chiffreAffaires"))
                    .deNombreEmployes(request.getParameter("nombreEmployes"))
                    .build();

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Client>> violations = validator.validate(client);

            request.setAttribute("violations", violations);
        }

        request.setAttribute("titlePage", "Création");
        request.setAttribute("titleGroup", "Clients");

        return "clients/view.jsp";
    }
}
