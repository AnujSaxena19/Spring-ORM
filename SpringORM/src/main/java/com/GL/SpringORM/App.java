package com.GL.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.GL.SpringORM.dao.StudentDao;
import com.GL.SpringORM.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext ac= new ClassPathXmlApplicationContext("config.xml");
      StudentDao stud=ac.getBean("studentDao",StudentDao.class);
      
		/*
		 * Student student=new Student(1234,"Anuj Saxena","Bangalore"); int
		 * r=stud.insert(student); System.out.println("done"+r);
		 */
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     boolean go=true;
      System.out.println("-----------------------Welcome to spring orm project----------------------------------");
      while(go) {
    	  System.out.println("Press 1 for add the new student");
    	  System.out.println("Press 2 for display all students");
    	  System.out.println("Press 3 for get detail of single student");
    	  System.out.println("Press 4 for delete students");
    	  System.out.println("Press 5 for exit");
    	  
    	  try {
    		  int input=Integer.parseInt(br.readLine());
    		  
    		  switch(input) {
    		  
    		  case 1:
    			  //add a new student
    			  System.out.println("Enter the student id:");
    			  int uid=Integer.parseInt(br.readLine());
    			  
    			  System.out.println("Enter student name :");
    			  String uName=br.readLine();
    			  
    			  System.out.println("Enter student city");
    			  String sCity=br.readLine();
    			  
    			  Student s=new Student();
    			  s.setStudentId(uid);
    			  s.setStudentName(uName);
    			  s.setStudentCity(sCity);
    			  
    			  int r=stud.insert(s);
    			  System.out.println(r+"student added");
    			  System.out.println("*******************************************************");
    			  System.out.println();
    			  break;
    			  
    		  case 2:
    			  //display all students
    			  System.out.println("********************************************************");
    			  List<Student> allStudents = stud.getAllStudents();
    			  for(Student st:allStudents) {
    				  System.out.println("Id :"+ st.getStudentId());
    				  System.out.println("Name :" +st.getStudentName());
    				  System.out.println("City "+st.getStudentCity());
    				  System.out.println("----------------------------------------------------------------");
    			  }
    			  System.out.println("***********************************************************");
    			  break;
    			  
    		  case 3:
    			  //display a single record
    			  System.out.println("Enter the student id:");
    			  int sid=Integer.parseInt(br.readLine());
    			  Student student = stud.getStudent(sid);
    			  System.out.println("Id :"+ student.getStudentId());
				  System.out.println("Name :" +student.getStudentName());
				  System.out.println("City "+student.getStudentCity());
				  System.out.println("----------------------------------------------------------------");
    			  break;
    			  
    		  case 4: 
    			  System.out.println("Enter the student id:");
    			  int id=Integer.parseInt(br.readLine());
    			  stud.deleteStudent(id);
    			  System.out.println("Student deleted....");
    			  break;
    			  
    			  
    		  case 5:
    			  go=false;
    			  break;
    		  }
    		
    	  }
    	  catch(Exception e) {
    		  System.out.println("Invalid input try with another one!!");
    		  System.out.println(e.getMessage());
    		  
    	  }
      }
      System.out.println("Thankyou for using the system");
    }
    
}
