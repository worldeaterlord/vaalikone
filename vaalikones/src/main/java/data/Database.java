package data;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class Database
{
public Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:mysql://localhost:3306/vaalikone";
Connection connection = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "pena", "kukkuu");
return connection;
} catch (Exception e)
{
throw e;
}
 
}
 
}