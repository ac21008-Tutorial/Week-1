import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Database connection handler.
 *
 * @author Robert Tully <r.tully@dundee.ac.uk>
 * @author Michael James Stevens
 */
public class Database {

    private final static String DB_NAME = "Receipt";
    
    public Database() {
        // Catch missing libraries and register Sqlite
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Unable to find Sqlite JDBC on classpath." +
                    "Grab 3.8.11.1+ from https://bitbucket.org/xerial/sqlite-jdbc/downloads and add it to the classpath.");
        }

        // Setup tables
        try {
            Connection conn = getConnection();
            if (!conn.getMetaData().getTables(null, null, DB_NAME, new String[]{"TABLE"}).next()) {
                // If table doesn't exist...
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE " + DB_NAME +
                             "(name     TEXT," +
                             " time     INTEGER," +
                             " description TEXT," +
                             " total    REAL)");
                stmt.close();
            }
            conn.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // Remember to CLOSE the connection when you're quite finished.
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:receipts.db");
    }

    /**
     * Get all the receipts in the database.
     *
     * @return Set of all receipts.
     */
    public Set<Receipt> getAll() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet res = stmt.executeQuery("SELECT ROWID, * FROM " + DB_NAME);
            HashSet<Receipt> out = new HashSet<>();
            while (res.next()) {
                out.add(popReceiptFromResult(res));
            }
            res.close();
            stmt.close();
            conn.close();
            return out;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Gets a specific receipt.
     *
     * @param id ID of the Receipt.
     * @return The recript (or null)
     */
    public Receipt get(int id) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + DB_NAME + " WHERE ROWID = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            Receipt out;
            if (!res.next()) {
                out = null; // Does not exist. Also forward cursor.
            } else {
                out = popReceiptFromResult(res);
            }

            res.close();
            stmt.close();
            conn.close();
            return out;
        } catch (SQLException ex) {
            System.out.println("WARN: Error in get(int) - " + ex);
            return null;
        }
    }

    /**
     * Gets receipts using a simple search on the name field.
     *
     * @param search String to search for.
     * @return A set of receipts which match (may be empty)
     */
    public Set<Receipt> get(String search) {
        try {
            search = search.replace('*', '%'); // SQL is a special snowflake and uses % for wildcarding.
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + DB_NAME + " WHERE name LIKE ?");
            stmt.setString(1, search);
            ResultSet res = stmt.executeQuery();

            HashSet<Receipt> out = new HashSet<>();
            while (res.next()) {
                out.add(popReceiptFromResult(res));
            }

            res.close();
            stmt.close();
            conn.close();
            return out;
        } catch (SQLException ex) {
            System.out.println("WARN: Error in get(String) - " + ex);
            return null;
        }
    }

    /**
     * Updates or adds the given receipt (depending on if the ID is set)
     *
     * @param receipt The receipt to add/update.
     * @return The receipt, which may have been replaced with a new ID version.
     */
    public Receipt updateOrAdd(Receipt receipt) {
        try {
            Connection conn = getConnection();
            if (receipt.id == -1) {
                // New entry
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO " + DB_NAME + " VALUES (?, ?, ?, ?)");
                stmt.setString(1, receipt.name);
                stmt.setDate(2, new Date(receipt.time.getTime())); // Java, why are you so silly sometimes? Sheesh.
                stmt.setString(3, receipt.description);
                stmt.setDouble(4, receipt.total);
                stmt.executeUpdate();
                ResultSet res = stmt.getGeneratedKeys();
                res.next(); // Set cursor to first and only row
                Receipt out = new Receipt(res.getRow(), receipt.name, receipt.time, receipt.description, receipt.total);
                res.close();
                stmt.close();
                conn.close();
                return out;
            } else {
                // Update old entry
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE " + DB_NAME + " SET name=?,time=?,description=?,total=? WHERE ROWID = ?");
                stmt.setString(1, receipt.name);
                stmt.setDate(2, new Date(receipt.time.getTime()));
                stmt.setString(3, receipt.description);
                stmt.setDouble(4, receipt.total);
                stmt.setInt(5, receipt.id);
                stmt.execute();
                return receipt;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Receipt popReceiptFromResult(ResultSet set) throws SQLException {
        Receipt r = new Receipt(set.getRow());
        r.name = set.getString("name");
        r.time = set.getDate("time");
        r.description = set.getString("description");
        r.total = set.getDouble("total");
        return r;
    }

    /**
     * Deletes a given receipt.
     *
     * @note Just an alias for delete(int)
     * @param receipt The receipt to delete.
     */
    public void delete(Receipt receipt) {
        delete(receipt.id);
    }

    /**
     * Deletes a receipt by ID.
     *
     * @param id ID to delete.
     */
    public void delete(int id) {
        if (id == -1) return;
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + DB_NAME + " WHERE ROWID = ?");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            // NOOP - bad practice I know...
        }
    }

}
