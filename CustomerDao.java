package com.digitek.dao;

import java.util.Scanner;
import java.sql.*;

public class CustomerDao {
	Scanner in = new Scanner(System.in);
	private String Id;
	private String First_Name;
	private String Last_Name;
	private String Email_id;
	private String Password;
	private String Creation_Date;
	
public void customerCreate(String id,String FN,String LN,String EID,String pwd,String CreateDate)
{
	 Id = id;
	 First_Name = FN;
	 Last_Name = LN;
	 Email_id = EID ;
	 Password = pwd;
	 Creation_Date = CreateDate;
	 
}
public class JDBConnection {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/3306";

	   //  Database credentials
	   static final String Id = "Id";
	   static final String Password = "Password";

public void customerRead(String ID, String Passw)
{
 if(Id == ID && Passw == Password )
 {
	 System.out.print("ID: " + Id + "\n First Name: " + First_Name + "\n Last Name: " +Last_Name + "\n Email: " +Email_id + "\n Creation Date: " + Creation_Date);
 }
}
public void customerUpdate(String iD, String PD )
{
	 if( Id ==iD && PD == Password )
	 {
		 
		 System.out.print("Enter new Password: /n");
		 String PWd = in.nextLine();
		 System.out.print("Confirm new Password: /n");
		 String Pwd = in.nextLine();
		 if(Pwd != PWd)
		 {
			 Pwd = in.nextLine();
		 }
		 Password = PWd;
	 }
}
public void customerDelete(String UserID,String PassWD)
{
  if (Id == UserID && Password == PassWD)
  {
	     Id = null;
		 First_Name = null;
		 Last_Name = null;
		 Email_id = null ;
		 Password = null;
		 Creation_Date = null;
		 
  }
}

	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL,Id,Password);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      String sql = "SELECT Id, First_Name, Last_Name,Email_id, Password,Creation_Date FROM Registration";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	       String  Id  = rs.getString("Id");
	       String First_Name = rs.getString("First_Name");
	         String Last_Name = rs.getString("Last_Name");
	         String Email_id = rs.getString("Email_id");
	         String Password = rs.getString("Password");
	         String Creation_Date = rs.getString("Creation_Date");

	         //Display values
	         System.out.print("ID: " + Id);
	         System.out.print(", First Name: " + First_Name);
	         System.out.print(", Last Name: " + Last_Name);
	         System.out.println(", Email: " + Email_id);
	         System.out.println(", Password: " + Password);
	         System.out.println(", Date Created: " + Creation_Date);
	      }
	      rs.close();
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	   System.out.println("Goodbye!");
	}
	}
}