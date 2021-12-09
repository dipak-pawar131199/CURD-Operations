package com.CURD.CURDOPERATION;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student
{
   private int student_no;
   private String name;
   private String dob;
   private String doj;


public int getStudent_no() {
	return student_no;
}

public void setStudent_no(int student_no) {
	this.student_no = student_no;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getDoj() {
	return doj;
}

public void setDoj(String doj) {
	this.doj = doj;
}

@Override
public String toString() {
	return "Student [student_no=" + student_no + ", name=" + name + ", dob=" + dob + ", doj=" + doj + "]";
}
   
  

}
