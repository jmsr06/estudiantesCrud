package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class EstudianteServiceStub {

	private static HashMap<Long, Estudiante> Estudiantes = new HashMap<>();
	private static Long index = 3L;

	static {
		Estudiantes.put(1L, new Estudiante(1L, "Jenny", "3192996631", 2171455L));
		Estudiantes.put(2L, new Estudiante(2L, "Marcela", "3232335276", 2170987L));
		Estudiantes.put(3L, new Estudiante(3L, "Santiago", "3204877763", 2178654L));
	}

	public static ArrayList<Estudiante> getAllEstudiantes() {
		return new ArrayList<>(Estudiantes.values());
	}

	public static Estudiante getEstudiante(Long id) {
		return Estudiantes.get(id);
	}

	public static Estudiante addEstudiante(Estudiante Estudiante) {
		index += 1;
		Estudiante.setId(index);
		Estudiantes.put(index, Estudiante);
		return Estudiante;
	}

	public static Estudiante updateEstudiante(Long id, Estudiante Estudiante) {
		Estudiante.setId(id);
		Estudiantes.put(id, Estudiante);
		return Estudiante;
	}

	public static Estudiante deleteEstudiante(Long id) {
		return Estudiantes.remove(id);
	}
}
