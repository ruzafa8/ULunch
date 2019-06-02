package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import uLunch.Alergias;
import uLunch.Usuario;

import static org.junit.jupiter.api.Assertions.*;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.jupiter.api.Test;

	class Usuario_Test {
		Usuario u;
		@Before
		void init() {
			List<Alergias>a=new LinkedList<>();
			u = new Usuario("user","112233","user@user.user",a);

		}

		@Test
		void test() {
			assertTrue(u.login("user@user.user","112233"));
			assertFalse(u.login("user","112233"));
			assertFalse(u.login("user@user.user","121233"));
			assertFalse(u.login("usera@usera.usera","112233"));
		}
		@After
		void finish () {
			u = null;
		}

	}

