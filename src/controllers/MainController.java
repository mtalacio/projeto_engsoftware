package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import engsoftware.Admin;
import engsoftware.Autenticador;

@Controller
public class MainController {

	@RequestMapping("/")
	public String Entrar() {
		System.out.println("Ok");
		return("main");
	}
	
	@RequestMapping("/login")
	public String RequestLogin() {
		return "login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String EfetuaLogin(Admin a, HttpSession session) {
		if(Autenticador.Autenticar(a)) {
			session.setAttribute("usuarioLogado", true);
			return "main";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
}
