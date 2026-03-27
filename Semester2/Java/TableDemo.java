import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class TableDemo {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "manager"; // change if needed

    public static void main(String[] args) {

        Connection connection = null;
        Statement stmt = null;

        try {
            // Connect
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("✅ Connected to Oracle Database successfully!");

            stmt = connection.createStatement();

            // 🔹 Drop table if exists (avoid error on re-run)
            try {
                stmt.execute("DROP TABLE employees");
                System.out.println("Old table dropped.");
            } catch (Exception e) {
                // ignore if table does not exist
            }

            // 🔹 Drop sequence if exists
            try {
                stmt.execute("DROP SEQUENCE emp_seq");
            } catch (Exception e) {
                // ignore
            }

            // 🔹 Create table (NO IDENTITY for Oracle 11g)
            String createTableSQL = "CREATE TABLE employees (" +
                    "id NUMBER PRIMARY KEY, " +
                    "name VARCHAR2(100), " +
                    "position VARCHAR2(100), " +
                    "salary NUMBER" +
                    ")";
            stmt.execute(createTableSQL);
            System.out.println("✅ Table 'employees' created!");

            // 🔹 Create sequence
            stmt.execute("CREATE SEQUENCE emp_seq START WITH 1 INCREMENT BY 1");
            System.out.println("✅ Sequence created!");

            // 🔹 Insert data (one by one)
            stmt.executeUpdate("INSERT INTO employees VALUES (1, 'Alice', 'Developer', 60000)");
            stmt.executeUpdate("INSERT INTO employees VALUES (2, 'Bob', 'Manager', 80000)");
            stmt.executeUpdate("INSERT INTO employees VALUES (3, 'Charlie', 'Analyst', 50000)");

            System.out.println("✅ Data inserted!");

            // 🔹 Fetch data
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            System.out.println("\n-----------------------------------------------");
            System.out.printf("%-5s| %-15s| %-15s| %-10s\n", "ID", "Name", "Position", "Salary");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d| %-15s| %-15s| %-10d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getInt("salary"));
            }

            System.out.println("-----------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}