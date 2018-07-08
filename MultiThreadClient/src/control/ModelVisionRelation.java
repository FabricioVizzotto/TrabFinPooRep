package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation implements ActionListener{

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
		j.getTxtPorta().setToolTipText("");
	}
	
	public void Submeter(double alt, double peso) {
		
		String entry = null;
		do {
			entry = sc.receiveData();
		}while(entry.equals(""));
		
		j.getLblIMC().setText(entry);
	}
	
	private void Conectar() {
		sc = new SocketClient(j.getTxtIP().getText(), Integer.parseInt(j.getTxtPorta().getText()));
		
		sc.bindToServer();
		sc.createReader();
		sc.createWriter();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Submeter")) {
			d.setAlt(Double.parseDouble(j.getTxtAltura().getText()));
			d.setPeso(Double.parseDouble(j.getTxtPeso().getText()));
			Submeter(d.alt, d.peso);
		}
		if(e.getActionCommand().equals("Limpar")) {
			Limpar();
		}
		if(e.getActionCommand().equals("Conectar")) {
			Conectar();
		}
		
	}

	
}