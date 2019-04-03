package vaalikone;

import java.sql.*;  


public class LoginHandlerHelper {
	public static boolean check(String a, String b){
		String un =a;
		String pw =b;
		String une =null;
		String pwe =null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone","root","");
			
			Statement st = con.createStatement();
			
			String query = "SELECT * FROM kayttajat";

			ResultSet rs = st.executeQuery(query);
			
			rs.next();

			une = rs.getString("tunnus");
			pwe = rs.getString("salasana");
			
			if(un.equals(une)&&pw.equals(pwe)) {

				return true;
				
			}
			st.close();
		}catch(Exception e){
			
		}
		return false;
	}
}
