package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() {
		String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=marcofili20maria";
		try {
			return DriverManager.getConnection(jdbcUrl);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}