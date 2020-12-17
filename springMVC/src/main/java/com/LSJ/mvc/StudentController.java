package com.LSJ.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "/student1217/createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, 
							     BindingResult result) {
		String page = "/student1217/createDonePage";
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		
		if(result.hasErrors()) {
			page = "/student1217/createPage";
		}
		
		return page;
	}
}
