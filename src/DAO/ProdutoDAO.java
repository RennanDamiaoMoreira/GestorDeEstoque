package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;


public class ProdutoDao extends DAO{
	private static ProdutoDao instancia = new ProdutoDao();

	public static ProdutoDao getInstacia() {
		return instancia;
	}

	public void gravar(Produto Produto) throws ClassNotFoundException, SQLException {

		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("insert into Produto (nome,descricao) values (?,?);");
			comando.setString(1, Produto.getNome());
			comando.setString(2, Produto.getDescricao());
			
			comando.executeUpdate();

		} finally {
			fecharConexao(conexao, comando);
		}
	}
	public boolean alterar (Produto Produto) throws ClassNotFoundException, SQLException {
		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("update Produto nome=?,descricao=? where id=? ");
			comando.setString(1, Produto.getNome());
			comando.setString(2, Produto.getDescricao());
			comando.setInt(3, Produto.getId());
		comando.execute();
	}finally {
		fecharConexao(conexao, comando);
	}
		return false;
	}
	public Produto obterProduto(int id) throws ClassNotFoundException, SQLException {
		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("select * From Produto where id=?");
			comando.setInt(1, id);
			
		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {
			Produto produto = new Produto(id, resultado.getString("nome"), resultado.getString("descricao"));
			return produto;
		}
	}finally {
		fecharConexao(conexao, comando);
	}
		return null;
	}
	public ArrayList<Produto> obterProdutos() {
		Connection conexao = null;
		PreparedStatement comando = null;
		ArrayList<Produto>lista =new ArrayList<>();
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("select * From Produto");
			
			
		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {
			Produto produto = new Produto(Integer.parseInt(resultado.getString("id")), resultado.getString("nome"), resultado.getString("descricao"));
			
			lista.add(produto);
		}
		return lista;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			fecharConexao(conexao, comando);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return lista;
	}
}
