package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EstudianteController {

	@GetMapping("/getEstudiantes")
	public ArrayList<Estudiante> getAllEstudiantes() {
		ArrayList<Estudiante> Estudiantes = EstudianteServiceStub.getAllEstudiantes();
		if(Estudiantes.isEmpty()){
		}
		return Estudiantes;
	}

	@GetMapping("/getEstudiante/{id}")
	public Estudiante getEstudiante(@PathVariable Long id) {
		Estudiante Estudiante = EstudianteServiceStub.getEstudiante(id);
		return Estudiante;
	}

	@PostMapping("/postEstudiante")
	public Estudiante addEstudiante(@RequestBody Estudiante Estudiante) {
		return EstudianteServiceStub.addEstudiante(Estudiante);
	}

	@PutMapping("/putEstudiante/{id}")
	public Estudiante updateEstudiante(@PathVariable long id, @RequestBody Estudiante EstudianteModificado) {
		Estudiante Estudiante = EstudianteServiceStub.getEstudiante(id);
		return EstudianteServiceStub.updateEstudiante(id, EstudianteModificado);
	}

	@DeleteMapping("/deleteEstudiante/{id}")
	public Estudiante deleteEstudiante(@PathVariable long id) {
		Estudiante Estudiante = EstudianteServiceStub.getEstudiante(id);
		return EstudianteServiceStub.deleteEstudiante(id);
	}
}
