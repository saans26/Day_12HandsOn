import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 2) Modify the above program to display all the rows where sal is 
 * greater than 1000 and less than 2000.Display the columns ename, job, sal and comm.
 */
public class P2 {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/globallogic", "root", "root");
		Statement st = con.createStatement();
		
		String query = "select * from employe";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			if(rs.getFloat(3)>55000 && rs.getFloat(3)<67000)
			{
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) +  "  " + rs.getFloat(3));
			}
		}
		
	}

}
