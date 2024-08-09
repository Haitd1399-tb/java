package Package1;

import java.sql.*;

public class JDBCExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javasql";
    static final String USER = "root";
    static final String PASS = "111003";

    public static void main(String[] args) {
//        System.out.println("Connecting to a selected database...");
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
//            System.out.println("Connected database successfully...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String name = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from building where name = '"+name+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.print("ID" + rs.getInt("id"));
                System.out.println(",name" + rs.getString("name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}