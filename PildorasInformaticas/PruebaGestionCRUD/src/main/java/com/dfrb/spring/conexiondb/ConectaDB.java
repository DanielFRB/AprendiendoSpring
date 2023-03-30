package com.dfrb.spring.conexiondb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dfrb@ne
 * Servlet implementation class ConectaDB
 */

@WebServlet(name = "ConectaDB", urlPatterns =  "/ConectaDB")
public class ConectaDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConectaDB() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection connection = null;
    	String jdbcUrl = "jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
		String user = "root";
		String key = "";
		String driver = "com.mysql.cj.jdbc.Driver";
    	response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			Class.forName(driver);
			connection = DriverManager.getConnection(jdbcUrl, user, key);
			out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<title>Prueba de Conexion a la BBDD</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Prueba de Conexion a la BBDD</h1>");
            out.println("<p>Nombre de la BBDD: " + jdbcUrl + "</p>");
            out.println("<p>Conectado!!!</p>");
            out.println("</body>");
            out.println("</html>");
            connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
