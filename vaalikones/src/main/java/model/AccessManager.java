package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
 
import data.Access;
import data.Database;
import persist.Ehdokkaat;;
 
public class AccessManager
{
public ArrayList<Ehdokkaat> getCourses() throws Exception
{
ArrayList<Ehdokkaat> courseList = new ArrayList<Ehdokkaat>();
Database db = new Database();
Connection con = db.getConnection();
Access access = new Access();
courseList = access.getCourses(con);
return courseList;
}
}