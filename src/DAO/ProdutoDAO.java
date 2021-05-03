package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			comando = conexao.prepareStatement("insert into Produto (produto,tamanho,quantidade) values (?,?,?);");
			comando.setInt(1, Produto.getProduto().getId());
			comando.setString(2, Produto.getTamanho());
			comando.setInt(3, Produto.getQuantidade());
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
			comando = conexao.prepareStatement("update Produto quantidade=? where produto=? and tamanho=?");
			comando.setInt(1, Produto.getQuantidade());
			comando.setInt(2, Produto.getProduto().getId());
			comando.setString(3, Produto.getTamanho());
		comando.execute();
	}finally {
		fecharConexao(conexao, comando);
	}
		return false;
	}
	public Produto obterProduto(int produto, String tamanho) throws ClassNotFoundException, SQLException {
		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("select * From Produto where produto=? and tamanho=?");
			comando.setInt(1, produto);
			comando.setString(2, tamanho);
		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {
			PreparedStatement produtor = conexao.prepareStatement("select * from produto where id = ?");
			produtor.setInt(1, produto);
			ResultSet produtoResult=produtor.executeQuery();
			Produto p = null;
			while (produtoResult.next()) {
				p=new Produto(produtoResult.getInt("id"), produtoResult.getString("nome"), produtoResult.getString("descricao"));
			}
			Produto Produto = new Produto(p, resultado.getInt("quantidade"), tamanho);
			return Produto;
		}
	}finally {
		fecharConexao(conexao, comando);
	}
		return null;
	}
}
