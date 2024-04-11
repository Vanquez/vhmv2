package com.kindsonthegenius.fleetmsv2.hr.repositories;

import com.kindsonthegenius.fleetmsv2.hr.models.Employee;
import com.kindsonthegenius.fleetmsv2.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByUsername(String un);



	@Query(value = "select * from Employee e where e.firstname like %:keyword% or e.lastname like %:keyword%", nativeQuery = true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);

	@Query(value = "SELECT city, count(*) FROM Employee GROUP BY city",
			nativeQuery = true)
	List<Object> getCountByCountry();

	@Query(value = "SELECT COUNT(*) AS total_employees FROM Employee",
	 nativeQuery = true)
	List<Integer> getNumberEmployee();
}
