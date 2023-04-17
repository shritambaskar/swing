package com.swing.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingDemo {

	private JFrame frmLoginForm;//reference variable
	private JTextField tfUserName;
	private JTextField tfPassword;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JPanel panel;
	private JLabel lblOutput;
	private JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EDT - Event Dispatcher Tread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingDemo window = new SwingDemo();
					window.frmLoginForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}

	/**
	 * Create the application.
	 */
	public SwingDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();//invisible frame
		frmLoginForm.setResizable(false);
		frmLoginForm.setTitle("Login Form");
		frmLoginForm.setBounds(100, 100, 624, 463);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		frmLoginForm.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, Color.YELLOW, null, null));
		panel.setBounds(0, 0, 608, 424);
		frmLoginForm.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserName.setForeground(new Color(70, 130, 180));
		lblUserName.setToolTipText("This is UserName");
		lblUserName.setBackground(new Color(0, 255, 0));
		lblUserName.setBounds(221, 122, 96, 14);
		panel.add(lblUserName);
		
		tfUserName = new JTextField();
		tfUserName.setToolTipText("Enter Your User Name");
		tfUserName.setBounds(221, 147, 153, 20);
		panel.add(tfUserName);
		tfUserName.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(221, 178, 75, 14);
		panel.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(221, 203, 153, 20);
		panel.add(tfPassword);
		tfPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
				
			}

		});
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(198, 251, 89, 23);
		panel.add(btnLogin);
		
		lblOutput = new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(187, 325, 226, 39);
		panel.add(lblOutput);
		
		btnSignUp = new JButton("SignUp");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup();
			}
		});
		btnSignUp.setBounds(310, 252, 89, 23);
		panel.add(btnSignUp);
	}

	public void signup() {
		frmLoginForm.dispose();
        new SignUpForm().main(null);
        //signUp.setVisible(true);
	}

	protected void login() {
		//Bussiness Logic
		String user = tfUserName.getText();
		String pass = tfPassword.getText();
		
		if (user.isEmpty()) {
			JOptionPane.showMessageDialog(frmLoginForm, "UserName Required");
			return;
			
		}
		if (pass.isEmpty()) {
			JOptionPane.showMessageDialog(frmLoginForm, "Password Required");
			return;
		}
		
		if (user.equals("Shrikant") && pass.equals("123")) {
			lblOutput.setText("Welcome :"+user);
			tfUserName.setText("");
			tfPassword.setText("");
		} else {
			lblOutput.setText("UserName and Password Don't Match");
			tfUserName.setText("");
			tfPassword.setText("");
		}
		
		
	}
}
