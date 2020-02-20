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

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeController.class)
public class ClaimRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private EmployeService empService;

	@Test
	public void getClaimLineDataTest() throws Exception {

		Employee mockpayload = new Employee("1", "jack");

		Mockito.when(empService.getEmployees()).thenReturn(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emp/list").accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(mockpayload)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}