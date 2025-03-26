package fr.afpa.pompey.cda17.dao.mysql;

import fr.afpa.pompey.cda17.dao.DAO;
import fr.afpa.pompey.cda17.dao.SocieteDatabaseException;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.User;
import fr.afpa.pompey.cda17.routers.FrontController;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class UserMySqlDAO extends DAO<User> {
    /**
     *
     * @return
     * @throws SocieteDatabaseException
     */
    @Override
    public ArrayList<User> findAll() throws SocieteDatabaseException {
        return null;
    }

    /**
     *
     * @param username Nom de l'objet T recherché.
     * @return
     * @throws SocieteDatabaseException
     */
    @Override
    public User find(final String username) throws SocieteDatabaseException {
        // Initialisation des variables.
        User user = null;
        PreparedStatement stmt;

        // Récupération de la requête de lecture à partir du tableau de
        // conditions de sélection.
        String query = "SELECT * FROM users WHERE `username` = ? ";

        try {
            Connection con = FrontController.datasource.getConnection();
            // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setString(1, username);

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));
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

        return user;
    }

    /**
     *
     * @param obj L'objet à supprimer.
     * @return
     * @throws SocieteDatabaseException
     */
    @Override
    public boolean delete(final @NotNull User obj)
            throws SocieteDatabaseException {
        return false;
    }

    /**
     *
     * @param obj L'objet à sauvegarder.
     * @return
     * @throws SocieteDatabaseException
     */
    @Override
    public boolean save(final User obj) throws SocieteDatabaseException {
        // Initialisation des variables communes.
        Connection conn = null;
        try {
            conn = FrontController.datasource.getConnection();
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Erreur "
                    + "lors de l'ouverture de la connexion", e);
        }
        PreparedStatement stmt;
        String query;
        boolean ret = false;
        final int fieldId = 1;
        final int fieldUsername = 2;
        final int fieldPassword = 3;
        final int fieldToken = 4;

        try {
            conn.setAutoCommit(false);

            // Initialisation variables UPDATE
            query = "INSERT INTO "
                    + "`users`(`identifiant`, `username`, `password`, "
                    + "`token`) VALUES (?,?,?,?)";

            // Préparation requête à exécuter.
            stmt = conn.prepareStatement(query);

            // Liaison des données de l'utilisateur dans la requête.
            stmt.setInt(fieldId, obj.getId());
            stmt.setString(fieldUsername, obj.getUsername());
            stmt.setString(fieldPassword, obj.getPassword());
            stmt.setString(fieldToken, obj.getToken());

            // Exécution de la requête.
            ret = stmt.executeUpdate() == 1;

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
}
