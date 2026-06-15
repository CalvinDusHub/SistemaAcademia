import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Instrutor;
import model.Matricula;
import model.Treino;
import model.Usuario;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        Usuario usuario = new Usuario(
                "calvin",
                "123");

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

            if (usuario.validarLogin(
                    loginDigitado,
                    senhaDigitada)) {

                autenticado = true;

                System.out.println(
                        "\nLogin realizado com sucesso!");

            } else {

                tentativas++;

                System.out.println(
                        "\nLogin ou senha inválidos.");

                if (tentativas == 3) {

                    System.out.println(
                            "\nVocê excedeu o limite de tentativas.");

                    boolean senhaAlterada = false;

                    while (!senhaAlterada) {

                        System.out.print(
                                "Digite uma nova senha: ");

                        String novaSenha = ler.nextLine();

                        senhaAlterada = usuario.trocarSenha(
                                novaSenha);

                        if (!senhaAlterada) {

                            System.out.println(
                                    "A senha já foi utilizada nas últimas 3 trocas.");
                        }
                    }

                    System.out.println(
                            "Senha alterada com sucesso.");

                    tentativas = 0;
                }
            }
        }

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Cadastrar Instrutor");
            System.out.println("4 - Listar Instrutores");
            System.out.println("5 - Criar Treino");
            System.out.println("6 - Criar Matrícula");
            System.out.println("7 - Relatório Geral");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = ler.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println(
                            "Cadastrar aluno");
                    break;

                case 2:
                    System.out.println(
                            "Listar alunos");
                    break;

                case 3:
                    System.out.println(
                            "Cadastrar instrutor");
                    break;

                case 4:
                    System.out.println(
                            "Listar instrutores");
                    break;

                case 5:
                    System.out.println(
                            "Criar treino");
                    break;

                case 6:
                    System.out.println(
                            "Criar matrícula");
                    break;

                case 7:
                    System.out.println(
                            "Relatório geral");
                    break;

                case 0:
                    System.out.println(
                            "Encerrando sistema...");
                    break;

                default:
                    System.out.println(
                            "Opção inválida.");
            }

        } while (opcao != 0);

        ler.close();
    }
}