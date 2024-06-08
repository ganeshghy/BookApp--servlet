package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.dao.Book;
import com.classes.dao.ViewDao;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   ViewDao vd = new ViewDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		List<Book> b = new ArrayList<Book>();
		HttpSession session = request.getSession(false);
		
		List<Book> b = vd.fetch();
		String resultSet = "<html><table border=1px><tr><th>Book No</th><th>Book Name</th><th>Author</th><th>Language</th><th>Price</th><th>Update</th></tr>";
		for(Book books:b) {
			resultSet+= "<tr><td>"+ books.getBno() +"</td><td>"+ books.getBname() +"</td><td>"+books.getAuthor()+"</td><td>"+books.getLan()+"</td><td>"+books.getPrice()+"</td>";
			resultSet+= "<td><a href='login.html?bno="+books.getBno()+"&bname="+books.getBname()+"&author="+books.getAuthor()+"&lan="+books.getLan()+"&price="+books.getPrice()+"'>update</a></td>";
		}
		resultSet+="</table></html>";
		out.println(resultSet);
		out.println(session.getAttribute("sessionId"));
		
	}
	

}
