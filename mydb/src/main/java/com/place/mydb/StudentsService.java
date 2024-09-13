package com.place.mydb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
	//injecting the StudentsRepository
	@Autowired
	private StudentsRepository studentsRepository;
	
     //Retrieving all the records from the database
	public  List<Students> getAllStudents()
	   { 
	   return studentsRepository.findAll();
       }
	public Students getStudentsById(Long id)
	{ 
		return studentsRepository.findById(id).orElse(null);
	}	
	
	public Students saveStudents(Students students)
	{
		return studentsRepository.save(students);
	}
	public Students updateStudents(Long id,Students students)
	{
		// Fetches the existing students by ID
		Students existingStudents = studentsRepository.findById(id).orElse(null);
				//If the students exists, update its fields and save it 
				if (existingStudents != null) {
					existingStudents.setName(students.getName());
					existingStudents.setCollege(students.getCollege());
					return studentsRepository.save(existingStudents);
				}
		         return null;
				}
	public void deleteStudents(Long id)
	{ studentsRepository.deleteById(id);
	
	}
	}


