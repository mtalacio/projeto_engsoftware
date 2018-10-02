package engsoftware;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	public Politico(String nome, String sobrenome, Cargos cargo, long inscricaoEleitoral) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.inscricaoEleitoral = inscricaoEleitoral;
	}
	
	public Politico() {};
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
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

	public void setInscricaoEleitoral(long inscricaoEleitoral) {
		this.inscricaoEleitoral = inscricaoEleitoral;
	}

	public int getId() {
		return id;
	}

}
 