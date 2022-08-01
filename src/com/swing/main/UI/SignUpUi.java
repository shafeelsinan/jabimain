package com.swing.main.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.swing.common.BaseRepository;
import com.swing.common.BeanUtils;
import com.swing.entity.JabUser;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpUi {

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
					SignUpUi window = new SignUpUi();
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
	public SignUpUi() {
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
		panel.setBounds(0, 0, 525, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGNUP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(211, 25, 98, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(193, 120, 88, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(193, 174, 88, 21);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(319, 117, 117, 26);
		frame.getContentPane().add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(319, 171, 117, 26);
		frame.getContentPane().add(passwordtxt);
		
		JButton signupbtn = new JButton("SIGNUP");
		
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		signupbtn.setBounds(347, 264, 89, 23);
		frame.getContentPane().add(signupbtn);
		
		JLabel signupimage = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/signup.png")).getImage();
		signupimage.setIcon(new ImageIcon(img3));
		signupimage.setBounds(54, 99, 129, 144);
		frame.getContentPane().add(signupimage);
		
		String[] usertypes = {"ADMIN","BUYER","SELLER"};
		JComboBox usertype = new JComboBox(usertypes);
		usertype.setBounds(319, 217, 117, 26);
		frame.getContentPane().add(usertype);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("USER TYPE");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(193, 221, 88, 21);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Already User, LOGIN");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				LoginUi login = new LoginUi();
				login.getFrame().setVisible(true);
				
			}
		});
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(307, 298, 129, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!BeanUtils.isNullOrEmpty(usernametxt.getText())
						&& !BeanUtils.isNullOrEmpty(passwordtxt.getText())) {
					JabUser user = new JabUser();
					user.setName(usernametxt.getText());
					user.setPassword(passwordtxt.getText());
					user.setUserType(usertype.getSelectedItem().toString());
					BaseRepository repository  = new BaseRepository();
					repository.save(user);
					clearval();
					JOptionPane.showMessageDialog(frame, "SignUp Success");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Enter Valid Username And Password");
				}
			}
		});
	}
	
	public void clearval()
	{
		usernametxt.setText("");
		passwordtxt.setText("");
	}
}
