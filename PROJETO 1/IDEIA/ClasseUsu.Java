package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario extends Gerenciamento {
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	  
	   private Date dataNascimento;
	   private Double saldo;
	   
	public Usuario() {
		
	}
	 
	   
	public Usuario(String nome, int senha, Date dataNascimento, Double saldo) {
		super.setNome(nome);
		super.setSenha(senha);
		this.dataNascimento = dataNascimento;
		this.saldo = saldo;
	}
	public Usuario(double saldo) {
		this.saldo = saldo;
	}

	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSaldo() {
		return saldo;
	}

    
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		StringBuilder usu = new StringBuilder();
		usu.append("Nome: " + getNome() + "\n");
		usu.append("Data de nascimento: " + sdf.format(dataNascimento) + "\n");
		usu.append("Saldo na conta: " + saldo + "\n");
		return usu.toString();
		
	}
	    
	}


