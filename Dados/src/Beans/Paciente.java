package Beans;

import java.sql.Date;

public class Paciente {
	
	
	private String nome;
	private Date data_entrada;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	

}
