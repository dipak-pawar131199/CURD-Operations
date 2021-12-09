package com.CURD.CURDOPERATION;
import java.util.*;
import java.sql.*;

public class StudentRepository 
{
  Connection con=null;
  public StudentRepository()
  {
	  try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentproject","root","redhat");
		   
		   
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
  }
  //get List Of Student from STUDENT table using GET Method
  public List<Student> getStudents()
  {
	  List<Student> student=new ArrayList();
	 try
	 {
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from STUDENT");
	  while(rs.next())
	  {
		  Student s=new Student();
		  s.setStudent_no(rs.getInt(1));
		  s.setName(rs.getString(2));
		  s.setDob(rs.getString(3));
		  s.setDoj(rs.getString(4));
		  
		  student.add(s);
	  }
	 }
	 catch(Exception e)
	 {System.out.println(e);}
	 return student;
  }
  
  public Student getStudent1(int student_no)
  { 
	   System.out.println("getStudent1() call"); 
	  Student s=new Student();
	 String sql="select * from STUDENT where STUDENT_NO="+student_no;
	 try 
	 {
	      Statement st=con.createStatement();
	      ResultSet rs=st.executeQuery(sql);
	      if(rs.next())
	      {
	    	  s.setStudent_no(rs.getInt(1));
			  s.setName(rs.getString(2));
			  s.setDob(rs.getString(3));
			  s.setDoj(rs.getString(4));
			  
	     
	      }
	 }
	 catch(Exception e)
	 {System.out.println(e);}
	  
	 return s;  
  }
  
  // Add data/records into student table using POST REQUEST
   public void create(Student s)
   {
	  String sql="insert into STUDENT values(?,?,?,?)";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setInt(1, s.getStudent_no());
		  ps.setString(2,s.getName());
		  ps.setString(3, s.getDob());
		  ps.setString(4, s.getDoj());
		  ps.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
   }
   
   //Update Student records
  public void update(Student s1) 
   {
	  String sql="update STUDENT set STUDENT_NAME=?,STUDENT_DOB=? ,STUDENT_DOJ=? where STUDENT_NO=?";
	  try 
	  {
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1, s1.getName());
		   ps.setString(2, s1.getDob());
		   ps.setString(3,s1.getDoj());
		   ps.setInt(4, s1.getStudent_no());
		   
		   ps.executeUpdate();
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	
   }
  
  public void delete(int sno)
  {
	  String sql="delete from STUDENT where STUDENT_NO=?";
	  System.out.println("delete() call"); 
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setInt(1, sno);
		  ps.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
  }
  
  
}
