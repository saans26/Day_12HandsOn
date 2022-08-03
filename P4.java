import java.util.Scanner;

/*
 *  Develop a jdbc program containing main method, which should instantiate a class called DAOClass, which should contain methods called 
 insert, delete, modify and display. Description of what each of these methods are expected to do is given below. Necessary details 
 required for executing these methods, are passed from command line argument. For e.g. If the name of the class containing the main 
 method is JDBCCalls, then if you want to insert a record, you will execute this class as java JDBCCalls 1 101 “Ajit” “IV” “20-Nov-2001” 
 4000 Where 1 is the option for inserting the record and all other details are the values for the columns in each row of the student 
 table. The structure of student table is given below. Similarly, for deleting a record, you have to execute the code as java JDBCCalls 
 2 101 where 2 is the option for deleting a record and 101 is the rollno of the student, whose record has to be deleted.
For modifying a record, you will use java JDBCCalls 3 101 4500, where 3 is the option for modifying a record and the 4500 is the new fee which needs to replace the old fee value.
For Displaying records, if the main class is executed as follows
java JDBCCalls 4 101 it should display only one record, that of the student with roll no. 101. 4 option is for displaying the record.
If the main class is executed as java JDBCCalls 4 (without specifying the rollno.), it means that details of all the students should be displayed.
 */
public class P4 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select : 1. INSERT\n2.DELETE\n3.MODIFY\n4.DISPLAY");
		int option = sc.nextInt();
		DAOClass dao = new DAOClass();
		
		switch(option)
		{
		case 1 : 
			System.out.println("Enter Roll No : ");
			int rollno = sc.nextInt();
			
			System.out.println("Enter Name : ");
			String name = sc.nextLine();
			sc.nextLine();
			
			System.out.println("Enter Standard : ");
			String standard = sc.nextLine();
			
			System.out.println("Enter Dayte of Birth : ");
			String dob = sc.nextLine();
			
			System.out.println("Enter Fees : ");
			Double fees = sc.nextDouble();
			
			if(dao.insert(rollno, name, standard, dob, fees))
			{
				System.out.println("Data Inserted Scucessfully");
			}
			else
				System.out.println("Error");
			break;
			
		case 2  : 
			System.out.println("Enter rollno  : ");
			rollno = sc.nextInt();
			
			if(dao.delete(rollno))
			{
				System.out.println("Data deleted sucessfully");
			}
			else
				System.out.println("Error");
			break;
			
		case 3 :
			System.out.println("Enter Roll NO : ");
			rollno = sc.nextInt();
			System.out.println("Enter new fees : ");
			fees = sc.nextDouble();
			
			if(dao.modify(rollno, fees))
				System.out.println("Data modified sucessfully");
			else
				System.out.println("Error");
			break;
			
		case 4 :
			try
			{
				rollno = Integer.parseInt(args[1]);
				dao.display(rollno);
				break;
			}catch(Exception e)
			{
				e.printStackTrace();;
			}
		}
		
		

	}

}
