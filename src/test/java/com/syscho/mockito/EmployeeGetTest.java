package com.syscho.mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.syscho.mockito.controller.EmployeController;
import com.syscho.mockito.service.EmployeService;
import com.syscho.mockito.vo.Employee;

/**
 * The Class EmployeeGetTest.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeController.class)
public class EmployeeGetTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The emp service. */
	@MockBean
	private EmployeService empService;

	/**
	 * Gets the emp return data.
	 *
	 * @return the emp return data
	 * @throws Exception the exception
	 */
	@Test
	public void getEmpReturnData() throws Exception {

		Employee mockpayload = new Employee("1", "jack");

		ArrayList<Employee> arrayList = new ArrayList<>();
		arrayList.add(mockpayload);

		Mockito.when(empService.getEmployees()).thenReturn(arrayList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emp/list").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	/**
	 * Gets the emp return null.
	 *
	 * @return the emp return null
	 * @throws Exception the exception
	 */
	@Test
	public void getEmpReturnNull() throws Exception {

		Mockito.when(empService.getEmployees()).thenReturn(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emp/list").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}

	/**
	 * Gets the emp return empty list.
	 *
	 * @return the emp return empty list
	 * @throws Exception the exception
	 */
	@Test
	public void getEmpReturnEmptyList() throws Exception {

		Mockito.when(empService.getEmployees()).thenReturn(new ArrayList<Employee>());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emp/list").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}

}