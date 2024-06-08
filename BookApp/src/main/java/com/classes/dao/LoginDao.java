package com.classes.dao;

import java.sql.*;

public class LoginDao {
    public Boolean Validation(String username, String password) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/servlet";
            String user = "root";
            String pwd = "root";

            String query = "select uname, password from b1login where uname=? and password=?"; // Fix SQL query
            Class.forName("com.mysql.cj.jdbc.Driver"); // Fix JDBC driver class name

            con = DriverManager.getConnection(url, user, pwd);
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
