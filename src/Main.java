import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Exercicio;
import model.Instrutor;
import model.Matricula;
import model.Treino;
import model.Usuario;
import model.LimparConsole;
import util.ArquivoUtil;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        Usuario usuario = new Usuario("calvin", "123");

        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        ArrayList<Treino> treinos = new ArrayList<>();
        ArrayList<Matricula> matriculas = new ArrayList<>();

        int tentativas = 0;
        boolean autenticado = false;

        while (!autenticado) {
            System.out.print("Login: ");
            String loginDigitado = ler.nextLine();

            System.out.print("Senha: ");
            String senhaDigitada = ler.nextLine();

            if (usuario.validarLogin(loginDigitado, senhaDigitada)) {
                autenticado = true;

                System.out.println("\nLogin realizado com sucesso!");
            } else {
                tentativas++;

                System.out.println("\nLogin ou senha inválidos.");
                if (tentativas == 3) {

                    System.out.println("\nVocê excedeu o limite de tentativas.");
                    boolean senhaAlterada = false;

                    while (!senhaAlterada) {

                        System.out.print("Digite uma nova senha: ");

                        String novaSenha = ler.nextLine();

                        senhaAlterada = usuario.trocarSenha(novaSenha);

                        if (!senhaAlterada) {

                            System.out.println("A senha já foi utilizada nas últimas 3 trocas.");
                        }
                    }

                    System.out.println("Senha alterada com sucesso.");

                    tentativas = 0;
                }
            }
        }

        int opcao;

        do {

            LimparConsole.limpar();

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Cadastrar Instrutor");
            System.out.println("4 - Listar Instrutores");
            System.out.println("5 - Criar Treino");
            System.out.println("6 - Criar Matrícula");
            System.out.println("7 - Relatório Geral");
            System.out.println("8 - Excluir alunos");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = ler.nextInt();

            switch (opcao) {

                case 1:

                    ler.nextLine();

                    System.out.print("Nome: ");
                    String nome = ler.nextLine();

                    System.out.print("CPF: ");
                    String cpf = ler.nextLine();

                    System.out.print("Idade: ");
                    int idade = ler.nextInt();

                    ler.nextLine();

                    System.out.print("Objetivo: ");
                    String objetivo = ler.nextLine();

                    System.out.print("Plano: ");
                    String plano = ler.nextLine();

                    Aluno aluno = new Aluno(nome, cpf, idade, objetivo, plano);

                    alunos.add(aluno);

                    ArquivoUtil.salvar("arquivos/alunos.txt", aluno.toString());

                    System.out.println("\nAluno cadastrado com sucesso!");

                    break;

                case 2:

                    if (alunos.isEmpty()) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {
                        System.out.println("\n===== LISTA DE ALUNOS =====");
                        for (Aluno a : alunos) {
                            System.out.println(a);
                            System.out.println("-------------------");
                        }
                    }
                    ler.nextLine();

                    break;

                case 3:

                    ler.nextLine();

                    System.out.print("Nome: ");
                    String nomeInstrutor = ler.nextLine();

                    System.out.print("CPF: ");
                    String cpfInstrutor = ler.nextLine();

                    System.out.print("Idade: ");
                    int idadeInstrutor = ler.nextInt();

                    ler.nextLine();

                    System.out.print("Especialidade: ");
                    String especialidade = ler.nextLine();

                    Instrutor instrutor = new Instrutor(nomeInstrutor, cpfInstrutor, idadeInstrutor, especialidade);

                    instrutores.add(instrutor);

                    ArquivoUtil.salvar("arquivos/instrutores.txt", instrutor.toString());

                    System.out.println("\nInstrutor cadastrado com sucesso!");

                    break;

                case 4:

                    if (instrutores.isEmpty()) {

                        System.out.println("\nNenhum instrutor cadastrado.");

                    } else {
                        System.out.println("\n===== LISTA DE INSTRUTORES =====");

                        for (Instrutor i : instrutores) {
                            System.out.println(i);
                            System.out.println("-------------------");
                        }
                    }
                    ler.nextLine();

                    break;

                case 5:

                    ler.nextLine();

                    System.out.print("Nome do treino: ");
                    String nomeTreino = ler.nextLine();

                    Treino treino = new Treino(nomeTreino);

                    System.out.print("Quantos exercícios? ");
                    int quantidade = ler.nextInt();

                    ler.nextLine();

                    for (int i = 0; i < quantidade; i++) {

                        System.out.println("\nExercício " + (i + 1));

                        System.out.print("Nome: ");
                        String nomeExercicio = ler.nextLine();

                        System.out.print("Séries: ");
                        int series = ler.nextInt();

                        System.out.print("Repetições: ");
                        int repeticoes = ler.nextInt();

                        ler.nextLine();

                        Exercicio exercicio = new Exercicio(
                                nomeExercicio,
                                series,
                                repeticoes);

                        treino.adicionarExercicio(exercicio);
                    }

                    treinos.add(treino);

                    System.out.println("\nTreino criado com sucesso!");

                    break;

                case 6:

                    if (alunos.isEmpty()) {
                        System.out.println("\nCadastre um aluno primeiro.");

                        break;
                    }

                    if (instrutores.isEmpty()) {
                        System.out.println("\nCadastre um instrutor primeiro.");

                        break;
                    }

                    if (treinos.isEmpty()) {
                        System.out.println("\nCadastre um treino primeiro.");

                        break;
                    }

                    Matricula matricula = new Matricula(
                            alunos.get(0),
                            instrutores.get(0),
                            treinos.get(0));

                    matriculas.add(matricula);

                    ArquivoUtil.salvar("arquivos/matriculas.txt", matricula.toString());

                    System.out.println("\nMatrícula criada com sucesso!");

                    ler.nextLine();
                    break;

                case 7:

                    if (matriculas.isEmpty()) {
                        System.out.println("\nNenhuma matrícula cadastrada.");

                    } else {
                        System.out.println("\n===== RELATÓRIO GERAL =====");

                        for (Matricula m : matriculas) {

                            System.out.println(m);

                            System.out.println("========================");
                        }
                    }

                    ler.nextLine();
                    break;

                case 8:

                    if (alunos.isEmpty()) {
                        System.out.println("\nNenhum aluno cadastrado.");
                        ler.nextLine();

                        break;
                    }

                    ler.nextLine();

                    System.out.print("Digite o nome do aluno: ");
                    String nomeExcluir = ler.nextLine();

                    Aluno alunoRemover = null;

                    for (Aluno a : alunos) {

                        if (a.getNome().equalsIgnoreCase(nomeExcluir)) {
                            alunoRemover = a;
                            break;
                        }
                    }

                    if (alunoRemover != null) {

                        alunos.remove(alunoRemover);

                        System.out.println("\nAluno removido com sucesso!");

                    } else {
                        System.out.println("\nAluno não encontrado.");
                        ler.nextLine();
                    }

                    ler.nextLine();

                    break;

                case 0:
                    ler.nextLine();
                    LimparConsole.limpar();
                    System.out.println("Encerrando sistema...");

                    break;

                default:
                    System.out.println("Opção inválida.");
            }
            ler.nextLine();

        } while (opcao != 0);

        ler.close();
    }
}