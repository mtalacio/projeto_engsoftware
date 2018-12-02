package controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import core.Politico;
import core.PoliticoQuery;

@Controller
public class PesquisaController {
	
	@RequestMapping("/pesquisa")
	public String RequestPesquisa() {
		return "pesquisa";
	} 
	
	@RequestMapping(value = "/pesquisar", method = RequestMethod.GET)
	public String Pesquisar(@RequestParam Map<String, String> paramMap, Model m) {
		
		String sobrenome = paramMap.get("sobrenome");
		String matricula = paramMap.get("matricula");
		if(sobrenome != null && !sobrenome.equals("")) {
			List<Politico> p = PoliticoQuery.PesquisarPorSobrenome(sobrenome);
			m.addAttribute("valores", p);
		} else if (matricula != null && !matricula.equals("")) {
			try {
				long matriculaLong = Long.parseLong(matricula);
				List<Politico> p = PoliticoQuery.PesquisarPorMatricula(matriculaLong);
				m.addAttribute("valores", p);
			} catch (NumberFormatException ex) {
				System.out.println("Numero recebido é inválido");
				m.addAttribute("feedback", "Matrícula Inválida");
			}
		} else {
			System.out.println("Pesquisa Vazia");
			m.addAttribute("feedback", "Pesquise por Sobrenome ou Matrícula");
		}
		
		return "pesquisa";
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String VerPerfil(@RequestParam Map<String, String> paramMap, Model m) {
		try {
			Politico p = PoliticoQuery.PesquisarPorId(Integer.parseInt(paramMap.get("id")));
			m.addAttribute("p",p);
			return "pesquisa";
		} catch (NumberFormatException e) {
			System.out.println("Erro ao receber ID para edição");
		}
		return "pesquisa";
	}
	
}
