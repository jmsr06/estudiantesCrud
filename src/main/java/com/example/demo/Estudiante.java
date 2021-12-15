package com.example.demo;

public class Estudiante {
	private Long id;
	private String nombre;
	private String telefono;
	private Long codigo;

	public Estudiante() {
	}

	public Estudiante(Long id, String nombre, String telefono, Long codigo) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getcodigo() {
		return codigo;
	}

	public void setcodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String gettelefono() {
		return telefono;
	}

	public void settelefono(String telefono) {
		this.telefono = telefono;
	}
}
