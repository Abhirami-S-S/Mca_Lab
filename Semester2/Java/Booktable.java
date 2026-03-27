import java.sql.*;
import java.util.Scanner;

public class Booktable {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PWD = "manager";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            Statement st = conn.createStatement();

            try {
                st.executeUpdate("DROP TABLE Book");
            } catch (SQLException e) {
                // ignore if table doesn't exist
            }

            st.executeUpdate(
                    "CREATE TABLE Book (" +
                            "BookId NUMBER PRIMARY KEY, " +
                            "Title VARCHAR2(50), " +
                            "Author VARCHAR2(50), " +
                            "Price NUMBER)");

            System.out.println("Table created successfully!");

            while (true) {
                System.out.println("\n--- BOOK MENU ---");
                System.out.println("1. Insert book");
                System.out.println("2. Display all books");
                System.out.println("3. Search by title");
                System.out.println("4. Books by author");
                System.out.println("5. Update price");
                System.out.println("6. Delete book");
                System.out.println("7. Exit");

                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter Price: ");
                        int price = sc.nextInt();

                        PreparedStatement ps1 = conn.prepareStatement(
                                "INSERT INTO Book VALUES(?,?,?,?)");
                        ps1.setInt(1, id);
                        ps1.setString(2, title);
                        ps1.setString(3, author);
                        ps1.setInt(4, price);
                        ps1.executeUpdate();

                        System.out.println("Book inserted!");
                        break;

                    case 2:// ✅ CREATE TABLE (Oracle syntax)
                        ResultSet rs = st.executeQuery("SELECT * FROM Book");
                        System.out.println("\nID\tTitle\tAuthor\tPrice");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("BookId") + "\t" +
                                            rs.getString("Title") + "\t" +
                                            rs.getString("Author") + "\t" +
                                            rs.getInt("// ✅ CREATE TABLE (Oracle syntax)Price"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter title: ");
                        String searchTitle = sc.nextLine();

                        PreparedStatement ps2 = conn.prepareStatement(
                                "SELECT * FROM Book WHERE Title = ?");
                        ps2.setString(1, searchTitle);
                        ResultSet rs2 = ps2.executeQuery();

                        while (rs2.next()) {
                            System.out.println(
                                    rs2.getInt("BookId") + "\t" +
                                            rs2.getString("Title") + "\t" +
                                            rs2.getString("Author") + "\t" +
                                            rs2.getInt("Price"));
                        }
                        break;

                    case 4:
                        System.out.print("Enter author: ");
                        String searchAuthor = sc.nextLine();

                        PreparedStatement ps3 = conn.prepareStatement(
                                "SELECT * FROM Book WHERE Author = ?");
                        ps3.setString(1, searchAuthor);
                        ResultSet rs3 = ps3.executeQuery();

                        while (rs3.next()) {
                            System.out.println(
                                    rs3.getInt("BookId") + "\t" +
                                            rs3.getString("Title") + "\t" +
                                            rs3.getString("Author") + "\t" +
                                            rs3.getInt("Price"));
                        }
                        break;

                    case 5:
                        System.out.print("Enter Book ID: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new price: ");
                        int newPrice = sc.nextInt();

                        PreparedStatement ps4 = conn.prepareStatement(
                                "UPDATE Book SET Price = ? WHERE BookId = ?");
                        ps4.setInt(1, newPrice);
                        ps4.setInt(2, updateId);
                        ps4.executeUpdate();

                        System.out.println("Price updated!");
                        break;

                    case 6:// ✅ CREATE TABLE (Oracle syntax)
                        System.out.print("Enter Book ID: ");
                        int deleteId = sc.nextInt();

                        PreparedStatement ps5 = conn.prepareStatement(
                                "DELETE FROM Book WHERE BookId = ?");
                        ps5.setInt(1, deleteId);
                        ps5.executeUpdate();

                        System.out.println("Book deleted!");
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        conn.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}