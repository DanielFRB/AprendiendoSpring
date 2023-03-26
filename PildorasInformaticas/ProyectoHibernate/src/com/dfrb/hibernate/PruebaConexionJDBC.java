package com.dfrb.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexionJDBC {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/pruebasHibernate?useSSL=false";
		String user = "root";
		String key = "";
		try {
			System.out.println("Conectando con la BBDD"+ jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, key);
			System.out.println("Conexion exitosa!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
