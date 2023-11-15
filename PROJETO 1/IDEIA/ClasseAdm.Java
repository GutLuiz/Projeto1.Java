package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
		private String nome;
		private int senha;
		
		private List<Evento> evento = new ArrayList<>();
		
		public Administrador() {
		}

		public Administrador(String nome, int senha) {
			this.nome = nome;
			this.senha = senha;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getSenha() {
			return senha;
		}

		public void setSenha(int senha) {
			this.senha = senha;
		}

		public List<Evento> getEvento() {
			return evento;
		}
		public void adicionarEvento(Evento event) {
		     evento.add(event);
		}

		 public void removerEvento(Evento event) {
		     evento.remove(event);
		}
		 
		public Evento obterEventoPorId(int id) {
			for(Evento evento : evento) {
				if(evento.getId() == id) {
					return evento;
				}
			}
			return null;
		}

		public String toString() {
			StringBuilder event = new StringBuilder();
			event.append("Evento esportivo:  \n");
			event.append("Administrador responsavel pela criação do evento: " + nome + "\n");
			
			for(Evento jogo : evento) {
				event.append("PARTIDA: " + jogo.getEquipe1().getNome() + "(" + jogo.getEquipe1().getOdd() + ") ");
				event.append("x ");
				event.append(jogo.getEquipe2().getNome() + "(" + jogo.getEquipe2().getOdd() + ")\n");
				event.append("DATA DA PARTIDA: " + sdf.format(jogo.getData()) + "\n");
				event.append("LOCAL DA PARTIDA : " + jogo.getLocal());
			}
			return event.toString();
		}
		
		
		
		
		
		
		
		
		
}
