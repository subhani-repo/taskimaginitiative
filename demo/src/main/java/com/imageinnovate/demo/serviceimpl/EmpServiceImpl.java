package com.imageinnovate.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageinnovate.demo.entity.EmployeeEntity;
import com.imageinnovate.demo.entity.Mobiles;
import com.imageinnovate.demo.repo.EmployeeRepo;
import com.imageinnovate.demo.request.EmpRequest;
import com.imageinnovate.demo.response.EmployeeResponse;
import com.imageinnovate.demo.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmployeeRepo employeeRepo;
	
	public String saveEmployee(EmpRequest empRequest) {
		try {
			EmployeeEntity employeeEntity= new EmployeeEntity();
		
			 List<Mobiles> mobileNums = empRequest.getMobileNum();
		        for (Mobiles mobiles : mobileNums) {
		            mobiles.setMNum(mobiles.getMNum());
		        }
			employeeEntity.setDoj(empRequest.getDoj());
			employeeEntity.setEmail(empRequest.getEmail());
			employeeEntity.setFirstName(empRequest.getFirstName());
			employeeEntity.setLastName(empRequest.getLastName());
			employeeEntity.setSalary(empRequest.getSalary());
			employeeEntity.setMobileNum(mobileNums);
			
		employeeRepo.save(employeeEntity);
		return "success";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public List<EmployeeEntity> getall() {
	List<EmployeeEntity> EmployeeEntity=employeeRepo.findAll();
	return EmployeeEntity;
	}
	
	public EmployeeResponse getmyResponse(int id){
		EmployeeResponse getmyResponse= employeeRepo.myresponse(id);
		return getmyResponse;
	}
}
