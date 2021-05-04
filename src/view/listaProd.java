package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import DAO.ProdutoDao;
import model.Produto;
import model.tabelaProduto;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

public class listaProd extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaProd frame = new listaProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public listaProd() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		
		btnNewButton = new JButton("New button");
		
		btnNewButton_1 = new JButton("New button");
		
		btnNewButton_2 = new JButton("New button");
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel)
							.addGap(29)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_2))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(130)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(652))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		tabelaProduto modeltable = new tabelaProduto();
		table.setModel(modeltable);
		
		
		
	}
}
