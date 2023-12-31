package curso_programacao;

import entities.Administrador;
import entities.Equipe;
import entities.Evento;
import entities.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Usuario usu;
    private static Administrador admin;
    public double valor = 0;
    public double valorTotal = 0;

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        admin = new Administrador("luiz gustavo", 1234);
        System.out.println("BEM VINDO AO JOGA.BET:");

        int opcao = 0;
        boolean exibirMenu = true;

        while (true) {
            try {

                if (exibirMenu) {
                    System.out.println("MENU:");
                    System.out.println("1 - Criar evento");
                    System.out.println("2 - Fazer cadastro e depósito");
                    System.out.println("3 - Fazer aposta");
                    System.out.println("4 - Fazer um saque");
                    System.out.println("5 - Ver seu Saldo");
                    System.out.println("6 - Sair");

                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();
                }

                switch (opcao) {
                    case 1:
                        criarEvento(sc, sdf);
                        break;
                    case 2:
                        fazerCadastroEdeposito(sc, sdf);
                        break;
                    case 3:
                        fazerAposta(sc, admin);
                        break;
                    case 4:
                        fazerUmSaque(sc);
                        break;
                    case 5:
                        verSaldo(sc);
                        break;
                    case 6:
                        System.out.println("Saindo do programa. Até mais!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
                exibirMenu = true;
            } catch (Exception ex) {
                System.out.println("Um erro inesperado aconteceu!");
                sc = new Scanner(System.in);
                exibirMenu = false;
            }
        }
    }

    private static void criarEvento(Scanner sc, SimpleDateFormat sdf) throws ParseException {

        System.out.println("Digite seu login de ADMINISTRADOR:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite sua senha: ");
        int senha = sc.nextInt();

        if ("gustavo".equals(nome) && senha == 1234) {
            char continuar = 's';

            while (continuar == 's') {
                System.out.print("Digite o id dessa partida: ");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.print("Equipe 1: ");
                String nome1 = sc.nextLine();
                System.out.print("Odd da equipe 1: ");
                double odd1 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Equipe 2: ");
                String nome2 = sc.nextLine();
                System.out.print("Odd da equipe 2: ");
                double odd2 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Data: ");
                Date data = sdf.parse(sc.next());
                sc.nextLine();
                System.out.print("Local: ");
                String local = sc.nextLine();

                Equipe equipe1 = new Equipe(nome1, odd1);
                Equipe equipe2 = new Equipe(nome2, odd2);

                Evento evento = new Evento(equipe1, equipe2, data, local, ID);

                admin.adicionarEvento(evento);

                System.out.println("Evento criado com sucesso!");

                System.out.println();

                System.out.println(admin);

                System.out.println();

                System.out.print("Deseja criar outro evento? (s/n): ");
                continuar = sc.next().charAt(0);
                sc.nextLine();
            }
        } else {
            System.out.println("Cadastro do ADM invalido!");
        }

    }

    private static void fazerCadastroEdeposito(Scanner sc, SimpleDateFormat sdf) throws ParseException {
        System.out.print("Digite seu nome: ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("Digite sua senha (somente numeros): ");
        int senha = sc.nextInt();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        Date data = sdf.parse(sc.next());

        System.out.print("Digite quanto você quer depositar: ");
        double carteira = sc.nextDouble();

        usu = new Usuario(name, senha, data, carteira);

        System.out.println();
        System.out.println("Cadastro e depósito feitos!");
        System.out.println(usu);
    }

    private static void fazerAposta(Scanner sc, Administrador admin) {

        System.out.print("Digite o ID do evento esportivo: ");
        int id = sc.nextInt();
        sc.nextLine();

        Evento event = admin.obterEventoPorId(id);

        if (event != null) {
            System.out.print("Digite o nome do time que voce quer apostar: ");
            String timeAposta = sc.nextLine();
            Equipe equipeApostada = null;
            if (timeAposta.equals(event.getEquipe1().getNome())) {
                equipeApostada = event.getEquipe1();
                System.out.print("Digite o valor que voce quer apostar nesse time: ");

                double valor = sc.nextDouble();

                if (valor <= usu.getSaldo()) {
                    double valorTotal = valor * equipeApostada.getOdd();
                    System.out.println("valor total da aposta: " + valorTotal);
                    usu.setSaldo(usu.getSaldo() - valor);
                    System.out.println("BOA SORTE!!!!");
                    System.out.println();

                    System.out.println("Agora vamos saber o resultado do evento, PREPARE - SE:");
                    System.out.print("Digite o Id do evento: ");
                    int idd = sc.nextInt();
                    sc.nextLine();

                    Evento evento = admin.obterEventoPorId(idd);

                    if (evento != null) {
                        Random rand = new Random();

                        double resultado = rand.nextDouble();

                        System.out.println("Resultado do evento:");

                        if (resultado < 0.5) {
                            System.out.println(evento.getEquipe1().getNome() + " venceu!");
                            if (equipeApostada.getNome() == evento.getEquipe1().getNome()) {
                                usu.setSaldo(usu.getSaldo() + valorTotal);
                                System.out.println("Voce venceu a aposta!");
                            }
                        } else {
                            System.out.println(evento.getEquipe2().getNome() + " venceu!");
                            if (equipeApostada.getNome() != evento.getEquipe2().getNome()) {
                                System.out.println("Voce perdeu a aposta!");
                            }

                        }
                    }
                }
            } else if (timeAposta.equals(event.getEquipe2().getNome())) {
                equipeApostada = event.getEquipe2();
                System.out.print("Digite o valor que voce quer apostar nesse time: ");
                double valor = sc.nextDouble();
                if (valor <= usu.getSaldo()) {
                    double valorTotal = valor * equipeApostada.getOdd();
                    System.out.println("valor total da aposta: " + valorTotal);
                    usu.setSaldo(usu.getSaldo() - valor);
                    System.out.println("BOA SORTE!!!!");
                    System.out.println();

                    System.out.println("Agora vamos saber o resultado do evento, PREPARE - SE:");
                    System.out.print("Digite o Id do evento: ");
                    int idd = sc.nextInt();
                    sc.nextLine();

                    Evento evento = admin.obterEventoPorId(idd);

                    if (evento != null) {
                        Random rand = new Random();

                        double resultado = rand.nextDouble();

                        System.out.println("Resultado do evento:");

                        if (resultado < 0.5) {
                            System.out.println(evento.getEquipe1().getNome() + " venceu!");
                            if (equipeApostada.getNome() == evento.getEquipe1().getNome()) {
                                usu.setSaldo(usu.getSaldo() + valorTotal);
                                System.out.println("Voce venceu a aposta!");
                            }
                        } else {
                            System.out.println(evento.getEquipe2().getNome() + " venceu!");
                            if (equipeApostada.getNome() != evento.getEquipe2().getNome()) {
                                System.out.println("Voce perdeu a aposta!");
                            }

                        }
                    }

                } else {
                    System.out.println("Valor invalido, tente novamente!");
                }
            }

        }

    }

    private static void fazerUmSaque(Scanner sc) {
        System.out.print("Digite o valor que você deseja sacar: ");
        double valorSaq = sc.nextDouble();

        if (valorSaq <= usu.getSaldo()) {
            usu.setSaldo(usu.getSaldo() - valorSaq);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    private static void verSaldo(Scanner sc) {
        System.out.println("BEM VINDO!, aqui você consegue ver seu saldo na JOGA.BET!, mas primeiro coloque suas informações de cadastro: ");
        System.out.print("Digite seu nome: ");
        String nomeHist = sc.nextLine();
        System.out.print("Digite sua senha: ");
        int senhaHist = sc.nextInt();

        if (nomeHist.equals(usu.getNome()) && senhaHist == usu.getSenha()) {
            System.out.printf("Seu valor na carteira : %.2f%n", usu.getSaldo());
        } else {
            System.out.println("Cadastro invalido!");
        }
    }

}
