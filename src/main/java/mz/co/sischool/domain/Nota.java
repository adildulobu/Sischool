package mz.co.sischool.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double teste1;
	private double teste2;
	private double teste3;
	@ManyToOne
	@JoinColumn(name="estudante_id")
	private Estudante estudante;
	private String disciplina;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTeste1() {
		return teste1;
	}
	public void setTeste1(double teste1) {
		this.teste1 = teste1;
	}
	public double getTeste2() {
		return teste2;
	}
	public void setTeste2(double teste2) {
		this.teste2 = teste2;
	}
	public double getTeste3() {
		return teste3;
	}
	public void setTeste3(double teste3) {
		this.teste3 = teste3;
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
