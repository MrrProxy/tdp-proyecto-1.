package gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField txtFLU;
	private JTextField txtFApellido;
	private JTextField txtFNombre;
	private JTextField txtFEmail;
	private JTextField txtFGithub;
	private JLabel lblFechaHora;
	private JLabel lblImagen;
	
	/**
	 * Create the frame.
	 */
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("/images/tdp.png"));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 597, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLU.setBounds(20, 43, 46, 14);
		contentPane.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(20, 84, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(20, 123, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(20, 167, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblGithub = new JLabel("Github URL");
		lblGithub.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGithub.setBounds(20, 216, 68, 14);
		contentPane.add(lblGithub);
		
		txtFLU = new JTextField();
		txtFLU.setText(""+studentData.getId());
		txtFLU.setEditable(false);
		txtFLU.setColumns(10);
		txtFLU.setBounds(99, 40, 224, 20);
		contentPane.add(txtFLU);
		
		txtFApellido = new JTextField();
		txtFApellido.setText(studentData.getLastName());
		txtFApellido.setEditable(false);
		txtFApellido.setBounds(99, 81, 224, 20);
		contentPane.add(txtFApellido);
		txtFApellido.setColumns(10);
		
		txtFNombre = new JTextField();
		txtFNombre.setText(studentData.getFirstName());
		txtFNombre.setEditable(false);
		txtFNombre.setBounds(99, 120, 224, 20);
		contentPane.add(txtFNombre);
		txtFNombre.setColumns(10);
		
		txtFEmail = new JTextField();
		txtFEmail.setText(studentData.getMail());
		txtFEmail.setEditable(false);
		txtFEmail.setBounds(99, 164, 224, 20);
		contentPane.add(txtFEmail);
		txtFEmail.setColumns(10);
		
		txtFGithub = new JTextField();
		txtFGithub.setText(studentData.getGithubURL());
		txtFGithub.setEditable(false);
		txtFGithub.setBounds(99, 213, 224, 20);
		contentPane.add(txtFGithub);
		txtFGithub.setColumns(10);
		
		lblFechaHora = new JLabel("");
		lblFechaHora.setBounds(10, 258, 391, 25);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		Date fecha = new Date();
		LocalTime hora = LocalTime.now();
		String horaActual = hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond();
		lblFechaHora.setText("Esta ventana fue generada el "+ sdf.format(fecha) + " a las: " + horaActual);
		contentPane.add(lblFechaHora);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(studentData.getPathPhoto()));
		lblImagen.setBounds(410, 43, 160, 201);
		ImageIcon ico = new ImageIcon(getClass().getResource(studentData.getPathPhoto()));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img);
		contentPane.add(lblImagen);
		
		init();
	}
	
	private void init() {
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 401, 246);
		
		tabInformation = new JPanel();
		tabInformation.setBounds(0, 11, 401, 246);
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
}