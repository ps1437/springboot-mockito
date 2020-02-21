package com.syscho.mockito;

import static org.junit.Assert.assertEquals;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syscho.mockito.controller.EmployeController;
import com.syscho.mockito.service.EmployeService;
import com.syscho.mockito.vo.Employee;

/**
 * The Class EmployeeAddTest.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeController.class)
public class EmployeeAddTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The emp service. */
	@MockBean
	private EmployeService empService;

	/** The mapper. */
	@Autowired
	private ObjectMapper mapper;

	/**
	 * Gets the claim return error.
	 *
	 * @return the claim return error
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getClaimReturnError() throws Exception {

		Employee mockpayload = new Employee("4", "jack");

		Mockito.when(empService.addEmployee(mockpayload)).thenReturn(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/emp/add").accept(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(mockpayload)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}

	/**
	 * Gets the claim return data.
	 *
	 * @return the claim return data
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getClaimReturnData() throws Exception {

		Employee mockpayload = new Employee("4", "jack");

		Mockito.when(empService.addEmployee(mockpayload)).thenReturn(new Employee());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/emp/add").accept(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(mockpayload)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}