package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public interface ICommand {

    /**
     * Méthode d'exécution de la requete HTML avec une response.
     * @param request La requete à répondre.
     * @param response La réponse à la requête.
     * @return La page à afficher
     * @throws Exception Aucune page à afficher.
     */
    String execute(HttpServletRequest request,
                   HttpServletResponse response) throws Exception;
}
