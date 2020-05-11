package com.poc.graphql.usuario;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest(classes = UsuarioRepository.class)
@ActiveProfiles(profiles = "test")
//@TestPropertySource(locations="classpath:test.properties")
class UsuarioRepositoryTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
