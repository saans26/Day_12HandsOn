

/*
 * 3)Inserting a record
	ABC International School wants to computerize students details. The school maintains a database of students in MYSQL.
	The student table contains information related to students and is shown in the following student table structure.
	Column Name Type Constraint
	Rollno Number (4) Primary Key
	StudentName Varchar (20) Not Null
	Standard Varchar (2) Not Null
	Date_Of_Birth Date
	Fees Number (9,2)	
 	When a new student joins the school, the student record is inserted in the student table.
 	The valid student details are as follows:
	• Rollno: Valid value is a 4-digit number
	• StudentName: Valid value can contain maximum 20 letters in uppercase
	• Standard : Valid values are Roman Letters representing I to X(I, II, III, IV….IX, X)
	Write a Java program to insert some records to the table
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P3 {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= null; //DriverManager.getConnection("jdbc:mysql://localhost:3306/globallogic", "root", "root");
		PreparedStatement ps = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/globallogic", "root", "root");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		int rollno = 0;
		do {
			System.out.println("Enter rollno : ");
			String rollstr = sc.nextLine();
			try
			{
				rollno = Integer.parseInt(rollstr);
				if(String.valueOf(rollno).length() != 4)
				{
					rollno = 0;
				}
			}
			catch(Exception e)
			{}
		}while(rollno==0);
		
		String studentName = "";
		boolean lowercasefound;
		do {
			System.out.println("Enter Student Name : ");
			studentName = sc.nextLine();
			
			lowercasefound = false;
			for(int i = 0; i < studentName.length();i++)
			{
				if(Character.isLowerCase(studentName.charAt(i)))
				{
					lowercasefound = true;
					break;
				}
			}
		} while(studentName.length()>20 || lowercasefound==false);
		
		String standard = "";
		String[]standards = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
		List<String> list = new ArrayList<String>(Arrays.asList(standards));
		
		do {
			System.out.println("Enter Standard : ");
			standard = sc.nextLine();
		}while(!list.contains(standards));
		
		System.out.println("Enter D.O.B : ");
		String dob = sc.nextLine();
		
		Double fees = 0.0;
		do {
			System.out.println("Enter Fees : ");
			if(sc.hasNextDouble())
			{
				fees = sc.nextDouble();
			}
		}while(fees == 0.0);
		
		
		String query="insert into student values(?,?,?,?,?)";
		
		try 
		{
			ps =con.prepareStatement(query);
			ps.setInt(1, rollno);
			ps.setString(2, studentName);
			ps.setString(3, standard);
			ps.setString(4, dob);
			ps.setDouble(5, fees);
			ps.executeQuery();
			System.out.println("Students added sucessfully.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Error");
			ps.close();
			con.close();
		}
		
	}

}
