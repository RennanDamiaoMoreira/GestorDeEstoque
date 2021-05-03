package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import DAO.ProdutoDao;

public class tabelaProduto extends AbstractTableModel{

private String[] colunas = {"id","nome","descricao"};
ArrayList<Produto> lista =ProdutoDao.getInstacia().obterProdutos();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	} 

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0:
			return lista.get(rowIndex).getId();
		case 1:
			return lista.get(rowIndex).getNome();
		case 2:
			return lista.get(rowIndex).getDescricao();
		}
		return columnIndex;
	}

}
