package edu.cibertec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.cibertec.entity.UsuarioEntity;
import edu.cibertec.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class AppConfigTests {
	private final UsuarioService usuarioService;

	@Test
	void contextLoads() {
	}

	@Test
	void testRegistrarUsuario() {
		
	}

}
