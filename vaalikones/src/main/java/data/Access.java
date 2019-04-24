package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import persist.Ehdokkaat;
 
public class Access
{
public ArrayList<Ehdokkaat> getCourses(Connection con) throws SQLException
{
ArrayList<Ehdokkaat> courseList = new ArrayList<Ehdokkaat>();
PreparedStatement stmt = con.prepareStatement("SELECT * FROM EHDOKKAAT");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
Ehdokkaat courseObj = new Ehdokkaat();
courseObj.setEhdokasId(rs.getInt("EHDOKAS_ID"));
courseObj.setSukunimi(rs.getString("SUKUNIMI"));
courseObj.setEtunimi(rs.getString("ETUNIMI"));
courseObj.setPuolue(rs.getString("PUOLUE"));
courseList.add(courseObj);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return courseList;
 
}
}