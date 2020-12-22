package com.pack.SpringBootJPA2;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SpringBootJpa2Application implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository repo;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//namedQueryJpa();
		//queryInfo();
		//nativeQueryDemo();
		//paramDemo();
		//modifyingDemo();
		sortDemo();
	}


	private void modifyingDemo() {
		int updateCount = repo.updateDeptSalaries("HR", 16);
	      System.out.println("Update count: " + updateCount);

	      System.out.println("-- all employees after update--");
	      repo.findAll().forEach(System.out::println);
	}


	private void sortDemo() {
		System.out.println(" -- finding by dept Sales sort by 'salary' and 'name'  --");
	      List<Employee> list = repo.findByDept("HR", Sort.by("name", "salary").ascending());
	      list.forEach(System.out::println);
	}

	private void paramDemo() {
		 System.out.println(" -- find single employee --");
	      Employee emp = repo.findEmployee(15);
	      System.out.println(emp);
	      
	      System.out.println(" -- finding by dept Admin  --");
	      List<Employee> list = repo.findByDepartment("Admin");
	      list.forEach(System.out::println);
	}

	private void nativeQueryDemo() {
		 System.out.println(" -- find single employee --");
	      Employee emp = repo.findAllEmployee(16);
	      System.out.println(emp);
	      
	      System.out.println("Native named query");
	      List<Employee> list = repo.findBySalary();
	      list.forEach(System.out::println);
	}

	private void queryInfo() {
		System.out.println(" -- finding by name containing %ana  --");
	      List<Employee> list = repo.findByName("%ana");
	      list.forEach(System.out::println);
	      System.out.println(" -- finding by name containing ana  --");
	      list = repo.findByName2("ana");
	      list.forEach(System.out::println);

	      System.out.println(" -- finding via query method containing ana  --");
	      list = repo.findByNameContaining("ana");
	      list.forEach(System.out::println);
	}

	private void namedQueryJpa() {
		  System.out.println(" -- finding max salaries in Admin and IT depts  --");
	      List<Object[]> list = repo.findMaxSalariesByDept(Arrays.asList("Admin", "HR"));
	      list.forEach(arr -> {
	          System.out.println(Arrays.toString(arr));
	      });
	}

}
