package com.bolsadeideas.springboot.web.app.models;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	//para generar getter y setter click derecho en espacio vacio y luego source despues generar getter..
	
	
	//para generar constructor click derecho source generate constructor using field
	public Usuario(String nombre, String apellido, String email) {//constructor
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	
	public Usuario() {//otro constructor
		
	}


	//geter y seters abajo
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
