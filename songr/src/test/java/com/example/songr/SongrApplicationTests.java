package com.example.songr;

import com.example.songr.controllers.SongrController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMVC;


	@Test
	void contextLoads() {
		SongrController sut = new SongrController();
		assertNotNull(sut, "The controller was null.");
	}

	@Test
	void testHello() throws Exception {
		mockMVC.perform(get("/hello"))
				.andDo(print())
				.andExpect(content().string(containsString("<h1>Hello, world!</h1>")))
				.andExpect(status().isOk());
	}


	@Test
	void testSplash() throws Exception {
		mockMVC.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("<h1>Welcome to the Songr App!</h1>")))
				.andExpect(status().isOk());
	}

	@Test
	void testPostAlbum() throws Exception {
		mockMVC.perform(
						post("/albums")
								.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
								.param("title", "Test")
								.param("artist", "Test")
								.param("imageUrl", "Test")
				)
				.andExpect(redirectedUrl("/albums"))
				.andExpect(status().isFound());

	}
}