package com.imageinnovate.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "imaginnovate", name = "employee")
public class EmployeeEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	public Integer eid;
	@Column(name = "first_name")
	public String firstName;
	@Column(name = "last_name")
	public String lastName;
	@Column(name = "email")
	public String email;
	@Column(name = "doj")
	public Date doj;
	@Column(name = "salary")
	public Double salary;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_mobs",referencedColumnName = "eid")
	public List<Mobiles> mobileNum;
}
