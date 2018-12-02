package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import core.Admin;
import core.Autenticador;

@Controller
public class MainController {

	@RequestMapping("/")
	public String Entrar() {
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
			return "painel";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/admin")
	public String PainelAdmin(Model m) {
		return "painel";
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
}
