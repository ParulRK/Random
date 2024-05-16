package ca.sheridancollege.parul.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.parul.beans.Student;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
	
	     @Autowired
	     private Student stu;
	     
	     @GetMapping("/") //need to do getmapping for index page,context path=localhost:8080
	     public String indexPage()
	     {
	    	 return "index";    //load this view
	     }
	     
	     @PostMapping("/formPost")  //from index page form method=post , action=formPost
	     public void studentForm(HttpServletResponse response,@RequestParam String firstName,
	    		 @RequestParam String lastName,@RequestParam String email,
	    		 @RequestParam Long studentNumber,
	    		 @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate birthday)
	     {
	    	 		stu.setFirstName(firstName);
	    	 		stu.setLastName(lastName);
	    	 		stu.setEmail(email);
	    	 		stu.setStudentNumber(studentNumber);
	    	 		stu.setBirthday(birthday);
	    	 		try
	    	 		{
	    	 				PrintWriter out=response.getWriter();
	    	 				out.print(stu);
	    	 				out.close();
	    	 		}
	    	 		catch(IOException e)
	    	 		{
	    	 			System.out.println("error"+e.getMessage());
	    	 			e.printStackTrace();
	    	 		}
	     }

}






