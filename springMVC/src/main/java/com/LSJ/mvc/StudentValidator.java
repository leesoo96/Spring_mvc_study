package com.LSJ.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
//			     검증(유효성 검사)할 객체의 클래스 타입 정보 명시
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate() 검증");
		
		Student stu = (Student) target;
		
		String stuName= stu.getName();
		if(stuName == null || stuName.trim().isEmpty()) {
			System.out.println("stuName -> null or empty");
			errors.rejectValue("name", "trouble");
		}
		
//		rejectValue -> 현재 객체의 지정된 필드에 대한 필드 오류를 등록
		
		int stuId = stu.getId();
/*		if(stuId == 0) {
			System.out.println("stuId -> 0");
			errors.rejectValue("id", "trouble");
		}
		
 		-> 한줄요약 (많이 쓰이지는 않는다.)
*/		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
	}
 
}
