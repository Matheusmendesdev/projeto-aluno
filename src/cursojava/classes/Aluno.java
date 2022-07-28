package cursojava.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cursojava.constantes.StatusAluno;

public class Aluno {

	private String nome;
	private int idade;
	private String dataNascimento;

	private List<Disciplina> disciplinas = new ArrayList();

	public Aluno() {

	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getMediaNota() {
		double media = 0.0;
		
		for (Disciplina disciplina : disciplinas) {
			media += disciplina.getNota() / disciplinas.size();
		}
		return media;
	}

	public String getAprovado() {
		double media = this.getMediaNota();
		if (media >= 50) {
			if(media >= 70) {
				return StatusAluno.APROVADO;
			}else {
				return StatusAluno.RECUPERACAO;
			}
		} else {
			return StatusAluno.REPROVADO;
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", "
				+ ""
				+ disciplinas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, disciplinas, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(disciplinas, other.disciplinas)
				&& idade == other.idade && Objects.equals(nome, other.nome);
	}

	

}
