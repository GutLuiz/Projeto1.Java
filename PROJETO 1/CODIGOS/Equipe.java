
package entities;

public class Equipe {
		private String nome;
		private Double odd;
		public Equipe(String nome, Double odd) {
			this.nome = nome;
			this.odd = odd;
		}
		public Equipe(String nome) {
			this.nome = nome;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Double getOdd() {
			return odd;
		}
		public void setOdd(Double odd) {
			this.odd = odd;
		}
		public void total(double total) {
			
		}
		
}
