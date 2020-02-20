package com.syscho.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscho.mockito.service.EmployeService;
import com.syscho.mockito.vo.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeController {

	@Autowired
	EmployeService service;

	@GetMapping("/list")
	public ResponseEntity<?> getEmployees() {

		List<Employee> employees = service.getEmployees();

		return sendReponse(employees);
		// ResponseEntity.status(HttpStatus.OK).body(employees);

	}

	private ResponseEntity<?> sendReponse(Object object) {

		ResponseEntity<?> body = null;
		List<?> response = null;
		if (object instanceof List) {
			System.out.println("EmployeController.sendReponse()");
			response = (List<?>) object;
			if (response.size() == 0) {
				response = null;
			}
		}

		if (null == response) {
			body = ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);

		} else {
			body = ResponseEntity.status(HttpStatus.OK).body(response);

		}
		return body;

	}

}
