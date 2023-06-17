package com.imageinnovate.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imageinnovate.demo.entity.EmployeeEntity;
import com.imageinnovate.demo.request.EmpRequest;
import com.imageinnovate.demo.response.EmployeeResponse;

@Service
public interface EmpService {

	public String saveEmployee(EmpRequest empRequest);
	
	public List<EmployeeEntity> getall();
	
	public EmployeeResponse getmyResponse(int id);
}
