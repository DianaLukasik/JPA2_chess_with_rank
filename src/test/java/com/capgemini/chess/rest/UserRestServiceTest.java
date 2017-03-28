//package com.capgemini.chess.rest;
//
//import java.awt.PageAttributes.MediaType;
//import java.io.File;
//import org.apache.tomcat.util.http.fileupload.FileUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import com.capgemini.chess.dataaccess.source.MapDataSource;
//
//public class UserRestServiceTest {
//
//	@Autowired
//	private UserRestService urs;
//
//	@Autowired
//	private MapDataSource dataSource;
//
//	@Autowired
//	private WebApplicationContext wac;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setUp() {
//		Mockito.reset(dataSource);
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
//
//	@Test
//	public void shouldUpdateUserProfile() throws Exception {
//		// given
//		File file = FileUtils.getFileFromClasspath("classpath:/com/capgemini/chess/profileToUpdate.json");
//		String json = FileUtils.readFileToString(file);
//
//		// when
//		ResultActions response = this.mockMvc.perform(get("/update/{user}").accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()));
//
//		// then
//		response.andExpect(status().isOk());
//	}
//
//	@Test
//	public void shouldGetRanking() throws Exception {
//		// given
//
//		// when
//
//		// then
//
//	}
//
//}
