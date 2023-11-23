package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Gerenciamento {
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		private List<Evento> eventos = new ArrayList<>();
		
		public Administrador() {
		}

		public Administrador(String nome, int senha) {
			super.setNome(nome);
			super.setSenha(senha);
		}


		public List<Evento> getEvento() {
			return eventos;
		}
		public void adicionarEvento(Evento event) {
		     eventos.add(event);
		}

		 public void removerEvento(Evento event) {
		     eventos.remove(event);
		}
		 
		public Evento obterEventoPorId(int id) {
			for(Evento evento : eventos) {
				if(evento.getId() == id) {
					return evento;
				}
			}
			return null;
		}

		public String toString() {
			StringBuilder event = new StringBuilder();
			event.append("Evento esportivo:  \n");
			for(Evento jogo : eventos) {
				event.append("PARTIDA: " + jogo.getEquipe1().getNome() + "(" + jogo.getEquipe1().getOdd() + ") ");
				event.append("x ");
				event.append(jogo.getEquipe2().getNome() + "(" + jogo.getEquipe2().getOdd() + ")\n");
				event.append("DATA DA PARTIDA: " + sdf.format(jogo.getData()) + "\n");
				event.append("LOCAL DA PARTIDA : " + jogo.getLocal());
			}
			return event.toString();
		}
		
		
		
		
		
		
		
		
		
}

