package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beans.Paciente;
import Dao.DaoCadastro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField txtNome;
	private JButton btnSalvar;
	private JLabel lblData;
	/**
	 * @wbp.nonvisual location=9,397
	 */
	private final JTextPane textPane = new JTextPane();
	private JDateChooser txtEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(28, 47, 70, 15);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(116, 45, 243, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				Paciente obj = new Paciente();
				obj.setNome(txtNome.getText());
				obj.setData_entrada(addDate);
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String addDate = dateFormat.parse(txtEntrada.getText()); 
				
				
				
				DaoCadastro dao = new DaoCadastro();
				dao.salvar(obj);
				JOptionPane.showMessageDialog(null, "Dados Inseridos!!!");
				
				catch(Exception e) {
					e.printStackTrace();
				}	
			}
		});
		
		btnSalvar.setBounds(242, 111, 117, 25);
		contentPane.add(btnSalvar);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(28, 88, 70, 15);
		contentPane.add(lblData);
		
		txtEntrada = new JDateChooser();
		txtEntrada.setBounds(116, 84, 133, 19);
		contentPane.add(txtEntrada);
	}
}
