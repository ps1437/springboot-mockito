package com.syscho.mockito.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.syscho.mockito.vo.Employee;

@Component
public class EmployeeDAO {

	private static List<Employee> emplist = new ArrayList<>();
	static {
		emplist.add(new Employee("1", "Jack"));
		emplist.add(new Employee("2", "Jassy"));
		emplist.add(new Employee("3", "Roy"));

	}

	public List<Employee> getEmpList() {
		return emplist;
	}

	public Employee addEmployee(Employee employee) {
		return employee;
	}

}
