package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EstoqueDao;
import model.Estoque;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField produto;
	private JTextField tamanho;
	private JTextField quantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadEstoque frame = new TelaCadEstoque();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadEstoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo do Produto");
		lblNewLabel.setBounds(120, 29, 94, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("tamanho");
		lblNewLabel_1.setBounds(120, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(120, 144, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		produto = new JTextField();
		produto.setBounds(120, 57, 86, 20);
		contentPane.add(produto);
		produto.setColumns(10);
		
		tamanho = new JTextField();
		tamanho.setBounds(120, 106, 86, 20);
		contentPane.add(tamanho);
		tamanho.setColumns(10);
		
		quantidade = new JTextField();
		quantidade.setBounds(120, 169, 86, 20);
		contentPane.add(quantidade);
		quantidade.setColumns(10);
		
		JButton insere = new JButton("Insere");
		insere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = new Produto(1,"tdt","descri");
				Estoque estoque = new Estoque(p, Integer.parseInt(quantidade.getText()), tamanho.getText());
				try {
					EstoqueDao.getInstacia().gravar(estoque);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "foi inserido com sucesso um novo estoque do produto "+p.getNome());
			}
		});
		insere.setBounds(276, 105, 89, 23);
		contentPane.add(insere);
	}

}
