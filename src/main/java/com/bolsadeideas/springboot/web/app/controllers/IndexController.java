package com.bolsadeideas.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller //ctrl + espacio para invocar
@RequestMapping("/app") //define el primer nivel de la ruta

public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")//toma los valores de application.properties
	private String textoIndex;
	
	@Value("${texto.indexcontroller.index.listar}")//inyeccion de dependencias
	private String textoListar;
	
	@Value("${texto.indexcontroller.index.perfil}")//si no reconoce la sintaxis borrar la carpeta aplication.properties y crear nueva
	private String textoPerfil;
	
	@GetMapping(value = {"/index", "/","","/home"}) // define todas las rutas de segundo nivel
	public String index(Model model) {//importar el modelo solo acercando el mouse y despues click
		model.addAttribute("titulo", "hola spring framework");//importar addatribute
		return "index";
	}
	
	@RequestMapping("/perfil")// es get por defecto no post llama al archivo perfil.html
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();//importar desde Usuario.java
		usuario.setNombre("jorge");
		usuario.setApellido("ng");
		usuario.setEmail("jorge@nose.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "perfil del usuario".concat(usuario.getNombre()));
		return "perfil";//al llamar retorno este
	}
	
	//los datos estaran disponibles solo para esta ruta o vista
	@RequestMapping("/listar")// es get por defecto no post llama al archivo perfil.html
	public String listar(Model model) {
		
		model.addAttribute("titulo",textoListar);//textoListar invocado desde inyecccion de dependencias
		
		return("listar");
	}
	
	@ModelAttribute("usuarios")//los datos estaran disponibles en todas las rutas o vistas
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("juan","martinez","a@mn.com"),
				new Usuario("victor","perez","hha@mn.com"),
				new Usuario("manuel","fernandez","ak@mn.com")
				);
		return usuarios;//retorna cuando lo llama
	}
	
}
