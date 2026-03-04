package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class student {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL  = "jdbc:mysql://localhost/company?";
    private static final String USER   = "root";
    private static final String PASS   = "siddharth2004";
    private static final Scanner sc=new Scanner(System.in);
    
    public static Connection databaseconnect()  {
  
			try {
				Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(DBURL, USER, PASS);
			return connection;
			} catch (ClassNotFoundException  | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
    	
    }

	public static void main(String[] args) {
		boolean flag=true;
		while(flag) {
			System.out.println("Welcome to Student management system");
			System.out.println("1.Add Student");
			System.out.println("2.Find Student By Id");
			System.out.println("3.Display Student Details");
			System.out.println("4.Update Student");
			System.out.println("5.Delete Student");
			System.out.println("6.Exit");
			System.out.println();
			System.out.println("Enter choice");
			int ch=sc.nextInt();
			switch (ch) {
			case 1->addstudent();
			case 2->findStudentbyId();
			case 3->displaystudent();
			case 4->updateStudent();
			case 5->deletestudent();
			case 6->{flag=false; System.out.println("Exiting.........");}
			default-> System.out.println("invalid choice");
				
			}
		}

	}

	private static void displaystudent() {
		Connection connection=databaseconnect();
		try {
			PreparedStatement statement=connection.prepareStatement("select * from student ");
			ResultSet set= statement.executeQuery();
			System.out.println("-------------------------");
			while(set.next()) {
				
				System.out.println();
				System.out.println(set.getInt(1) + "-" + set.getInt(2)+"-"+set.getString(3));
				System.out.println();
				System.out.println("-------------------------");
			}
			
			
			
			statement.close();
	        connection.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
	}

	private static void findStudentbyId() {
		Connection connection=databaseconnect();
		try {
			PreparedStatement statement=connection.prepareStatement("select * from student where RollNo=?");
			System.out.println("Enter Rollno");
			statement.setInt(1, sc.nextInt());
			ResultSet set= statement.executeQuery();
			if(set.next()) {
				System.out.println(set.getInt(1) + "-" + set.getInt(2)+"-"+set.getString(3));
			}
			else {
				System.out.println("Student not found");
			}
			
			
			statement.close();
	        connection.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	private static void updateStudent() {
	    Connection connection = databaseconnect();
	    try {
	        System.out.println("Enter rollno:");
	        int rollno = sc.nextInt(); // 7/1

	        System.out.println("1.marks");
	        System.out.println("2.name");
	        System.out.println("Enter your choice");
	        int ch = sc.nextInt(); // 7/1

	        PreparedStatement statement = null;

	        switch (ch) {

	            case 1 -> {
	                statement = connection.prepareStatement(
	                        "update student set marks=? where rollno=?");
	                System.out.println("Enter new Marks");
	                statement.setInt(1, sc.nextInt());
	                statement.setInt(2, rollno);
	                int result = statement.executeUpdate();
	    	        System.out.println("Query OK, " + result + " row(s) affected");
	    	        statement.close();
	    	        connection.close();
	            }

	            case 2 -> {
	                statement = connection.prepareStatement(
	                        "update student set name=? where rollno=?");
	                System.out.println("Enter new Name");
	                statement.setString(1, sc.next());
	                statement.setInt(2, rollno);
	                int result = statement.executeUpdate();
	    	        System.out.println("Query OK, " + result + " row(s) affected");
	    	        statement.close();
	    	        connection.close();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	private static void deletestudent() {
		Connection connection=databaseconnect();
		try {
			PreparedStatement statement=connection.prepareStatement("delete from student where RollNo=?");
			System.out.println("Enter RollNo");
			statement.setInt(1, sc.nextInt());
			int result=statement.executeUpdate();
			 System.out.println("Query OK, " + result + " row(s) affected");
		        statement.close();
		        connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	private static void addstudent() {
	    Connection connection = databaseconnect();
	    try {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
	        System.out.print("Enter RollNo: ");
	        statement.setInt(1, sc.nextInt());
	        System.out.print("Enter Marks: ");
	        statement.setInt(2, sc.nextInt());
	        System.out.print("Enter Name: ");
	        sc.nextLine(); 
	        statement.setString(3, sc.nextLine());
	        int result = statement.executeUpdate();
	        System.out.println("Query OK, " + result + " row(s) affected");
	        statement.close();
	        connection.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	 

}
