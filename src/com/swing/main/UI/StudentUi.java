package com.swing.main.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.swing.entity.Student;
import com.swing.service.StudentService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentUi extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUi frame = new StudentUi();
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
	public StudentUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 504, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nametxt = new JTextField();
		nametxt.setBounds(232, 54, 96, 19);
		panel.add(nametxt);
		nametxt.setColumns(10);
		
		JButton createbtn = new JButton("Create");
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= nametxt.getText();
				StudentService service  =new StudentService();
				Student s = new Student();
				s.setName(name);
				service.saveStudent(s);
			}
		});
		createbtn.setBounds(243, 108, 85, 21);
		panel.add(createbtn);
	}
}
