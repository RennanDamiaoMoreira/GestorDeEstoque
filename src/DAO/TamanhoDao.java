package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Tamanho;

public class TamanhoDao extends DAO {
 private static TamanhoDao instancia = new TamanhoDao();

public static TamanhoDao getInstancia() {
	return instancia;
}
 void gravar (Tamanho tamanho ) throws ClassNotFoundException, SQLException {
	 Connection conexao =null;
	 PreparedStatement comando = null;
	 try {
		 conexao=BD.getInstancia().getConexao();
		 comando = conexao.prepareStatement("Insert into tamanho (nome) values (?)");
		 comando.setString(1, tamanho.getNome());
		 comando.executeUpdate();
		 
	 }finally {
		fecharConexao(conexao, comando);
	}
}
 public void alterar(Tamanho tamanho) throws ClassNotFoundException, SQLException {
	 Connection conexao =null;
	 PreparedStatement comando = null;
	 try {
		 conexao=BD.getInstancia().getConexao();
		 comando = conexao.prepareStatement("update tamanho nome=? where id=?");
		 comando.setString(1, tamanho.getNome());
		 comando.setInt(2, tamanho.getId());
		 comando.execute();
		 
	 }finally {
		fecharConexao(conexao, comando);
	}
 }
 public ArrayList<Tamanho> obterTamanhos() throws ClassNotFoundException, SQLException{
	 Connection conexao =null;
	 PreparedStatement comando = null;
	 try {
		 conexao=BD.getInstancia().getConexao();
		 comando = conexao.prepareStatement("select * from tamanho");
		 
		 ResultSet listaPrimitiva = comando.executeQuery();
		 ArrayList<Tamanho>lista=new ArrayList<Tamanho>();
		 while (listaPrimitiva.next()) {
			 Tamanho temp = new  Tamanho(listaPrimitiva.getNString("nome"),Integer.parseInt(listaPrimitiva.getNString("id")));
			 lista.add(temp);
		 }
		 return lista;
	 }finally {
		fecharConexao(conexao, comando);
		
	}
 }
}
