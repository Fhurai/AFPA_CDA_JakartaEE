package fr.afpa.pompey.cda17.controllers.prospects;

import fr.afpa.pompey.cda17.builders.AdresseBuilder;
import fr.afpa.pompey.cda17.builders.ProspectBuilder;
import fr.afpa.pompey.cda17.controllers.ICommand;
import fr.afpa.pompey.cda17.dao.mysql.ProspectMySqlDAO;
import fr.afpa.pompey.cda17.models.Adresse;
import fr.afpa.pompey.cda17.models.Prospect;
import fr.afpa.pompey.cda17.utilities.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public final class CreationProspectsController implements ICommand {

    @Override
    public @NotNull String execute(final HttpServletRequest request,
                                   final HttpServletResponse response)
            throws Exception {

        request.setAttribute("titlePage", "Création");
        request.setAttribute("titleGroup", "Prospects");
        String jsp = "prospects/view.jsp";
        String urlSuite = Security.estConnecte(request, jsp);

        if(jsp.equals(urlSuite)) {
            if (request.getParameterMap().containsKey("raisonSociale")) {
                Prospect prospect;
                Adresse adresse;

                // Build address
                adresse = AdresseBuilder.getNewAdresseBuilder()
                        .deNumeroRue(request.getParameter("numeroRue"))
                        .deNomRue(request.getParameter("nomRue"))
                        .deCodePostal(request.getParameter("codePostal"))
                        .deVille(request.getParameter("ville"))
                        .build();

                // Build prospect with specific fields
                prospect = ProspectBuilder.getNewProspectBuilder()
                        .deRaisonSociale(request.getParameter("raisonSociale"))
                        .deTelephone(request.getParameter("telephone"))
                        .deMail(request.getParameter("adresseMail"))
                        .deCommentaires(request.getParameter("commentaires"))
                        .dAdresse(adresse)
                        .deDateProspection(request.getParameter("dateProspection"))
                        .dInteresse(request.getParameter(
                                "prospectInteresse") != null ? "oui" : "non")
                        .build();

                // Validation
                Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
                Set<ConstraintViolation<Prospect>> violations = validator.validate(prospect);

                if(!violations.isEmpty()){
                    request.setAttribute("violations", violations);
                } else {
                    (new ProspectMySqlDAO()).save(prospect);
                    urlSuite = "redirect:?cmd=prospects";
                }
            }
        }
        return urlSuite;
    }
}