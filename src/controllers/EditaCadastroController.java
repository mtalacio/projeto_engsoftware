package controllers;

import java.util.List;
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
import core.PoliticoQuery;

@Controller
public class EditaCadastroController {
	
	@RequestMapping("/editaCadastro")
	public String RequestEditar() {
		return "editacadastro";
	}
	
	@RequestMapping(value = "/seleceditar", method = RequestMethod.GET)
	public String PesquisaEditar(@RequestParam Map<String, String> paramMap, Model m) {
		
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
				System.out.println("Numero recebido � inv�lido");
				m.addAttribute("feedback", "Matr�cula Inv�lida");
			}
		} else {
			System.out.println("Pesquisa Vazia");
			m.addAttribute("feedback", "Pesquise por Sobrenome ou Matr�cula");
		}
		
		return "editacadastro";
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String Editar(@RequestParam Map<String, String> paramMap, Model m) {
		try {
			Politico p = PoliticoQuery.PesquisarPorId(Integer.parseInt(paramMap.get("id")));
			m.addAttribute("p",p);
			return "edicao";
		} catch (NumberFormatException e) {
			System.out.println("Erro ao receber ID para edi��o");
		}
		return "editacadastro";
	}
	
	@RequestMapping(value = "/finalizarEdicao", method = RequestMethod.POST)
	public String FinalizarEdicao(@RequestParam Map<String, String> paramMap, Model m) {
		Cargos cargo;
		try {
			cargo = Cargos.values()[Integer.parseInt(paramMap.get("cargo"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro ao converter cargo");
			m.addAttribute("erro", "Cargo Inv�lido!");
			m.addAttribute("values", paramMap);
			return "edicao";
		} catch (NumberFormatException e) {
			System.out.println("Cargo � um campo obrigat�rio!");
			m.addAttribute("erro", "Cargo � um campo obrigat�rio!");
			m.addAttribute("values", paramMap);
			return "edicao"; 
		}
		
		Partidos partido;
		try {
			partido = Partidos.values()[Integer.parseInt(paramMap.get("partido"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro ao converter partido");
			m.addAttribute("erro", "Partido Inv�lido!");
			m.addAttribute("values", paramMap);
			return "edicao"; 
		} catch (NumberFormatException e) {
			System.out.println("Partido � um campo obrigat�rio!");
			m.addAttribute("erro", "Partido � um campo obrigat�rio!");
			m.addAttribute("values", paramMap);
			return "edicao"; 
		}
		 
		Orgaos orgao;
		try {
			orgao = Orgaos.values()[Integer.parseInt(paramMap.get("orgao"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			m.addAttribute("erro", "Org�o Inv�lido!");
			m.addAttribute("values", paramMap);
			return "edicao";
		} catch (NumberFormatException e) {
			System.out.println("Org�o � um campo obrigat�rio!");
			m.addAttribute("erro", "Org�o � um campo obrigat�rio!");
			m.addAttribute("values", paramMap);
			return "edicao"; 
		}
		
		Estados estado;
		try {
			estado = Estados.values()[Integer.parseInt(paramMap.get("estado"))];
		} catch (ArrayIndexOutOfBoundsException e) {
			m.addAttribute("erro", "Estado Inv�lido!");
			m.addAttribute("values", paramMap);
			return "edicao";
		} catch (NumberFormatException e) {
			System.out.println("Estado � um campo obrigat�rio!");
			m.addAttribute("erro", "Estado � um campo obrigat�rio!");
			m.addAttribute("values", paramMap);
			return "edicao"; 
		}
		
		try {
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
					false);
			p.setId(Integer.parseInt(paramMap.get("id")));
			PoliticoQuery.Atualizar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			m.addAttribute("erro", e.getMessage());
			m.addAttribute("values", paramMap);
			return "edicao";
		} 
		m.addAttribute("feedback", "Editado com Sucesso!");
		return "editacadastro";
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String ExcluirCadastro(@RequestParam Map<String, String> paramMap, Model m) {
		try {
			PoliticoQuery.Excluir(Integer.parseInt(paramMap.get("id")));
			m.addAttribute("feedback", "Cadastro Excluido");
		} catch (NumberFormatException e) {
			System.out.println("Erro ao receber ID para exclus�o");
		}
		return "edicao";
	}
	
}
