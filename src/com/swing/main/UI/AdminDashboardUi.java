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
import java.awt.BorderLayout;

public class AdminDashboardUi {

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
					AdminDashboardUi window = new AdminDashboardUi();
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
	
	Color defaultcolor,clickedColor;
	public AdminDashboardUi() {
		initialize();
		defaultcolor= Color.black;
		clickedColor = new Color(240,151,57);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 627, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 593, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEGREGATING DEVICE TO RESELL AND RECYCLE WASTE");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(72, 11, 485, 33);
		panel.add(lblNewLabel);
		
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
		panel.add(lblNewLabel_1);
		
		JLabel adminimg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		adminimg.setIcon(new ImageIcon(img));
		adminimg.setBounds(10, 11, 49, 44);
		panel.add(adminimg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 81, 161, 316);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel menu1 = new JPanel();
		
		menu1.setBackground(Color.BLACK);
		menu1.setBounds(10, 11, 141, 43);
		panel_1.add(menu1);
		menu1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(53, 13, 78, 21);
		menu1.add(lblNewLabel_2);
		
		JPanel menu2 = new JPanel();
		menu2.setLayout(null);
		menu2.setBackground(Color.BLACK);
		menu2.setBounds(10, 65, 141, 43);
		panel_1.add(menu2);
		
		JLabel productlistmenu = new JLabel("PRODUCT LIST");
		productlistmenu.setForeground(Color.WHITE);
		productlistmenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		productlistmenu.setBounds(53, 11, 103, 21);
		menu2.add(productlistmenu);
		
		JPanel menu3 = new JPanel();
		menu3.setLayout(null);
		menu3.setBackground(Color.BLACK);
		menu3.setBounds(10, 119, 141, 43);
		panel_1.add(menu3);
		
		JLabel userlistmenu = new JLabel("USER LIST");
		userlistmenu.setForeground(Color.WHITE);
		userlistmenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		userlistmenu.setBounds(55, 11, 103, 21);
		menu3.add(userlistmenu);
		
		defaultcolor= Color.black;
		clickedColor = new Color(240,151,57);
		
		menu1.setBackground(defaultcolor);
		
		JLabel prdlbl = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/item.png")).getImage();
		prdlbl.setIcon(new ImageIcon(img1));
		prdlbl.setBounds(0, 0, 43, 43);
		menu1.add(prdlbl);
		menu2.setBackground(defaultcolor);
		
		JLabel listlbl = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/itemlist.png")).getImage();
		listlbl.setIcon(new ImageIcon(img2));
		listlbl.setBounds(0, 0, 43, 43);
		menu2.add(listlbl);
		menu3.setBackground(defaultcolor);
		
		JLabel usrlbl = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/userlist.png")).getImage();
		usrlbl.setIcon(new ImageIcon(img3));
		usrlbl.setBounds(0, 0, 43, 43);
		menu3.add(usrlbl);
		
		JLabel label = new JLabel("New label");
		label.setBounds(154, 77, 34, 14);
		frame.getContentPane().add(label);
		
		JPanel jdesktoppanel = new JPanel();
		jdesktoppanel.setBounds(178, 81, 425, 316);
		frame.getContentPane().add(jdesktoppanel);
		jdesktoppanel.setLayout(new BorderLayout(0, 0));
		
		
		menu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menu1.setBackground(clickedColor);
				menu2.setBackground(defaultcolor);
				menu3.setBackground(defaultcolor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductMaster product = new ProductMaster();
				jdesktoppanel.removeAll();
				jdesktoppanel.add(product).setVisible(true);
			}
		});
		
		menu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menu1.setBackground(defaultcolor);
				menu2.setBackground(clickedColor);
				menu3.setBackground(defaultcolor);
			}
		});
		
		menu3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menu1.setBackground(defaultcolor);
				menu2.setBackground(defaultcolor);
				menu3.setBackground(clickedColor);
			}
		});
		
	}
}
