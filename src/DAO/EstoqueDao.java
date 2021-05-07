package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import DAO.DAO;

import model.Estoque;
import model.Produto;
import model.Tamanho;

public class EstoqueDao extends DAO{
	private static EstoqueDao instancia = new EstoqueDao();

	public static EstoqueDao getInstacia() {
		return instancia;
	}

	public void gravar(Estoque estoque) throws ClassNotFoundException, SQLException {

		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("insert into estoque (produto,tamanho,quantidade) values (?,?,?);");
			comando.setInt(1, estoque.getProduto().getId());
			comando.setInt(2, estoque.getTamanho().getId());
			comando.setInt(3, estoque.getQuantidade());
			comando.executeUpdate();

		} finally {
			fecharConexao(conexao, comando);
		}
	}
	public boolean alterar (Estoque estoque) throws ClassNotFoundException, SQLException {
		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("update estoque quantidade=? where produto=? and tamanho=?");
			comando.setInt(1, estoque.getQuantidade());
			comando.setInt(2, estoque.getProduto().getId());
			comando.setInt(3, estoque.getTamanho().getId());
		comando.execute();
	}finally {
		fecharConexao(conexao, comando);
	}
		return false;
	}
	public Estoque obterEstoque(int produto, Tamanho tamanho) throws ClassNotFoundException, SQLException {
		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("select * From estoque where produto=? and tamanho=?");
			comando.setInt(1, produto);
			comando.setInt(2, tamanho.getId());
		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {
			PreparedStatement produtor = conexao.prepareStatement("select * from produto where id = ?");
			produtor.setInt(1, produto);
			ResultSet produtoResult=produtor.executeQuery();
			Produto p = null;
			while (produtoResult.next()) {
				p=new Produto(produtoResult.getInt("id"), produtoResult.getString("nome"), produtoResult.getString("descricao"));
			}
			Estoque estoque = new Estoque(p, resultado.getInt("quantidade"), tamanho);
			return estoque;
		}
	}finally {
		fecharConexao(conexao, comando);
	}
		return null;
	}
}
