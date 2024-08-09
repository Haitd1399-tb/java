package Package1.dao.impl;

import Package1.dao.BuildingDao;
import Package1.dao.ckyeuvk.BuildingCkyeuvk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuildingDaoImpl implements BuildingDao {

    private String DB_URL = "jdbc:mysql://localhost:3306/javasql";
    private String USER = "root";
    private String PASS = "111003";

    @Override
    public List<BuildingCkyeuvk> findBuilding(String name) {
        List<BuildingCkyeuvk> results = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from building where name = '"+name+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                BuildingCkyeuvk buildingCkyeuvk = new BuildingCkyeuvk();
                buildingCkyeuvk.setId(rs.getLong("id"));
                buildingCkyeuvk.setName(rs.getString("name"));
                buildingCkyeuvk.setStreet(rs.getString("street"));
                buildingCkyeuvk.setDistrict(rs.getString("district"));
                buildingCkyeuvk.setWard(rs.getString("ward"));
                results.add(buildingCkyeuvk);
            }
            return  results;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
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

        return null;
    }
}
