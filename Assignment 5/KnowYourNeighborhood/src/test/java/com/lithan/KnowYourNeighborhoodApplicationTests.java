 package com.lithan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.function.IntPredicate;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.lithan.controller.TheController;
import com.lithan.entity.WebUser;
import com.lithan.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
class KnowYourNeighborhoodApplicationTests {
	@Autowired
	UserRepository repo;
	WebUser user = new WebUser("budi","123");
	
	@Autowired
	private MockMvc mvc;
	@Test
	public void testLoginPage() throws Exception {
		this.mvc.perform(get("/login")).andExpect(status().isOk());
	}
	@Test
	public void accessHomePageWithoutLogin() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().isFound());
	}
	
	@Test
	@WithMockUser("VIEW_STORE")
	public void testHomePage() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser("VIEW_STORE")
	public void deleteUsingUser() throws Exception {
		this.mvc.perform(get("/deleteStore")).andExpect(status().isForbidden());
	}
	
	@Test
	public void usingFindByUseranmeMethod() throws Exception {
		assertThat(repo.findByUsername("budi")).isNotNull();
		assertThat(user.getPassword()).isEqualTo("123");
	}
	
}
