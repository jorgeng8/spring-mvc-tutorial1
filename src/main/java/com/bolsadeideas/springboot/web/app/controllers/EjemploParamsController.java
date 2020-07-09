package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//ctrl+espacio para invocar
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")//importar mouse+ seleccionar
	public String param(@RequestParam(name="texto", required=false, defaultValue="algun valor") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es:"+texto);
		return("params/ver");//invicar archivo carpeta y html de template
	}
	
	@GetMapping("/mix-params")//importar mouse+ seleccionar
	public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es:'"+saludo+"'y el numero es:'"+numero+"'");
		return("params/ver");//invicar archivo carpeta y html de template
	}
	
	@GetMapping("/mix-params-request")//importar mouse+ seleccionar
	public String param(HttpServletRequest request, Model model) {
		String saludo=request.getParameter("saludo");
		Integer numero=null;//nulo por defecto
		try {
		numero=Integer.parseInt(request.getParameter("numero"));//convierte string en integer
		}catch (NumberFormatException e){//si no es un numero o no cumple el formato
			numero=0;
		}
		model.addAttribute("resultado", "El saludo enviado es:'"+saludo+"'y el numero es:'"+numero+"'");
		return("params/ver");//invicar archivo carpeta y html de template
	}


}
