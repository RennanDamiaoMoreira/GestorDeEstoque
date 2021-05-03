package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    public void fecharConexao(Connection conexao, Statement comando) throws SQLException {

        if (comando != null) {
            comando.close();
        }
        if (comando != null) {
            conexao.close();
        }
    }

}