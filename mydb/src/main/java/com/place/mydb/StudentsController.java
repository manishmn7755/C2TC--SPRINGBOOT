package com.place.mydb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {
	@Autowired
	private StudentsService studentsService ;
	@GetMapping("/students")
	public List<Students> getAllRecords()
	{
		return studentsService.getAllStudents();
		
	}
	@GetMapping("/students/{id}")
	public Students getStudentsById(@PathVariable Long id)
	{ return studentsService.getStudentsById(id);
	
	}
	
    @PostMapping("/students")
    public Students createStudents(@RequestBody Students students)
    {
    	return studentsService.saveStudents(students);
    }
    @PutMapping("/students/{id}")
    public Students updateStudents(@PathVariable Long id, @RequestBody Students students)
    {  
    	return studentsService.updateStudents(id, students);
    
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudents(@PathVariable Long id)
    {
    	studentsService.deleteStudents(id);
    
    }
}
