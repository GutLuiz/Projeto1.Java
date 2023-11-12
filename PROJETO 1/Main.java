package curso_programacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Administrador;
import entities.Aposta;
import entities.Evento;
import entities.Usuario;

public class Main {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		  Administrador admin = new Administrador("luiz gustavo", 1234);

	        System.out.print("Nome do Administrador: ");
	        String nomeAdm = sc.nextLine();
	        System.out.print("Senha: ");
	        int senha = sc.nextInt();
	        sc.nextLine();
	       
	        if (nomeAdm.equals(admin.getNome()) && senha == admin.getSenha()) {
	            System.out.print("Equipe 1: ");
	            String equipe1 = sc.nextLine();
	            System.out.print("Equipe 2: ");
	            String equipe2 = sc.nextLine();
	            System.out.print("Data: ");
	            Date data = sdf.parse(sc.next());
	            sc.nextLine();
	            System.out.print("Local: ");
	            String local = sc.nextLine();
		
	            Evento evento = new Evento();
	            evento.setEquipe1(equipe1);
	            evento.setEquipe2(equipe2);
	            evento.setData(data);
	            evento.setLocal(local);
	            
	            admin.adicionarEvento(evento);

	            System.out.println("Evento criado com sucesso!");
	            
	            System.out.println();
		        
		        System.out.println(admin);
		        
		        System.out.println();
		        
		        System.out.println("Antes de voce fazer a sua aposta, Se cadastre e faça seu deposito incial: ");
		        
		        System.out.print("Digite seu nome: ");
		        String nome = sc.nextLine();
		        System.out.print("Digite seu email: ");
		        String email = sc.nextLine();
		        System.out.print("Digite sua data de nascimento: ");
		        Date date = sdf.parse(sc.next());
		        System.out.print("Quanto voce quer depositar: ");
		        double saldo = sc.nextDouble();
		        System.out.println("Cadastro e depósito realizados com sucesso!");
		        
		        Usuario usu = new Usuario(nome, email, date, saldo);
		        
		        System.out.println();
		        
		        System.out.println(usu);
		        
		        System.out.print("Digite o nome da equipe em que deseja apostar: ");
		        String equipeAposta = sc.next().toLowerCase();
		   
		        if (equipeAposta.equals(evento.getEquipe1().toLowerCase()) || equipeAposta.equals(evento.getEquipe2().toLowerCase())) {
		        	System.out.print("Digite o valor da aposta que voce quer fazer: ");
		        	double valorAposta = sc.nextDouble();
		           
		            if (valorAposta <= 0) {
		                System.out.println("O valor da aposta deve ser maior que zero. Tente novamente.");
		            } else if (valorAposta > usu.getSaldo()) {
		                System.out.println("Saldo insuficiente. Você não pode fazer uma aposta com um valor maior que seu saldo.");
		            } else {
		            	
		            	
		            Aposta aposta = new Aposta(equipeAposta, valorAposta);
		            
		                System.out.println("Aposta realizada com sucesso!");
		                
		                System.out.println();
		                
		                
		               // usu.saldo(100.0);
		              //  System.out.println("Parabéns, você ganhou um bônus de R$ 100 por mudar de idade!");
		                
		              //  System.out.println("PARABENS, VOCE GANHOU UM BÔNUS DE R$100,00!, seu saldo agora é de" 
		                
		           
		            }
		        } else {
		            System.out.println("Nome da equipe inválido. A aposta não pôde ser realizada.");
		        }

		        
	        } 
	        else {
	            System.out.println("Nome de usuário ou senha incorretos. Acesso negado.");
	        }
	        
	        
	        
	      
	        
	        
	        sc.close();
 	   }
	}

	
