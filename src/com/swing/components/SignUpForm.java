package com.swing.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class SignUpForm {

	private JFrame frmSignUpForm;
	private JPanel panel;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfMobile;
	private JTextField tfPassword;
	private JTextField tfCPassword;
	private JButton btnRegister;
	Connection con;
	PreparedStatement pst;
	String fName,email,mobile,password,cpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm window = new SignUpForm();
					window.frmSignUpForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpForm() {
		initialize();
		
	}

	private void getConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
		JOptionPane.showMessageDialog(frmSignUpForm, "DataBase Established");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUpForm = new JFrame();
		frmSignUpForm.setTitle("Sign Up Form");
		frmSignUpForm.setBounds(100, 100, 598, 466);
		frmSignUpForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUpForm.getContentPane().setLayout(null);
		frmSignUpForm.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBounds(0, 11, 582, 405);
		frmSignUpForm.getContentPane().add(panel);
		panel.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Full Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tfName.setToolTipText("First Name");
		tfName.setBounds(121, 36, 338, 40);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setToolTipText("First Name");
		tfEmail.setColumns(10);
		tfEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Email Id", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfEmail.setBounds(121, 87, 338, 40);
		panel.add(tfEmail);
		
		tfMobile = new JTextField();
		tfMobile.setToolTipText("First Name");
		tfMobile.setColumns(10);
		tfMobile.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mobile Number", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfMobile.setBounds(121, 138, 338, 40);
		panel.add(tfMobile);
		
		tfPassword = new JTextField();
		tfPassword.setToolTipText("First Name");
		tfPassword.setColumns(10);
		tfPassword.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfPassword.setBounds(121, 189, 338, 40);
		panel.add(tfPassword);
		
		tfCPassword = new JTextField();
		tfCPassword.setToolTipText("First Name");
		tfCPassword.setColumns(10);
		tfCPassword.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Confirm Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfCPassword.setBounds(121, 240, 338, 40);
		panel.add(tfCPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getData();
			}
		});
		btnRegister.setBounds(249, 321, 89, 23);
		panel.add(btnRegister);
	}

	protected void getData() {
		
		
		fName = tfName.getText();
		email = tfEmail.getText();
		mobile = tfMobile.getText();
		password = tfPassword.getText();
		cpassword = tfCPassword.getText();
		
		if (fName.isEmpty()) {
			JOptionPane.showMessageDialog(frmSignUpForm, "Name Required");
			return;
			
		}
		if (email.isEmpty()) {
			JOptionPane.showMessageDialog(frmSignUpForm, "Email Required");
			return;
		}
		if (mobile.isEmpty()) {
			JOptionPane.showMessageDialog(frmSignUpForm, "Mobile Required");
			return;
			
		}
		if (password.isEmpty()) {
			JOptionPane.showMessageDialog(frmSignUpForm, "Password Required");
			return;
		}
		if (cpassword.isEmpty()) {
			JOptionPane.showMessageDialog(frmSignUpForm, "Password Required");
			return;
		}
		
		if (password.equals(cpassword)) {
			try {
				getConnection();
				String query = "insert into data values(?,?,?,?)";
				
				pst = con.prepareStatement(query);
				
				pst.setString(1, fName);
				pst.setString(2, email);
				pst.setString(3, mobile);
				pst.setString(4, password);
				pst.executeUpdate();
				
				tfName.setText("");
				tfEmail.setText("");
				tfMobile.setText("");
				tfPassword.setText("");
				tfCPassword.setText("");
				
				JOptionPane.showMessageDialog(frmSignUpForm, "Data Inserted");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(frmSignUpForm, "Password and Confirm Password Dont Match");

		}
		
		
		
		
	}
}
