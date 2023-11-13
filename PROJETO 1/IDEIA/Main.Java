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
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("BEM VINDO AO JOGA.BET:");
		System.out.println("Primeiramente crie o evento:");
	
			Administrador admin = new Administrador("luiz gustavo", 1234);

	        System.out.print("Nome do Administrador:  ");
	        String nomeAdm = sc.nextLine();
	        System.out.print("Senha:  ");
	        int senha = sc.nextInt();
	        sc.nextLine();
	       
	        if (nomeAdm.equals(admin.getNome()) && senha == admin.getSenha()) {
	        	char continuar = 's';
	        	
	        	while(continuar == 's') {
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
	 	            
	 	            Evento evento = new Evento(equipe1, equipe2, data, local);
	 	            
	 	            admin.adicionarEvento(evento);
	 	            
	 	            System.out.println("Evento criado com sucesso!");
	 	            
	 	            System.out.println();
	 	            
	 	            System.out.println(admin);
	 	            
	 	            System.out.println();
	 	            
	 	            System.out.print("Deseja criar outro evento? (s/n): ");
	 	            continuar= sc.next().charAt(0);
	 	            sc.nextLine();
	        	} 
	        	if(continuar == 'n') {
	        		System.out.println("MENU:");
	        		System.out.println("1 - fazer cadastro e deposito");
	        		System.out.println("2 - fazer aposta");
	        		System.out.println("3 - fazer um saque");
	        		System.out.println("4 - Ver historico");
	        		System.out.println("5 - Sair");
	        		
	        		System.out.print("Escolha uma opção: ");
	        		int opcao = sc.nextInt();
	        		
	        		if(opcao == 1) {
	        			System.out.print("Digite seu nome: ");
	        			String name = sc.next();

	        			System.out.print("Digite seu email: ");
	        			String email = sc.next();

	        			System.out.print("Data de nascimento (dd/MM/yyyy): ");
	        			Date data = sdf.parse(sc.next());

	        			System.out.print("Digite quanto você quer depositar: ");
	        			double carteira = sc.nextDouble();

	        			Usuario usu = new Usuario(name, email, data, carteira);
	        			
	        			System.out.println();
	        			System.out.println("Cadastro e depósito feitos!");
	        			System.out.println(usu);
	        		}
	        	}
	          
	        }
	        sc.close();
		}	        	    
}
	
