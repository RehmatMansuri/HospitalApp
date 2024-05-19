package com.hospitalapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class HospitalConnect {

	
	public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","Re#782950");
		}
		catch(Exception e) {
			
			
		}
		return con;
}



}
