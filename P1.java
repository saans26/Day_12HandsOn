/*
 * 1) Write a java program that connects to oracle database, queries the inbuilt table “emp” and
displays the first two columns (empno using column index and ename using column name ) of all the rows.
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P1 {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/globallogic", "root", "root");
		Statement st = con.createStatement();
		
		String query = "select * from employe";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getDouble(3));
		}
		/*if(rs>0)
		{
			System.out.println("Successful");
		}*/

	}

}











