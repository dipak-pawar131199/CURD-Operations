package com.CURD.CURDOPERATION;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.*;

@Path("student")
public class StudentResource
{
  StudentRepository repo= new StudentRepository();	
  @GET	
  @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
  public List<Student> getStudent()
  {
	  
	  System.out.print("getstudent call");
	  
	  return repo.getStudents();
	  
  }
  @GET
  @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
  @Path("student/{sno}")
  public Student getStudent1(@PathParam("sno")int student_no)
  {
	  return repo.getStudent1(student_no);
  }
  
  @POST
  @Path("student")
  public Student createStudent(Student s1)
  {
	  System.out.println(s1);
	  repo.create(s1);
	  return s1;
  }
  
  @PUT
  @Path("student")
  public Student updateStudent(Student s1)
  {
	  System.out.println(s1);
	
	  
	  if(repo.getStudent1(s1.getStudent_no()).getStudent_no()==0)
	  {
		  repo.create(s1);
	  }
	  else
	  {
		 repo.update(s1);  
	  }
	  return s1;
  }
  
  @DELETE
  @Path("student/{sno}")
  @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
  public Student deleteStudent(@PathParam("sno")int student_no)
  {
	  Student s=repo.getStudent1(student_no);
	  if(s.getStudent_no()!=0)
	  {
		  repo.delete(student_no);
	  }
	  
	  return s;
  }
  
  
}
