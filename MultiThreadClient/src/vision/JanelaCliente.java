package vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class JanelaCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JLabel lblIMC;
	private JButton btnSubmeter;
	private JButton btnLimpar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCliente frame = new JanelaCliente();
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
	public JanelaCliente() {
		setTitle("Calculo de IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 11, 46, 14);
		contentPane.add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setBounds(66, 8, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(162, 11, 46, 14);
		contentPane.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(218, 8, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		lblIMC = new JLabel("");
		lblIMC.setBackground(Color.LIGHT_GRAY);
		lblIMC.setBounds(10, 73, 294, 96);
		contentPane.add(lblIMC);
		
		btnSubmeter = new JButton("Submeter");
		btnSubmeter.setIcon(null);
		btnSubmeter.setBounds(10, 39, 142, 23);
		contentPane.add(btnSubmeter);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(null);
		btnLimpar.setBounds(162, 39, 142, 23);
		contentPane.add(btnLimpar);
	}

	public JLabel getLblAltura() {
		return lblAltura;
	}

	public void setLblAltura(JLabel lblAltura) {
		this.lblAltura = lblAltura;
	}

	public JLabel getLblPeso() {
		return lblPeso;
	}

	public void setLblPeso(JLabel lblPeso) {
		this.lblPeso = lblPeso;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

	public JTextField getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(JTextField txtPeso) {
		this.txtPeso = txtPeso;
	}

	public JLabel getLblIMC() {
		return lblIMC;
	}

	public void setLblIMC(JLabel lblIMC) {
		this.lblIMC = lblIMC;
	}

	public JButton getBtnSubmeter() {
		return btnSubmeter;
	}

	public void setBtnSubmeter(JButton btnSubmeter) {
		this.btnSubmeter = btnSubmeter;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
	
	
}
