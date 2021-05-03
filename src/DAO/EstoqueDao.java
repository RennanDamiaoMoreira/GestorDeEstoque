package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import DAO.DAO;

import model.Estoque;

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
			comando.setString(2, estoque.getTamanho());
			comando.setInt(3, estoque.getQuantidade());
			comando.executeUpdate();

		} finally {
			fecharConexao(conexao, comando);
		}
	}
	public boolean alterar (Estoque estoque) {
		Connection conexao = null;
		PreparedStatement comando = null;
		try {
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("update estoque quantidade=? where produto=? and tamanho=?");
			comando.setInt(1, estoque.getQuantidade());
			comando.setInt(2, estoque.getProduto().getId());
			comando.setString(3, estoque.getTamanho());
			
			
		}
	}

}
