package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	//configuações para conexão com o banco
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smts", "root", "admin");
	}
	
	//fecha conexão com o banco
	public void close() throws Exception{
		con.close();
		
	}
}
