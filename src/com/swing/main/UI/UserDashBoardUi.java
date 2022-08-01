package com.swing.main.UI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserDashBoardUi {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashBoardUi window = new UserDashBoardUi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserDashBoardUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 615, 394);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 11, 615, 66);
		panel.add(panel_1);
		
		JLabel lblBuyer = new JLabel("Buyer");
		lblBuyer.setForeground(Color.BLACK);
		lblBuyer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBuyer.setBounds(112, 26, 111, 40);
		panel_1.add(lblBuyer);
		
		JLabel lblNewLabel_1 = new JLabel("LOGOUT");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUi login = new LoginUi();
				frame.setVisible(false);
				login.getFrame().setVisible(true);
			}
		});
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(542, 0, 66, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel adminimg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/buyer.png")).getImage();
		adminimg.setIcon(new ImageIcon(img));
		adminimg.setBounds(22, 0, 95, 66);
		panel_1.add(adminimg);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(0, 78, 161, 316);
		panel.add(panel_1_1);
		
		JPanel menu1 = new JPanel();
		menu1.setLayout(null);
		menu1.setBackground(Color.BLACK);
		menu1.setBounds(10, 11, 141, 43);
		panel_1_1.add(menu1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(53, 13, 78, 21);
		menu1.add(lblNewLabel_2);
		
		JLabel prdlbl = new JLabel("");
		prdlbl.setBounds(0, 0, 43, 43);
		menu1.add(prdlbl);
		
		JPanel menu2 = new JPanel();
		menu2.setLayout(null);
		menu2.setBackground(Color.BLACK);
		menu2.setBounds(10, 65, 141, 43);
		panel_1_1.add(menu2);
		
		JLabel lblOrder = new JLabel("ORDER");
		lblOrder.setForeground(Color.WHITE);
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrder.setBounds(53, 11, 103, 21);
		menu2.add(lblOrder);
		
		JLabel listlbl = new JLabel("");
		listlbl.setBounds(0, 0, 43, 43);
		menu2.add(listlbl);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(162, 79, 453, 315);
		panel.add(panel_2);
	}

}
