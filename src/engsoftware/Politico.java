package engsoftware;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.sql.Insert;

import customexceptions.MatriculaInvalidaException;
import customexceptions.NomeInvalidoException;

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
	//private ArrayList<Projeto> projetos;
	
	private String formacaoAcademica;
	private LocalDate dataFormacaoAcademica;
	private String instituicaoAcademica;
	
	public Politico() {
		
	}
	
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public LocalDate getDataFormacaoAcademica() {
		return dataFormacaoAcademica;
	}

	public void setDataFormacaoAcademica(LocalDate dataFormacaoAcademica) {
		this.dataFormacaoAcademica = dataFormacaoAcademica;
	}

	public String getInstituicaoAcademica() {
		return instituicaoAcademica;
	}

	public void setInstituicaoAcademica(String instituicaoAcademica) {
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

	public Politico(String nome, String sobrenome, String apelido, String email, String cpf, LocalDate dataNascimento,
			Cargos cargo, Partidos partido, Orgaos orgao, Estados estado, long inscricaoEleitoral,
			String formacaoAcademica, LocalDate dataFormacaoAcademica, String instituicaoAcademica) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
		this.partido = partido;
		this.orgao = orgao;
		this.estado = estado;
		this.inscricaoEleitoral = inscricaoEleitoral;
		this.formacaoAcademica = formacaoAcademica;
		this.dataFormacaoAcademica = dataFormacaoAcademica;
		this.instituicaoAcademica = instituicaoAcademica;
		
		Inserir(this);
	}

}
 