package com.swing.main.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.swing.common.BaseRepository;
import com.swing.common.BeanUtils;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUi extends JFrame{

	private JFrame frame;
	private JTextField usernametxt;
	private JPasswordField passwordtxt;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getUsernametxt() {
		return usernametxt;
	}

	public void setUsernametxt(JTextField usernametxt) {
		this.usernametxt = usernametxt;
	}

	public JPasswordField getPasswordtxt() {
		return passwordtxt;
	}

	public void setPasswordtxt(JPasswordField passwordtxt) {
		this.passwordtxt = passwordtxt;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUi window = new LoginUi();
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
	public LoginUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 539, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 505, 55);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEGREGATING DEVICE TO RESELL AND RECYCLE WASTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 485, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(174, 120, 104, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(174, 164, 104, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(326, 121, 133, 27);
		frame.getContentPane().add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(326, 165, 133, 27);
		frame.getContentPane().add(passwordtxt);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!BeanUtils.isNullOrEmpty(usernametxt.getText())&&
						!BeanUtils.isNullOrEmpty(passwordtxt.getText()))
				{
					String query = "SELECT u.id,u.uname,u.usertype FROM jabuser u where u.active = 1";
					String appendQuery = "";
					appendQuery += " and u.uname ='" + usernametxt.getText() + "' and u.password = '"
							+ passwordtxt.getText() + "'";
					query += appendQuery;
					BaseRepository repository = new BaseRepository();
					List<Object[]> userlist = repository.find(query);
					if(!BeanUtils.isNullOrEmpty(userlist))
					{
						Object[] obj = userlist.get(0);
						frame.setVisible(false);
						if(obj[2].toString().equalsIgnoreCase("ADMIN"))
						{
							AdminDashboardUi admin = new AdminDashboardUi();
							admin.getFrame().setVisible(true);
							
						}
						else if(obj[2].toString().equalsIgnoreCase("BUYER"))
						{
							UserDashBoardUi user = new UserDashBoardUi();
							user.getFrame().setVisible(true);
						}
						else if(obj[2].toString().equalsIgnoreCase("SELLER"))
						{
							SellerDashboardUi seller = new SellerDashboardUi();
							seller.getFrame().setVisible(true);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Enter Valid Username And Password");
				}
			}
		});
		loginBtn.setBackground(Color.LIGHT_GRAY);
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginBtn.setBounds(370, 210, 89, 23);
		frame.getContentPane().add(loginBtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(26, 105, 125, 110);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New User, SIGNUP");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SignUpUi signUp = new SignUpUi();
				signUp.getFrame().setVisible(true);
			}
		});
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(350, 244, 129, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
	}
}
