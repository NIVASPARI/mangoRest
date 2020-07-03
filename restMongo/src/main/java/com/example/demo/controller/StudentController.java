package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.deo.StudentRepo;
import com.example.demo.model.Student;
//import com.example.demo.service.StudentService;


@RestController
@RequestMapping(path="/nivas")
public class StudentController {

	@Autowired
	private StudentRepo repo;
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable("id") int id)
	{
		repo.deleteById(id);
		
	}
	
	@PostMapping(path="/post")
	public Student addAlien(@RequestBody Student alien)
	{
		repo.save(alien);
		return alien;
	}
	@GetMapping(path="/get")
	public List<Student> getStudent()
	{
		return repo.findAll();
			
	}
	@PutMapping(path="/put/{id}")
	public void UpdateAlien(@PathVariable(value = "id") int id,@RequestBody Student alien)
	{
		Student s = new Student();
		
		s.setId(alien.getId());
		s.setName(alien.getName());
		s.setDept(alien.getDept());
		repo.save(s);
		
	}
	
	
	@GetMapping("/get/{id}")
	public String getAlien(@PathVariable("id")  int id)
	{
		 return repo.findById(id).toString();
		
		
	}

	
	
}
