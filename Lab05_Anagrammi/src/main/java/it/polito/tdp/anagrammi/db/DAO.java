package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	public List<String> getDizionario(){
		String sql = "SELECT nome FROM parola";
		List<String> diz = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				diz.add(rs.getString("nome"));
			}
			rs.close();
			st.close();
			conn.close();
			return diz;
		} catch(SQLException e) {
			throw new RuntimeException();
		}
	}

}
