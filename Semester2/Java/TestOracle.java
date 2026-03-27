
/*import java.sql.*;

public class OracleConnect {
    public static void main(String[] args) {

        try {
            // 1. Load Driver (optional in JDK 17, but safe)
            //Class.forName("oracle.jdbc.OracleDriver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", // change if needed
                    "system", // your username
                    "manager" // your password
            );

            System.out.println("✅ Connected to Oracle Database!");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM dual");

            // 5. Process Result
            while (rs.next()) {
                System.out.println("Output: " + rs.getString(1));
            }

            // 6. Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
        }
    }
}
*/
//https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
//ojdbc17.jar
import java.sql.Connection;
import java.sql.DriverManager;

public class TestOracle {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String user = "system";
        String pass = "manager";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}