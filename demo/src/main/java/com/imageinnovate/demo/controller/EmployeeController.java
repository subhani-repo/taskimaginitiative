package com.imageinnovate.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imageinnovate.demo.entity.EmployeeEntity;
import com.imageinnovate.demo.request.EmpRequest;
import com.imageinnovate.demo.response.EmployeeResponse;
import com.imageinnovate.demo.service.EmpService;


@RestController
public class EmployeeController {

	@Autowired
	EmpService empService;
	
	@PostMapping("saveemployee")
	public ResponseEntity<String> upDatestatus(@RequestBody EmpRequest empRequest) 
	{
		 return ResponseEntity.ok().body(empService.saveEmployee(empRequest));
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<EmployeeEntity>> getall() 
	{
		 return ResponseEntity.ok().body(empService.getall());
	}
	
	@GetMapping("getdetails/{id}")
	public ResponseEntity<EmployeeResponse> getdatils(@PathVariable ("id")Integer id ) 
	{
		 return ResponseEntity.ok().body(empService.getmyResponse(id));
	}
	
}
