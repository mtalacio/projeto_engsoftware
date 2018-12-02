package core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import politicoexceptions.CpfInvalidoException;
import politicoexceptions.DataInvalidaException;
import politicoexceptions.EmailInvalidoException;
import politicoexceptions.FormacaoAcademicaInvalida;
import politicoexceptions.InstituicaoAcademicaInvalida;
import politicoexceptions.MatriculaInvalidaException;
import politicoexceptions.NomeInvalidoException;

@Entity
public class Politico extends Database {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String sobrenome;
	private String apelido;
	private String email;
	private String cpf;
	private LocalDate dataNascimento; 
	
	@Enumerated
	@Column(columnDefinition = "smallint")
	private Cargos cargo;
	@Enumerated
	@Column(columnDefinition = "smallint")
	private Partidos partido;
	@Enumerated
	@Column(columnDefinition = "smallint")
	private Orgaos orgao;
	@Enumerated
	@Column(columnDefinition = "smallint")
	private Estados estado;
	private long inscricaoEleitoral;
	
	private String formacaoAcademica;
	private LocalDate dataFormacaoAcademica;
	private String instituicaoAcademica;
	
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailInvalidoException {
		if(email.length() < 5 || email == null)
			throw new EmailInvalidoException();
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws CpfInvalidoException {
		if(cpf.length() < 0 || cpf == null)
			throw new CpfInvalidoException();
		this.cpf = cpf;
	}
	
	private LocalDate converterData(String data) throws DateTimeParseException {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			return LocalDate.parse(data, f);
		} catch (DateTimeParseException e) {
			throw e;
		}
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws DateTimeParseException {
		try {
			this.dataNascimento = converterData(dataNascimento);
		} catch (DateTimeParseException e) {
			throw new DataInvalidaException("Data de Nascimento Inválida (dd/mm/aaaa)", e);
		}
	}

	public Partidos getPartido() {
		return partido;
	}

	public void setPartido(Partidos partido) {
		this.partido = partido;
	}

	public Orgaos getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgaos orgao) {
		this.orgao = orgao;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacaoAcademica) throws FormacaoAcademicaInvalida {
		if(formacaoAcademica.length() <= 0 || formacaoAcademica == null || formacaoAcademica.length() > 200)
			throw new FormacaoAcademicaInvalida();
		this.formacaoAcademica = formacaoAcademica;
	}

	public LocalDate getDataFormacaoAcademica() {
		return dataFormacaoAcademica;
	}

	public void setDataFormacaoAcademica(String dataFormacaoAcademica) throws DataInvalidaException {
		try {
			this.dataFormacaoAcademica = converterData(dataFormacaoAcademica);
		} catch (DateTimeParseException e) {
			throw new DataInvalidaException("Data de Formação Inválida (dd/mm/aaaa)", e);
		}
	}

	public String getInstituicaoAcademica() {
		return instituicaoAcademica;
	}

	public void setInstituicaoAcademica(String instituicaoAcademica) throws InstituicaoAcademicaInvalida {
		if(instituicaoAcademica.length() <= 0 || instituicaoAcademica == null || instituicaoAcademica.length() > 200)
			throw new InstituicaoAcademicaInvalida();
		this.instituicaoAcademica = instituicaoAcademica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		if(nome.length() < 5 || nome == null || nome.length() == 0) {
			throw new NomeInvalidoException();
		}
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) throws NomeInvalidoException {
		if(sobrenome.length() < 5 || sobrenome == null || sobrenome.length() == 0) {
			throw new NomeInvalidoException();
		}
		
		this.sobrenome = sobrenome;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	public long getInscricaoEleitoral() {
		return inscricaoEleitoral;
	}

	public void setInscricaoEleitoral(long inscricaoEleitoral) throws MatriculaInvalidaException {
		if(inscricaoEleitoral < 0) {
			throw new MatriculaInvalidaException();
		}
		this.inscricaoEleitoral = inscricaoEleitoral;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Politico(String nome, String sobrenome, String apelido, String email, String cpf, String dataNascimento,
			Cargos cargo, Partidos partido, Orgaos orgao, Estados estado, long inscricaoEleitoral,
			String formacaoAcademica, String dataFormacaoAcademica, String instituicaoAcademica, boolean persist) 
					throws NomeInvalidoException, EmailInvalidoException, CpfInvalidoException, MatriculaInvalidaException, 
					FormacaoAcademicaInvalida, InstituicaoAcademicaInvalida, DateTimeParseException {
		setNome(nome);
		setSobrenome(sobrenome);
		setApelido(apelido);;
		setEmail(email);
		setCpf(cpf);
		this.cargo = cargo;
		this.partido = partido;
		this.orgao = orgao;
		this.estado = estado;
		setInscricaoEleitoral(inscricaoEleitoral);
		setFormacaoAcademica(formacaoAcademica);
		setInstituicaoAcademica(instituicaoAcademica);
		setDataNascimento(dataNascimento);
		setDataFormacaoAcademica(dataFormacaoAcademica);
		
		if(persist)
			Inserir(this);
	}

	public Politico() {}
}
 