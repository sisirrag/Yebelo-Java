import java.io.*;
import java.sql.*;
class CreateTable
{
	public static void main(String args[])throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","5656");
		Statement st=con.createStatement();
		st.executeUpdate("create table fdb(categorycode varchar(20) primary key,value int)");		
		con.close();
	}
}