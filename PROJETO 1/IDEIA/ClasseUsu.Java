package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	   private String nome;
	   private String email;
	   private Date dataNascimento;
	   private Double saldo;
	 
	   
	public Usuario(String nome, String email, Date dataNascimento, Double saldo) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		usu.append("NOME: " + nome + "\n");
		usu.append("Data de nascimento: " + sdf.format(dataNascimento) + "\n");
		usu.append("Saldo na conta: " + saldo + "\n");
		return usu.toString();
		
	}
	    
	}


