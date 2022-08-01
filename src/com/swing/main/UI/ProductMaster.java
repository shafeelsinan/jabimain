package com.swing.main.UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ProductMaster extends JInternalFrame {
	private JTextField codetxt;
	private JTextField ratetxt;
	private JTextField nametext;
	private JTextField mrptext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMaster frame = new ProductMaster();
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
	public ProductMaster() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 422, 307);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CODE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 66, 66, 19);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 412, 54);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProductMaster = new JLabel("PRODUCT MASTER");
		lblProductMaster.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProductMaster.setBounds(118, 21, 190, 19);
		panel.add(lblProductMaster);
		
		JLabel prodimg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/item.png")).getImage();
		prodimg.setIcon(new ImageIcon(img));
		prodimg.setBounds(0, 3, 61, 48);
		panel.add(prodimg);
		
		JLabel lblNewLabel_1 = new JLabel("RATE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 96, 66, 19);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DESC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 126, 66, 19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(193, 69, 66, 19);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MRP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(193, 99, 66, 19);
		getContentPane().add(lblNewLabel_4);
		
		codetxt = new JTextField();
		codetxt.setBounds(66, 66, 96, 20);
		getContentPane().add(codetxt);
		codetxt.setColumns(10);
		
		ratetxt = new JTextField();
		ratetxt.setBounds(66, 96, 96, 20);
		getContentPane().add(ratetxt);
		ratetxt.setColumns(10);
		
		nametext = new JTextField();
		nametext.setBounds(258, 69, 96, 20);
		getContentPane().add(nametext);
		nametext.setColumns(10);
		
		mrptext = new JTextField();
		mrptext.setBounds(258, 96, 96, 20);
		getContentPane().add(mrptext);
		mrptext.setColumns(10);
		
		JTextArea descriptiontxt = new JTextArea();
		descriptiontxt.setRows(3);
		descriptiontxt.setBounds(66, 126, 169, 41);
		getContentPane().add(descriptiontxt);
		
		JCheckBox isactive = new JCheckBox("ACTIVE");
		isactive.setBackground(Color.LIGHT_GRAY);
		isactive.setFont(new Font("Tahoma", Font.BOLD, 13));
		isactive.setBounds(258, 144, 96, 23);
		getContentPane().add(isactive);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(265, 184, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
