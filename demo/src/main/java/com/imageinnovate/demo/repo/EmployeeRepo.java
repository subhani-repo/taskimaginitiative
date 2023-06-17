package com.imageinnovate.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imageinnovate.demo.entity.EmployeeEntity;
import com.imageinnovate.demo.response.EmployeeResponse;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{

	@Query(value="WITH total_salary AS (SELECT eid, CONCAT(first_name, ' ', last_name) AS fullName,\r\n"
			+ " salary,IF(doj > '2023-04-30', salary - 30000, salary) AS totalSalary,\r\n"
			+ " CASE WHEN salary <= 2500000 THEN 0 WHEN salary > 2500000 AND salary <= 5000000 THEN salary * 0.05 + salary * 0.02\r\n"
			+ " WHEN salary > 5000000 AND salary <= 1000000 THEN salary * 0.1 + salary * 0.02\r\n"
			+ " WHEN salary > 1000000 THEN salary * 0.2 + salary * 0.02 END AS tax,\r\n"
			+ " NOW() AS doj FROM imaginnovate.employee WHERE doj < NOW())\r\n"
			+ "SELECT eid,fullName, salary,tax,totalSalary,IF(totalSalary > 0,\r\n"
			+ " totalSalary, salary) AS totalSalaryWithMonths, IF(totalSalary > 2500000 AND totalSalary <= 5000000, totalSalary * 0.02, 0) AS cess,\r\n"
			+ "  salary / 30 AS lossOfPayPerDay FROM total_salary where eid=:eid",nativeQuery = true)
	         public EmployeeResponse myresponse(int eid);
}
