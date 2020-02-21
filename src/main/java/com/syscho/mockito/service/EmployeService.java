package com.syscho.mockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syscho.mockito.dao.EmployeeDAO;
import com.syscho.mockito.vo.Employee;

@Service
public class EmployeService {

	@Autowired
	EmployeeDAO empDAO;

	public List<Employee> getEmployees() {
		return empDAO.getEmpList();
	}

	public Employee addEmployee(Employee employee) {
		return empDAO.addEmployee(employee);
	}

}
