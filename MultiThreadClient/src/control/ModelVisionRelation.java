package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation implements ActionListener {

	private JanelaCliente j = new JanelaCliente();
	private Dados d;
	private SocketClient sc;

	public ModelVisionRelation(JanelaCliente j, Dados d) {
		this.j = j;
		this.d = d;

		j.getBtnSubmeter().addActionListener(this);
		j.getBtnLimpar().addActionListener(this);
		j.getBtnConnect().addActionListener(this);
	}

	public void Limpar() {
		j.getTxtPeso().setText("");
		j.getTxtAltura().setText("");
		j.getLblIMC().setText("");
		j.getTxtIP().setText("");
		j.getTxtPorta().setText("");
	}

	public void Submeter(double alt, double peso) {

		sc.sendData(alt + ";" + peso);

		Double entry = null;
		String IMC = null;

		entry = Double.parseDouble(sc.receiveData());

		if (entry <= 17) {
			IMC = "Muito abaixo do peso";
		} else if (entry <= 18.49) {
			IMC = "Abaixo do peso.";
		} else if (entry <= 24.99) {
			IMC = "Peso normal";
		} else if (entry <= 29.99) {
			IMC = "Acima do peso";
		} else if (entry <= 34.99) {
			IMC = "Obesidade I";
		} else if (entry <= 39.99) {
			IMC = "Obesidade II";
		} else if (entry >= 40) {
			IMC = "Obesidade III";
		} else {
			IMC = "error";
		}

		j.getLblIMC().setText(IMC);
	}

	private void Conectar() {
		sc = new SocketClient(j.getTxtIP().getText(), Integer.parseInt(j.getTxtPorta().getText()));

		sc.bindToServer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Submeter")) {
			d.setAlt(Double.parseDouble(j.getTxtAltura().getText()));
			d.setPeso(Double.parseDouble(j.getTxtPeso().getText()));
			Submeter(d.alt, d.peso);
		}
		if (e.getActionCommand().equals("Limpar")) {
			Limpar();
		}
		if (e.getActionCommand().equals("Conectar")) {
			Conectar();
		}

	}

}