package com.classes.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class ViewDao {
	public List<Book> fetch(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> book = new ArrayList<Book>();
		try {
			
			String url = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String pwd = "root";
			
			String query = "select * from booking";
			
			con = DriverManager.getConnection(url,user,pwd);
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setBno(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setLan(rs.getString(4));
				b.setPrice(rs.getInt(5));
				book.add(b);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
}
