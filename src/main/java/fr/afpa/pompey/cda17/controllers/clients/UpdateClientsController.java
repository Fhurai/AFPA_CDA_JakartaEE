package fr.afpa.pompey.cda17.controllers.clients;

import fr.afpa.pompey.cda17.builders.AdresseBuilder;
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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public final class UpdateClientsController implements ICommand {

    @Contract(pure = true)
    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        String jsp = "clients/view.jsp";
        String urlSuite = Security.estConnecte(request, jsp);

        if(jsp.equals(urlSuite)) {
            request.setAttribute("titlePage", "Mise à jour");
            request.setAttribute("titleGroup", "Clients");

            String clientId = request.getParameter("clientId");
            Client client = new ClientMySqlDAO().findById(Integer.parseInt(clientId));

            if (request.getParameterMap().containsKey("raisonSociale")) {
                Adresse adresse;

                // Set Adresse fields from request parameters
                adresse = AdresseBuilder.getNewAdresseBuilder()
                        .deNumeroRue(request.getParameter("numeroRue"))
                        .deNomRue(request.getParameter("nomRue"))
                        .deCodePostal(request.getParameter("codePostal"))
                        .deVille(request.getParameter("ville"))
                        .build();

                // Set Client fields
                client.setRaisonSociale(request.getParameter("raisonSociale"));
                client.setTelephone(request.getParameter("telephone"));
                client.setMail(request.getParameter("adresseMail"));
                client.setCommentaires(request.getParameter("commentaires"));
                client.setAdresse(adresse);
                client.setChiffreAffaires(Long.parseLong(request.getParameter("chiffreAffaires")));
                client.setNbEmployes(Integer.parseInt(request.getParameter("nbEmployes")));


                Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
                Set<ConstraintViolation<Client>> violations = validator.validate(client);

                if(!violations.isEmpty()){
                    request.setAttribute("violations", violations);
                }else{
                    (new ClientMySqlDAO()).save(client);

                    urlSuite = "index.jsp";
                }
            }

            request.setAttribute("client", client);
        }

        return urlSuite;
    }
}
