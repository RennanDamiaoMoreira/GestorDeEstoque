package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.BD;
import DAO.EstoqueDao;
import model.Estoque;


public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement comando = null;
	
		

		try {
			
			Estoque e = EstoqueDao.getInstacia().obterEstoque(1, "1");
			System.out.println(e.getProduto().getNome());
			
			
			
			conexao = BD.getInstancia().getConexao();
			comando = conexao.prepareStatement("SELECT * FROM produto;");
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				System.out.println("id : "+resultado.getInt("id")+"  nome : "+resultado.getString("nome")+"  descricao : "+resultado.getString("descricao")+"\n");
			}
			
		} finally {
			
		}

		
	}

}
