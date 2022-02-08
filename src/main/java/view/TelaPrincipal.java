package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.DesligarController;
import controller.LoginController;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Window.Type;

public class TelaPrincipal {

	private JFrame frmCerberus;
	private JPasswordField pass;
	private LoginController loginController;
	DesligarController desligarController;
	private JTextField txtChances;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmCerberus.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		desligarController =  new DesligarController(this);
		loginController = new LoginController(this);
		initialize();
		
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		desligarController.start();
		frmCerberus = new JFrame();
		frmCerberus.setAlwaysOnTop(true);
		frmCerberus.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/view/assets/cerberusicone-removebg-preview.png")));
		frmCerberus.setTitle("Cerberus");
		frmCerberus.setBounds(100, 100, 450, 300);
		frmCerberus.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCerberus.getContentPane().setLayout(null);
		frmCerberus.setResizable(false);
		
		JLabel lblpass = new JLabel("Qual a Senha?");
		lblpass.setForeground(Color.BLACK);
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpass.setBounds(144, 11, 123, 49);
		frmCerberus.getContentPane().add(lblpass);
		
		pass = new JPasswordField();
		pass.setBounds(71, 142, 264, 20);
		frmCerberus.getContentPane().add(pass);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginController.verificarLogin();
			}
		});
		btnEntrar.setBounds(159, 173, 89, 23);
		frmCerberus.getContentPane().add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/assets/cerberusicone-removebg-preview.png")));
		lblNewLabel.setBounds(81, 11, 254, 213);
		frmCerberus.getContentPane().add(lblNewLabel);
		
		txtChances = new JTextField();
		txtChances.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtChances.setForeground(Color.BLACK);
		txtChances.setText("Chances: 3");
		txtChances.setEditable(false);
		txtChances.setBounds(163, 219, 104, 20);
		frmCerberus.getContentPane().add(txtChances);
		txtChances.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Você tem 30 Sengundos!");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(146, 247, 151, 14);
		frmCerberus.getContentPane().add(lblNewLabel_1);
	}

	
	
	
	public DesligarController getDesligarController() {
		return desligarController;
	}

	public void setDesligarController(DesligarController desligarController) {
		this.desligarController = desligarController;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}
	
	
	public JTextField getTxtChances() {
		return txtChances;
	}

	public void setTxtChances(JTextField txtChances) {
		this.txtChances = txtChances;
	}

	public JFrame getFrmCerberus() {
		return frmCerberus;
	}

	public void setFrmCerberus(JFrame frmCerberus) {
		this.frmCerberus = frmCerberus;
	}

	public void error(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem, "Error", JOptionPane.WARNING_MESSAGE);
	}
	
	public void sucess(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
