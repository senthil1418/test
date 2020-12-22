package com.pack.SpringBootJPA2;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	//Named Queries
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
	
	//@Query("SELECT e.dept, MAX(e.salary) FROM Employee e GROUP BY e.dept HAVING e.dept in ?1")
	//public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
	
	  @Query("SELECT e FROM Employee e WHERE e.name LIKE ?1")
	  public List<Employee> findByName(String name);

	  @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%")
	  public List<Employee> findByName2(String name);

	  //Instead of LIKE, if query is not complex we use containing
	  public List<Employee> findByNameContaining(String name);
	  
	  //Native Query
	  @Query(value = "Select * from  emp1000 where id=?1 ", nativeQuery = true)
	  public Employee findAllEmployee(Integer id);
	  
	  //NamedNativeQuery
	  public List<Employee> findBySalary();
	  
	  //@Param
	  @Query("select e from Employee e where e.id=:eid")
	  public Employee findEmployee(@Param("eid")Integer empid);
	  
	  //#entityname
	  @Query("SELECT e FROM #{#entityName} e WHERE e.dept = ?1")
	  public List<Employee> findByDepartment(String deptName);
	  
	    @Transactional
	    @Modifying
	    @Query("UPDATE Employee e SET e.salary = e.salary + e.salary * :byPercent/100  WHERE e.dept = :dept")
	    int updateDeptSalaries(@Param("dept") String dept, @Param("byPercent") double byPercent);
	  
	  //sort
	  public List<Employee> findByDept(String deptName, Sort sort);
}
