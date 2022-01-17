package com.qik.challenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class ChallengeApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeApplicationTests.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void getFirstProduct() throws Exception {
		String response = mockMvc.perform(get("http://localhost:8080/products/{uuid}", "Dwt5F7KAhi"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(jsonPath("$.name", is("Amazing Pizza!")))
				.andReturn().getResponse().getContentAsString();

		LOGGER.info("response: " + response);
	}

	@Test
	public void getPromotions() throws Exception {
		String response = mockMvc.perform(get("http://localhost:8080/promotions"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();

		LOGGER.info("response: " + response);
	}


}
