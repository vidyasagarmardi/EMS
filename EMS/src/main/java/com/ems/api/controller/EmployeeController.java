package com.ems.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.entity.Employee;
import com.ems.api.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	Map<String, Object> addEmp(@RequestBody Employee emp){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.add(emp));
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}
	
	@GetMapping("/getById/{id}")
	Map<String, Object> getEmp(@PathVariable Long id){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.getByID(id));
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}
	
	@GetMapping("/getAll")
	Map<String, Object> getAll(){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.getAll());
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}
	
	@PutMapping("/update/{id}")
	Map<String, Object> update(@RequestBody Employee emp, @PathVariable Long id){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.update(emp, id));
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}
	
	@DeleteMapping("delete/{id}")
	Map<String, Object> delete(@PathVariable Long id){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", service.delete(id));
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}

}
