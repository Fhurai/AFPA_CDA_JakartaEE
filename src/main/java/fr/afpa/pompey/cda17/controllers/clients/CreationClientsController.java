package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.builders.AdresseBuilder;
import fr.afpa.pompey.cda17.builders.ClientBuilder;
import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ClientMySqlDAO;
import fr.afpa.pompey.cda17.models.Adresse;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.utilities.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public final class CreationClientsController implements ICommand {

    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {


        request.setAttribute("titlePage", "Création");
        request.setAttribute("titleGroup", "Clients");
        String jsp = "clients/view.jsp";
        String urlSuite = Security.estConnecte(request, jsp);

        if(jsp.equals(urlSuite)) {
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
                        .deMail(request.getParameter("adresseMail"))
                        .deCommentaires(request.getParameter("commentaires"))
                        .dAdresse(adresse)
                        .deChiffreAffaires(request.getParameter("chiffreAffaires"))
                        .deNombreEmployes(request.getParameter("nbEmployes"))
                        .build();

                Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
                Set<ConstraintViolation<Client>> violations = validator.validate(client);

                if(!violations.isEmpty()){
                    request.setAttribute("violations", violations);
                }else{
                    (new ClientMySqlDAO()).save(client);

                    urlSuite = "redirect:?cmd=clients";
                }
            }
        }

        return urlSuite;
    }
}
