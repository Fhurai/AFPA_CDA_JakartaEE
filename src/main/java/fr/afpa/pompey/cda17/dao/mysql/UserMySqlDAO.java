package fr.afpa.pompey.cda17.dao.mysql;

import fr.afpa.pompey.cda17.dao.DAO;
import fr.afpa.pompey.cda17.dao.SocieteDatabaseException;
import fr.afpa.pompey.cda17.logs.LogManager;
import fr.afpa.pompey.cda17.models.User;
import fr.afpa.pompey.cda17.routers.FrontController;
import fr.afpa.pompey.cda17.utilities.Formatters;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
            Connection con = FrontController.getDatasource().getConnection();
            // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setString(1, username);

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                user = new User();
                user.setId(rs.getInt("identifiant"));
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
     * @param token Le token de l'utilisateur recherché.
     * @return Utilisateur trouvé en bdd.
     * @throws SocieteDatabaseException
     */
    public User findByToken(final String token)
            throws SocieteDatabaseException {
        // Initialisation des variables.
        User user = null;
        PreparedStatement stmt;

        // Récupération de la requête de lecture à partir du tableau de
        // conditions de sélection.
        String query = "SELECT * FROM users WHERE `token` = ? ";

        try {
            Connection con = FrontController.getDatasource().getConnection();
            // Préparation de la requête.
            stmt = con.prepareStatement(query);

            stmt.setString(1, token);

            // Exécution de la requête avec les propriétés liées.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Si une ligne de résultat existe, l'objet de type T peut
                // être valorisé.
                user = new User();
                user.setId(rs.getInt("identifiant"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));

                String date = rs.getString("expire");
                String[] dt;
                LocalDate ldt;
                if (date.contains("-")) {
                    dt = date.split(" ")[0].split("-");
                    ldt = LocalDate.parse(dt[2] + '/' + dt[1] + '/' + dt[0],
                            Formatters.FORMAT_DDMMYYYY);
                } else {
                    ldt = LocalDate.parse(date, Formatters.FORMAT_DDMMYYYY);
                }

                user.setExpire(ldt);
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
            conn = FrontController.getDatasource().getConnection();
        } catch (SQLException e) {
            throw new SocieteDatabaseException("Erreur "
                    + "lors de l'ouverture de la connexion", e);
        }
        PreparedStatement stmt;
        String query;
        boolean ret = false;
        final int fieldToken = 1;
        final int fieldExpire = 2;
        final int fieldId = 3;

        try {
            conn.setAutoCommit(false);

            // Initialisation variables UPDATE
            query = "UPDATE `users` SET `token`= ?,`expire`= ? WHERE "
                    + "`identifiant`= ?";

            // Préparation requête à exécuter.
            stmt = conn.prepareStatement(query);

            // Liaison des données de l'utilisateur dans la requête.
            stmt.setString(fieldToken, obj.getToken());
            stmt.setDate(fieldExpire, Date.valueOf(obj.getExpire()));
            stmt.setInt(fieldId, obj.getId());
            LogManager.LOGS.log(Level.INFO, stmt.toString());

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
