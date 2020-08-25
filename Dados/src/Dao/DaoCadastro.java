package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import Beans.Paciente;
import Connection.SingleConnection;

public class DaoCadastro {
	
	private Connection connection;
	
	public DaoCadastro() {
		
		connection = SingleConnection.getConnection();
		
	}
	
	  // Metodo salvar 
	public void salvar(Paciente usuario) {
		 
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		 try {
			 String sql = "insert into paciente(nome,data_entrada) values (?,?)";
			 PreparedStatement insert = connection.prepareStatement(sql);
			 insert.setString(1, usuario.getNome());
			
			 insert.setDate(2, usuario.getData_entrada());
			
			 // formato que deu certo comentado abaixo 
			 //insert.setString(2, usuario.getData_entrada());
			 
			// java.util.Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(usuario.getData_entrada());
			// insert.setString(2, new SimpleDateFormat("dd/MM/yyyy").format(dt));
				
			// SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			// java.util.Date udob=sdf1.parse(usuario.getData_entrada());
			 //long ms =udob.getTime();
			 //java.sql.Date  sqdob= new java.sql.Date(ms);// 
			 //insert.setDate(2, sqdob);
			 
		
			 
			 insert.execute();
			 connection.commit();
			 
			 }catch(Exception e) {
				 e.printStackTrace();
				 
			 }
			 try {
				 
				 connection.rollback();
			 }catch (Exception e1) {
			 e1.printStackTrace();
			}
		
	}
	

}
