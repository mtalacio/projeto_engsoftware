package engsoftware;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import customexceptions.MatriculaInvalidaException;
import customexceptions.NomeInvalidoException;

@Entity
public class Politico {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String sobrenome;
	
	@Enumerated
	@Column(columnDefinition = "smallint")
	private Cargos cargo;
	private long inscricaoEleitoral;
	//private ArrayList<Projeto> projetos;
	
	public Politico(String nome, String sobrenome, Cargos cargo, long inscricaoEleitoral) 
			throws NomeInvalidoException, MatriculaInvalidaException {
		setNome(nome);
		setSobrenome(sobrenome);
		this.cargo = cargo;
		setInscricaoEleitoral(inscricaoEleitoral);
	}
	
	public Politico() {};
	
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

}
 