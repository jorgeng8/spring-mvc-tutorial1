package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
		@GetMapping("/")//ruta por defecto
		public String home() {
			return "redirect:/app/index";//redirige a la ruta absoluta
			//forward tambien pero no se muestra la ruta, ideal para paginas de inicio
		}
}
