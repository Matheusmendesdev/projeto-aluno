package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login: ");
		String senha = JOptionPane.showInputDialog("informe a senha: ");
		
		if (login.equalsIgnoreCase("Admin") && senha.equalsIgnoreCase("Admin")) {
			
			List<Aluno> alunos = new ArrayList<>();
			
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
			
			for (int qnt = 1; qnt <= 5; qnt++) {
				
				String nome = JOptionPane.showInputDialog("Nome: ");
				String idade = JOptionPane.showInputDialog("Idade: ");
				String dataNascimento = JOptionPane.showInputDialog("Data de nascimento: ");
				
				Aluno aluno1 = new Aluno();
				
				aluno1.setNome(nome);
				aluno1.setIdade(Integer.valueOf(idade));
				aluno1.setDataNascimento(dataNascimento);
				
				for (int pos = 1; pos <= 1; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina" + pos + ": ");
					String nomeNota = JOptionPane.showInputDialog("Nota da disciplina" + pos + ": ");
					
					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(nomeNota));
					
					aluno1.getDisciplinas().add(disciplina);
				}
				
				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");
				
				if (escolha == 0) {
					
					int escolherContinuar = 0;
					int posicao = 1;
					while (escolherContinuar == 0) {
						String removerDisciplina = JOptionPane.showInputDialog("Disciplina 1, 2, 3 ou 4 ?");
						aluno1.getDisciplinas().remove(Integer.valueOf(removerDisciplina).intValue() - posicao);
						posicao++;
						escolherContinuar = JOptionPane.showConfirmDialog(null, "Continuar a escolher?");
						
					}
				}
				
				alunos.add(aluno1);
			}
			
			maps.put(StatusAluno.APROVADO, new ArrayList<>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<>());
			
			for (Aluno aluno : alunos) {
				if (aluno.getAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else if (aluno.getAprovado().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
				
				/*
				 * for (int pos = 0; pos < alunos.size(); pos++) { Aluno aluno =
				 * alunos.get(pos);
				 * 
				 * if (aluno.getNome().equalsIgnoreCase("Matheus")) { Aluno trocar = new
				 * Aluno(); trocar.setNome("Aluno trocado"); trocar.setIdade(99);
				 * trocar.setDataNascimento("Trocado");
				 * 
				 * Disciplina discTroca = new Disciplina();
				 * discTroca.setDisciplina("Disciplina trocada"); discTroca.setNota(99);
				 * 
				 * trocar.getDisciplinas().add(discTroca);
				 * 
				 * alunos.set(pos, trocar); aluno = alunos.get(pos); }
				 * 
				 * System.out.println("Nome do aluno: " + aluno.getNome());
				 * System.out.println("Média do aluno: " + aluno.getMediaNota());
				 * System.out.println("Status de aprovação : " + aluno.getAprovado());
				 * 
				 * for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) { Disciplina
				 * disc = aluno.getDisciplinas().get(posd); System.out.println("Disciplina: " +
				 * disc.getDisciplina() + ", Nota: " + disc.getNota());
				 * 
				 * System.out.println("-------------------------------------------------"); }
				 */
			}
			System.out.println("-----------Aprovados------------");
			for (Aluno aluno1 : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Nome aluno aprovado: " + aluno1.getNome() + " com média de " + aluno1.getMediaNota());
			}
			System.out.println("-----------Recuperação2------------");
			for (Aluno aluno1 : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Nome aluno recuperação: " + aluno1.getNome() + " com média de " + aluno1.getMediaNota());
			}
			System.out.println("-----------Reprovados------------");
			for (Aluno aluno1 : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Nome aluno reprovados: " + aluno1.getNome() + " com média de " + aluno1.getMediaNota());
			}
		}
		
	}

}
