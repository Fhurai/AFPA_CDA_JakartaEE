package fr.afpa.pompey.cda17.dao.mysql;

import fr.afpa.pompey.cda17.builders.ProspectBuilder;
import fr.afpa.pompey.cda17.dao.SocieteDatabaseException;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.Prospect;
import fr.afpa.pompey.cda17.models.Societe;
import fr.afpa.pompey.cda17.models.SocieteEntityException;
import fr.afpa.pompey.cda17.routers.FrontController;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Classe DAO pour les prospects.
 */
public class ProspectMySqlDAO extends SocieteMySqlDAO<Prospect> {

    /**
     * Constructor.
     */
    public ProspectMySqlDAO() {
    }

    /**
     * Méthode pour récupérer l'ensemble des prospects.
     *
     * @return l'ensemble des prospects.
     */
    @Override
    public ArrayList<Prospect> findAll() throws SocieteDatabaseException {
        // Initialisation variables.
        ArrayList<Prospect> prospects = new ArrayList<>();
        PreparedStatement stmt;
        String query = "SELECT * FROM prospects";

        try {
            Connection con = FrontController.datasource.getConnection();
            // Création de l'objet requête et exécution de celle-ci.
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Tant qu'une ligne de données est disponible, ajout du
                // client issu de celle-ci dans la liste des clients.
                prospects.add(this.parse(rs));
            }
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la lecture de la base de données.");
        }

        try {
            // Fermeture de la requête.
            stmt.close();
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la fermeture de l'accès aux données.");
        }

        return prospects;
    }

    /**
     * Méthode pour rechercher un prospect.
     *
     * @param name Nom du prospect.
     * @return prospect recherché.
     * @throws SocieteDatabaseException Exception lors de la lecture ou lors
     *                                  de la fermeture des données.
     */
    @Override
    public Prospect find(final String name) throws SocieteDatabaseException {
        // Initialisation des variables.
        Prospect prospect = null;
        PreparedStatement stmt;

        // Récupération de la requête de lecture à partir du tableau de
        // conditions de sélection.
        String query = "SELECT * FROM prospects WHERE `raisonSociale` LIKE ?";

        try {
            Connection con = FrontController.datasource.getConnection();
                    // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setString(1, '%' + name + '%');

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                prospect = this.parse(rs);
            }

        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la lecture de la base de données.");
        }

        try {
            // Fermeture de la requête.
            stmt.close();
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la fermeture de l'accès aux données.");
        }

        return prospect;
    }

    /**
     *
     * @param raisonSociale La raison sociale à check.
     * @return
     * @throws SocieteDatabaseException
     */
    @Override
    protected boolean checkOtherRaisonSociale(final String raisonSociale)
            throws SocieteDatabaseException {
        ClientMySqlDAO clientMySqlDAO = new ClientMySqlDAO();
        List<String> otherRaisonsSociales =
                clientMySqlDAO.findAll().stream()
                        .map(Societe::getRaisonSociale)
                        .toList();
        return otherRaisonsSociales.contains(raisonSociale);
    }

    /**
     * Méthode pour rechercher un prospect.
     *
     * @param identifiant Identifiant du prospect.
     * @return prospect recherché.
     * @throws SocieteDatabaseException Exception lors de la lecture ou lors
     *                                  de la fermeture des données.
     */
    public Prospect findById(final int identifiant)
            throws SocieteDatabaseException {
        // Initialisation des variables.
        Prospect prospect = null;
        PreparedStatement stmt;

        // Récupération de la requête de lecture à partir du tableau de
        // conditions de sélection.
        String query = "SELECT * FROM prospects WHERE `identifiant` = ?";

        try {
            Connection con = FrontController.datasource.getConnection();
            // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setInt(1, identifiant);

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                prospect = this.parse(rs);
            }

        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la lecture de la base de données.");
        }

        try {
            // Fermeture de la requête.
            stmt.close();
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la fermeture de l'accès aux données.");
        }

        return prospect;
    }

    /**
     * Méthode pour supprimer un prospect.
     *
     * @param obj Le prospect à supprimer.
     * @return Indication que le prospect a bien été supprimé.
     * @throws SocieteDatabaseException Exception lors de la lecture ou lors
     *                                  de la fermeture des données.
     */
    @Override
    public boolean delete(final @NotNull Prospect obj)
            throws SocieteDatabaseException {
        // Initialisation des variables.
        Connection con = null;
        try {
            con = FrontController.datasource.getConnection();
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Erreur "
                    + "lors de l'ouverture de la connexion", e);
        }
        PreparedStatement stmt = null;
        int rowsAffected;

        // Requête de suppression adaptée pour les prospects
        String query = "DELETE FROM prospects WHERE identifiant = ?";

        try {
            con.setAutoCommit(false);
            stmt = con.prepareStatement(query);
            stmt.setInt(1, obj.getIdentifiant());
            rowsAffected = stmt.executeUpdate();

            (new AdresseMySqlDAO()).delete(obj.getAdresse());

            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                LogManager.LOGS.log(Level.SEVERE, "Erreur "
                        + "lors du rollback - Prospect", ex);
                throw new SocieteDatabaseException("Erreur "
                        + "de transaction lors de la suppression du prospect");
            }
            LogManager.LOGS.log(Level.SEVERE, "Erreur "
                    + "DAO Prospect : " + e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la suppression du prospect", e);

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                LogManager.LOGS.log(Level.WARNING, "Erreur "
                        + "fermeture connexion", e);
            }
        }

        return rowsAffected == 1;
    }

    /**
     * Méthode qui sauvegarde un prospect, soit en le créant, soit en le
     * modifiant.
     *
     * @param obj Le prospect à sauvegarder.
     * @return Indication si la sauvegarde s'est bien passé.
     * @throws SocieteDatabaseException Exception lors de la création, de la
     *                                  modification ou de la fermeture
     *                                  des données.
     */
    @Override
    public boolean save(final @NotNull Prospect obj)
            throws SocieteDatabaseException {

        // Sécurité unicité
        if (this.checkOtherRaisonSociale(obj.getRaisonSociale())) {
            throw new SocieteDatabaseException("La raison sociale existe déjà");
        }

        // Initialisation des variables communes.
        Connection conn = null;
        try {
            conn = FrontController.datasource.getConnection();
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Erreur lors de l'ouverture de"
                    + " la connexion", e);
        }
        PreparedStatement stmt;
        String query;
        boolean ret = false;
        final int fieldRaisonSociale = 1;
        final int fieldTelephone = 2;
        final int fieldMail = 3;
        final int fieldCommentaires = 4;
        final int fieldDateProspection = 5;
        final int fieldProspectInteresse = 6;
        final int fieldIdAdresse = 7;
        final int fieldId = 8;

        try {
            conn.setAutoCommit(false);

            if (obj.getIdentifiant() > 0) {

                // Update date.
                (new AdresseMySqlDAO()).save(obj.getAdresse());

                // Initialisation variables UPDATE
                query = "UPDATE prospects "
                        + "SET `raisonSociale` = ?,`telephone` = ?,`mail` = "
                        + "?, `commentaires` = ?,`dateProspection` = ?,"
                        + "`prospectInteresse` = ?,`idAdresse` = ?  WHERE "
                        + "`identifiant` = ?";

                // Préparation requête à exécuter.
                stmt = conn.prepareStatement(query);

                // Liaison des données de la société dans la requête.
                stmt.setString(fieldRaisonSociale, obj.getRaisonSociale());
                stmt.setString(fieldTelephone, obj.getTelephone());
                stmt.setString(fieldMail, obj.getMail());
                stmt.setString(fieldCommentaires, obj.getCommentaires());
                stmt.setDate(fieldDateProspection, Date.valueOf(
                        obj.getDateProspection()));
                stmt.setInt(fieldProspectInteresse, Objects.equals(
                        obj.getProspectInteresse(), "oui") ? 1 : 0);
                stmt.setInt(fieldIdAdresse, obj.getAdresse()
                                                .getIdentifiant());
                stmt.setInt(fieldId, obj.getIdentifiant());

                // Exécution de la requête.
                ret = stmt.executeUpdate() == 1;
            } else {
                // Création date.
                (new AdresseMySqlDAO()).save(obj.getAdresse());

                // Initialisation variables CREATE
                ResultSet rs;
                query = "INSERT INTO `prospects`(`raisonSociale`, `telephone`, "
                        + "`mail`, `commentaires`, `dateProspection`, "
                        + "`prospectInteresse`, `idAdresse`) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                // Préparation requête à exécuter.
                stmt = conn.prepareStatement(query,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                // Liaison des données de la société dans la requête.
                stmt.setString(fieldRaisonSociale, obj.getRaisonSociale());
                stmt.setString(fieldTelephone, obj.getTelephone());
                stmt.setString(fieldMail, obj.getMail());
                stmt.setString(fieldCommentaires, obj.getCommentaires());
                stmt.setDate(fieldDateProspection, Date.valueOf(
                        obj.getDateProspection()));
                stmt.setInt(fieldProspectInteresse, Objects.equals(
                        obj.getProspectInteresse(), "oui") ? 1 : 0);
                stmt.setInt(fieldIdAdresse, obj.getAdresse()
                                                .getIdentifiant());

                // Exécution de la requête.
                stmt.executeUpdate();

                // Récupération des clés générées.
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    ret = true;
                    obj.setIdentifiant(rs.getInt(1));
                }
            }
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                // Exception attrapée, log de l'erreur et avertissement de
                // l'utilisateur.
                LogManager.LOGS.log(Level.SEVERE, e.getMessage());
                throw new SocieteDatabaseException("Erreur "
                        + "lors de la sauvegarde.");
            }

            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur lors de la sauvegarde.");
        }

        try {
            // Fermeture de la requête.
            stmt.close();
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur "
                    + "lors de la fermeture de l'accès aux données.");
        }

        // Retourne si la sauvegarde s'est bien passée ou non.
        return ret;
    }

    /**
     * Méthode qui construit un Prospect à partir d'une ligne de résultats.
     *
     * @param rs Ligne de résultats
     * @return Prospect Le Prospect récupéré.
     * @throws SocieteDatabaseException Exception lors de la récupération.
     */
    private @NotNull Prospect parse(final @NotNull ResultSet rs)
            throws SocieteDatabaseException {
        try {
            return ProspectBuilder.getNewProspectBuilder()
                    .dIdentifiant(rs.getInt("identifiant"))
                    .deRaisonSociale(rs.getString("raisonSociale"))
                    .deTelephone(rs.getString("telephone"))
                    .deMail(rs.getString("mail"))
                    .deCommentaires(rs.getString("commentaires"))
                    .deDateProspection(rs.getString("dateProspection"))
                    .dInteresse(rs.getBoolean("prospectInteresse") ? "oui"
                            : "non")
                    .dAdresse((new AdresseMySqlDAO())
                            .findById(rs.getInt("idAdresse")))
                    .build();
        } catch (SocieteEntityException | SQLException e) {
            // Log exception.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());

            // Lancement d'une exception lisible par l'utilisateur.
            throw new SocieteDatabaseException("Erreur de la récupération du "
                    + "Prospect depuis la base de données.", e);
        }
    }
}
