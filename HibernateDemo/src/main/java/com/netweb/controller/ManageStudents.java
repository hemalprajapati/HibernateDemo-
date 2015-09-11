/**
 * 
 */
package com.netweb.controller;

import com.netweb.IO.Students;
import com.netweb.services.StudentServices;

/**
 * @author hemal.prajapati
 *
 */
public class ManageStudents {

	public static void main(String a[]){
		StudentServices service=new StudentServices();
		Students student=new Students();
		student.setFirstName("Hemal");
		student.setLastName("Prajapati");
		student.setAddress("New Sama Road. Vadodara");
		service.addStudent(student);
	}
	
}
