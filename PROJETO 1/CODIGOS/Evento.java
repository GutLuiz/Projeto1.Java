package entities;

import java.util.Date;

public class Evento {
	
		
		private int id;
		private Equipe equipe1;
		private Equipe equipe2;
		private Date  data;
		private String local;
		
		
		
		public Evento(Equipe equipe1, Equipe equipe2, Date data, String local,int id) {
			this.equipe1 = equipe1;
			this.equipe2 = equipe2;
			this.data = data;
			this.local = local;
			this.id = id;
			
		}
		public int getId() {
			return id;
		}
		public Equipe getEquipe1() {
	        return equipe1;
	    }
		public void setEquipe1(Equipe equipe1) {
		        this.equipe1 = equipe1;
		 }
	    public Equipe getEquipe2() {
	        return equipe2;
	    }
	    public void setEquipe2(Equipe equipe2) {
	        this.equipe2 = equipe2;
	    }
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
	
		
		
}

