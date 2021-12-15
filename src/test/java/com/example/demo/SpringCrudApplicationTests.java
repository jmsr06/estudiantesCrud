package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EstudianteController.class)
class SpringCrudApplicationTests {
	@Autowired
    private MockMvc mvc;

	@Test
	@DisplayName("obtener todos los estudiantes")
	public void getEstudiantesTest() throws Exception{
		mvc.perform(get("/getEstudiantes").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].nombre", is("Jenny")))
			.andExpect(jsonPath("$[1].nombre", is("Marcela")))
			.andExpect(jsonPath("$[2].nombre", is("Santiago")));
	}

	@Test
	@DisplayName("obtener el estudiante 1")
	public void getEstudianteTest() throws Exception{
		mvc.perform(get("/getEstudiante/{id}",1).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.nombre", is("Jenny")))
			.andExpect(jsonPath("$.telefono", is("3192996631")));
	}

	@Test
	@DisplayName("guardar un estudiante")
	public void postEstudianteTest() throws Exception{
		Estudiante estudiante = new Estudiante(4L, "Pepito", "1234567890", 2160866L);
		mvc.perform(post("/postEstudiante")
			.content(asJsonString(estudiante))
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(4)))
			.andExpect(jsonPath("$.nombre", is("Pepito")))
			.andExpect(jsonPath("$.telefono", is("1234567890")));

		mvc.perform(get("/getEstudiantes").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(4)));
	}

	@Test
	@DisplayName("actualizar el estudiante 3")
	public void updateEstudianteTest() throws Exception{
		Estudiante estudiante = new Estudiante(3L, "Maria", "0987654321", 2160866L);
		/**
		 * Actualizamos al estudiante 4
		 */
		mvc.perform(put("/putEstudiante/{id}",3)
			.content(asJsonString(estudiante))
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(3)))
			.andExpect(jsonPath("$.nombre", is("Maria")))
			.andExpect(jsonPath("$.telefono", is("0987654321")));

		/**
		 * Comprobamos que se haya actualizado
		 */
		mvc.perform(get("/getEstudiante/{id}",3).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(3)))
			.andExpect(jsonPath("$.nombre", is("Marcela")))
			.andExpect(jsonPath("$.telefono", is("0987654321")));
	}

	@Test
	@DisplayName("eliminar estudiante 4")
	public void deleteEstudianteTest() throws Exception{
		mvc.perform(delete("/deleteEstudiante/{id}", 4)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(4)))
			.andExpect(jsonPath("$.nombre", is("Pepito")))
			.andExpect(jsonPath("$.telefono", is("1234567890")));

		mvc.perform(get("/getEstudiantes").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(3)));
	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
