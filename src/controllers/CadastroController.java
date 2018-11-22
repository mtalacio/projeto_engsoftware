package controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import core.Cargos;
import core.Estados;
import core.Orgaos;
import core.Partidos;
import core.Politico;

@Controller
public class CadastroController {
	
	@RequestMapping("/cadastro")
	public String RequestCadastro() {
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastrar", method=RequestMethod.POST)
	public String Cadastrar(@RequestParam Map<String, String> paramMap, Model m) {
		
		Cargos cargo;
		try {
			cargo = Cargos.values()[Integer.parseInt(paramMap.get("cargo"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro ao converter cargo");
			m.addAttribute("erro", "Cargo Inválido!");
			m.addAttribute("values", paramMap);
			return "cadastro";
		}
		
		Partidos partido;
		try {
			partido = Partidos.values()[Integer.parseInt(paramMap.get("partido"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro ao converter partido");
			m.addAttribute("erro", "Partido Inválido!");
			m.addAttribute("values", paramMap);
			return "cadastro"; 
		}
		 
		Orgaos orgao;
		try {
			orgao = Orgaos.values()[Integer.parseInt(paramMap.get("orgao"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			m.addAttribute("erro", "Orgão Inválido!");
			m.addAttribute("values", paramMap);
			return "cadastro";
		}
		
		Estados estado;
		try {
			estado = Estados.values()[Integer.parseInt(paramMap.get("estado"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			m.addAttribute("erro", "Estado Inválido!");
			m.addAttribute("values", paramMap);
			return "cadastro";
		}
		
		try {
			@SuppressWarnings("unused")
			Politico p = new Politico(
					paramMap.get("nome"), 
					paramMap.get("sobrenome"), 
					paramMap.get("apelido"),
					paramMap.get("email"), 
					paramMap.get("cpf"), 
					paramMap.get("dataNascimento"), 
					cargo, 
					partido, 
					orgao, 
					estado, 
					Long.parseLong(paramMap.get("inscricaoEleitoral")), 
					paramMap.get("formacaoAcademica"), 
					paramMap.get("dataFormacaoAcademica"), 
					paramMap.get("instituicaoAcademica"), 
					true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			m.addAttribute("erro", e.getMessage());
			m.addAttribute("values", paramMap);
		} 
		
		return "cadastrook";
	}
	
}
