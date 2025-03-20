package fr.afpa.pompey.cda17.dao.mysql;

import fr.afpa.pompey.cda17.dao.SocieteDAO;
import fr.afpa.pompey.cda17.models.Societe;

/**
 * Classe DAO pour les sociétés.
 *
 * @param <T> Le type de classe à typer.
 */
abstract public class SocieteMySqlDAO<T extends Societe> extends SocieteDAO<T> {

}
