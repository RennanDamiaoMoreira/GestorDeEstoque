package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ProdutoDao;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField cod;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField nome;
	private JTextField descricao;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto frame = new TelaProduto();
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
	public TelaProduto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CodProduto");
		lblNewLabel.setBounds(361, 23, 73, 26);
		contentPane.add(lblNewLabel);
		
		cod = new JTextField();
		cod.setBounds(345, 47, 89, 20);
		contentPane.add(cod);
		cod.setColumns(10);
		
		JButton btnNewButton = new JButton("buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(cod.getText());
				try {
					Produto p = ProdutoDao.getInstacia().obterProduto(codigo);
					JOptionPane.showMessageDialog(null, "o produto do id :" +p.getId()+" tem nome : "+p.getNome());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(345, 78, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("nome");
		lblNewLabel_1.setBounds(73, 29, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("descricao");
		lblNewLabel_2.setBounds(63, 78, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		nome = new JTextField();
		nome.setBounds(53, 47, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		descricao = new JTextField();
		descricao.setBounds(53, 103, 86, 20);
		contentPane.add(descricao);
		descricao.setColumns(10);
		
		btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = new Produto(nome.getText(),descricao.getText());
				try {
					ProdutoDao.getInstacia().gravar(p);
					JOptionPane.showMessageDialog(null, "deu bom");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(53, 134, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
