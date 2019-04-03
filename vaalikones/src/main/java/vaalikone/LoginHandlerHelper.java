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
			System.out.println("1");
			String query = "SELECT * FROM kayttajat";
			Statement st = con.createStatement();
			System.out.println(st);
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println(rs);
			
			System.out.println("4");
			une = rs.getString("tunnus");
			pwe = rs.getString("salasana");
			System.out.println(une + pwe + "asIIUASFYUSAFAFSI");
			st.close();
		}catch(Exception e){
			
		}
		return true;
	}
}
