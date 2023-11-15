package curso_programacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Administrador;
import entities.Equipe;
import entities.Evento;
import entities.Usuario;

public class Main {
	private static Usuario usu;
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		Administrador admin = new Administrador("luiz gustavo", 1234);
		
		

		System.out.println("BEM VINDO AO JOGA.BET:");

		while (true) {
			System.out.println("MENU:");
			System.out.println("1 - Criar evento");
			System.out.println("2 - Fazer cadastro e depósito");
			System.out.println("3 - Fazer aposta");
			System.out.println("4 - Fazer um saque");
			System.out.println("5 - Ver histórico");
			System.out.println("6 - Sair");

			System.out.print("Escolha uma opção: ");
			int opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				criarEvento(sc, admin, sdf);
				break;
			case 2:
				fazerCadastroEdeposito(sc, sdf);
				break;
			case 3:
				fazerAposta(sc,admin);
					break;

			case 6:
				System.out.println("Saindo do programa. Até mais!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private static void criarEvento(Scanner sc, Administrador admin, SimpleDateFormat sdf) throws ParseException {
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
	}

	private static void fazerCadastroEdeposito(Scanner sc, SimpleDateFormat sdf) throws ParseException {
		System.out.print("Digite seu nome: ");
		String name = sc.next();
		sc.nextLine();
		System.out.print("Digite seu email: ");
		String email = sc.next();

		System.out.print("Data de nascimento (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());

		System.out.print("Digite quanto você quer depositar: ");
		double carteira = sc.nextDouble();

		usu = new Usuario(name, email, data, carteira);

		System.out.println();
		System.out.println("Cadastro e depósito feitos!");
		System.out.println(usu);
	}
	private static void fazerAposta(Scanner sc, Administrador admin)	{
		System.out.print("Digite o ID do evento esportivo: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Evento event = admin.obterEventoPorId(id);
		
		if(event != null) {
			System.out.print("Digite o nome do time que voce quer apostar: ");
			String timeAposta = sc.nextLine();
			Equipe equipeApostada = null;
				if(timeAposta.equals(event.getEquipe1().getNome())){ 
					equipeApostada = event.getEquipe1();
					System.out.print("Digite o valor que voce quer apostar nesse time: ");
					double valor = sc.nextDouble();
						if(valor <= usu.getSaldo()) {
							double valorTotal = valor * equipeApostada.getOdd();
							System.out.println("valor total da aposta: " + valorTotal);
							 usu.setSaldo(usu.getSaldo() - valor);
							 System.out.println("BOA SORTE!!!!");
							 System.out.println();
						}
				}
				else if (timeAposta.equals(event.getEquipe2().getNome())) {
					equipeApostada = event.getEquipe2();
					System.out.print("Digite o valor que voce quer apostar nesse time: ");
					double valor = sc.nextDouble();
						if(valor <= usu.getSaldo()) {
							double valorTotal = valor * equipeApostada.getOdd();
							System.out.println("valor total da aposta: " + valorTotal);
							 usu.setSaldo(usu.getSaldo() - valor);
							 System.out.println("BOA SORTE!!!!");
							 System.out.println();
						}
						else {
							System.out.println("Valor invalido, tente novamente!");
						}
				}
						
				}
		}
		
		
		
		
	}



