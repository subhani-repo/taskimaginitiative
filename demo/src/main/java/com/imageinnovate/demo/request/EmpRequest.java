package com.imageinnovate.demo.request;

import java.util.Date;
import java.util.List;

import com.imageinnovate.demo.entity.Mobiles;

import lombok.Data;

@Data
public class EmpRequest {

	public Integer eid;
	public String firstName;
	public String lastName;
	public String email;
	public Date doj;
	public Double salary;
	public List<Mobiles> mobileNum;
}
