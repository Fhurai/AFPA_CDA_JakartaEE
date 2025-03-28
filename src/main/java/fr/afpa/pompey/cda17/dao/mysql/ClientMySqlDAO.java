package fr.afpa.pompey.cda17.dao.mysql;

import fr.afpa.pompey.cda17.builders.ClientBuilder;
import fr.afpa.pompey.cda17.dao.SocieteDatabaseException;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.Client;
import fr.afpa.pompey.cda17.models.Societe;
import fr.afpa.pompey.cda17.models.SocieteEntityException;
import fr.afpa.pompey.cda17.routers.FrontController;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Classe DAO MySql pour les clients.
 */
public class ClientMySqlDAO extends SocieteMySqlDAO<Client> {

    /**
     * Constructor.
     */
    public ClientMySqlDAO() {
    }

    /**
     * Méthode pour récupérer l'ensemble des clients.
     *
     * @return l'ensemble des clients.
     */
    @Override
    public ArrayList<Client> findAll() throws SocieteDatabaseException {
        ArrayList<Client> clients = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = FrontController.getDatasource().getConnection();
            stmt = con.prepareStatement("SELECT * FROM `clients` "
                    + "LEFT JOIN `adresses` "
                    + "ON `adresses`.`identifiant` = `clients`.`idAdresse`");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Client c = this.parse(rs);
                clients.add(c);
            }
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Database error", e);
        } finally {
            // Close resources in reverse order
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ignored) {
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ignored) {

            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ignored) {

            }
        }

        return clients;
    }

    /**
     * Méthode pour rechercher un client.
     *
     * @param name Nom du client.
     * @return Client recherché.
     * @throws SocieteDatabaseException Exception lors de la lecture ou lors
     *                                  de la fermeture des données.
     */
    @Override
    public Client find(final String name) throws SocieteDatabaseException {
        // Initialisation des variables.
        Client client = null;
        PreparedStatement stmt;

        // Récupération de la requête de lecture à partir du tableau de
        // conditions de sélection.
        String query = "SELECT * FROM clients "
                + "LEFT JOIN `adresses` "
                + "ON `adresses`.`identifiant` = `clients`.`idAdresse`"
                + "WHERE `raisonSociale` LIKE ?";

        try {
            Connection con = FrontController.getDatasource().getConnection();
            // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setString(1, '%' + name + '%');

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                client = this.parse(rs);
            }

        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur lors de la lecture "
                    + "de la base de données.");
        }

        try {
            // Fermeture de la requête.
            stmt.close();
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur lors de la fermeture "
                    + "de l'accès aux données.");
        }

        return client;
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
        ProspectMySqlDAO prospectMySqlDAO = new ProspectMySqlDAO();
        List<String> otherRaisonsSociales =
                prospectMySqlDAO.findAll().stream()
                        .map(Societe::getRaisonSociale)
                        .toList();
        return otherRaisonsSociales.contains(raisonSociale);
    }

    /**
     * Méthode pour rechercher un client.
     *
     * @param identifiant Identifiant du client.
     * @return Client recherché.
     * @throws SocieteDatabaseException Exception lors de la lecture ou lors
     *                                  de la fermeture des données.
     */
    public Client findById(final int identifiant)
            throws SocieteDatabaseException {
        // Initialisation des variables.
        Client client = null;
        PreparedStatement stmt;

        // Récupération de la requête de lecture à partir du tableau de
        // conditions de sélection.
        String query = "SELECT * FROM clients "
                + "LEFT JOIN `adresses` "
                + "ON `adresses`.`identifiant` = `clients`.`idAdresse`"
                + "WHERE `clients`.`identifiant` = ?";

        try {
            Connection con = FrontController.getDatasource().getConnection();
            // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setInt(1, identifiant);

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                client = this.parse(rs);
                client.setContrats((new ContratMySqlDAO())
                        .findByIdClient(client.getIdentifiant()));
            }

        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur lors de la lecture "
                    + "de la base de données.");
        }

        try {
            // Fermeture de la requête.
            stmt.close();
        } catch (SQLException e) {
            // Exception attrapée, log de l'erreur et avertissement de
            // l'utilisateur.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());
            throw new SocieteDatabaseException("Erreur lors de la fermeture "
                    + "de l'accès aux données.");
        }

        return client;
    }

    /**
     * Méthode pour supprimer un client.
     *
     * @param obj Le client à supprimer.
     * @return Indication que l'objet a bien été supprimé.
     * @throws SocieteDatabaseException Exception lors de la lecture ou lors
     *                                  de la fermeture des données.
     */
    @Override
    public boolean delete(final @NotNull Client obj)
            throws SocieteDatabaseException {
        // Initialisation des variables.
        Connection con = null;
        try {
            con = FrontController.getDatasource().getConnection();
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Erreur lors de l'ouverture de"
                    + " la connexion", e);
        }
        PreparedStatement stmt;
        int rowsAffected;

        // Récupération de la requête de suppression.
        String query = "DELETE FROM clients WHERE identifiant = ?";

        try {
            con.setAutoCommit(false);

            // Création de l'objet requête et exécution de celle-ci.
            stmt = con.prepareStatement(query);
            stmt.setInt(1, obj.getIdentifiant());
            rowsAffected = stmt.executeUpdate();

            (new AdresseMySqlDAO()).delete(obj.getAdresse());

            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException e) {
            try {
                con.rollback();
                con.setAutoCommit(true);
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

        // Retourne l'indication si la requête a modifié une et une seule
        // ligne d'enregistrement.
        return rowsAffected == 1;
    }

    /**
     * Méthode qui sauvegarde un client, soit en le créant, soit en le
     * modifiant.
     *
     * @param obj Le client à sauvegarder.
     * @return Indication si la sauvegarde s'est bien passé.
     * @throws SocieteDatabaseException Exception lors de la création, de la
     *                                  modification ou de la fermeture
     *                                  des données.
     */
    @Override
    public boolean save(final @NotNull Client obj)
            throws SocieteDatabaseException {

        // Sécurité unicité
        if (this.checkOtherRaisonSociale(obj.getRaisonSociale())) {
            throw new SocieteDatabaseException("La raison sociale existe déjà");
        }

        // Initialisation des variables communes.
        Connection conn = null;
        try {
            conn = FrontController.getDatasource().getConnection();
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Erreur lors de l'ouverture "
                    + "de la connexion", e);
        }
        PreparedStatement stmt;
        String query;
        boolean ret = false;

        final int fieldRaisonSociale = 1;
        final int fieldTelephone = 2;
        final int fieldEmail = 3;
        final int fieldCommentaires = 4;
        final int fieldCA = 5;
        final int fieldNbEmployes = 6;
        final int fieldIdAdresse = 7;
        final int fieldId = 8;

        try {
            conn.setAutoCommit(false);

            if (obj.getIdentifiant() > 0) {

                // Update date.
                (new AdresseMySqlDAO()).save(obj.getAdresse());

                // Initialisation variables UPDATE
                query = "UPDATE clients "
                        + "SET `raisonSociale` = ?,`telephone` = ?,"
                        + "`mail` = ?, `commentaires` = ?,`chiffreAffaires` ="
                        + " ?,`nbEmployes` = ?,`idAdresse` = ?  WHERE "
                        + "`identifiant` = ?";

                // Préparation requête à exécuter.
                stmt = conn.prepareStatement(query);

                // Liaison des données de la société dans la requête.
                stmt.setString(fieldRaisonSociale, obj.getRaisonSociale());
                stmt.setString(fieldTelephone, obj.getTelephone());
                stmt.setString(fieldEmail, obj.getMail());
                stmt.setString(fieldCommentaires, obj.getCommentaires());
                stmt.setLong(fieldCA, obj.getChiffreAffaires());
                stmt.setInt(fieldNbEmployes, obj.getNbEmployes());
                stmt.setInt(fieldIdAdresse, obj.getAdresse().getIdentifiant());
                stmt.setInt(fieldId, obj.getIdentifiant());

                // Exécution de la requête.
                ret = stmt.executeUpdate() == 1;
            } else {

                // Création date.
                (new AdresseMySqlDAO()).save(obj.getAdresse());

                // Initialisation variables CREATE
                ResultSet rs;
                query = "INSERT INTO `clients`(`raisonSociale`, `telephone`, "
                        + "`mail`, `commentaires`, `chiffreAffaires`, "
                        + "`nbEmployes`, `idAdresse`) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                // Préparation requête à exécuter.
                stmt = conn.prepareStatement(query,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                // Liaison des données de la société dans la requête.
                stmt.setString(fieldRaisonSociale, obj.getRaisonSociale());
                stmt.setString(fieldTelephone, obj.getTelephone());
                stmt.setString(fieldEmail, obj.getMail());
                stmt.setString(fieldCommentaires, obj.getCommentaires());
                stmt.setLong(fieldCA, obj.getChiffreAffaires());
                stmt.setInt(fieldNbEmployes, obj.getNbEmployes());
                stmt.setInt(fieldIdAdresse, obj.getAdresse().getIdentifiant());

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
     * Méthode qui construit un Client à partir d'une ligne de résultats.
     *
     * @param rs Ligne de résultats
     * @return Client Le client récupéré.
     * @throws SocieteDatabaseException Exception lors de la récupération.
     */
    private @NotNull Client parse(final @NotNull ResultSet rs)
            throws SocieteDatabaseException {
        try {
            return ClientBuilder.getNewClientBuilder()
                    .dIdentifiant(rs.getInt("identifiant"))
                    .deRaisonSociale(rs.getString("raisonSociale"))
                    .deTelephone(rs.getString("telephone"))
                    .deMail(rs.getString("mail"))
                    .deCommentaires(rs.getString("commentaires"))
                    .deChiffreAffaires(rs
                            .getString("chiffreAffaires"))
                    .deNombreEmployes(rs.getInt("nbEmployes"))
                    .avecAdresse(rs.getString("idAdresse"),
                            rs.getString("numRue"),
                            rs.getString("nomRue"),
                            rs.getString("codePostal"),
                            rs.getString("ville"))
                    .build();
        } catch (SocieteEntityException | SQLException e) {
            // Log exception.
            LogManager.LOGS.log(Level.SEVERE, e.getMessage());

            // Lancement d'une exception lisible par l'utilisateur.
            throw new SocieteDatabaseException("Erreur de la récupération du "
                    + "client depuis la base de données.", e);
        }
    }
}
