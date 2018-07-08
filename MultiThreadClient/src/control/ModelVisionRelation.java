package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation implements ActionListener{

	private JanelaCliente j = new JanelaCliente();
	private Dados d;

	public ModelVisionRelation(JanelaCliente j, Dados d) {
		this.j = j;
		this.d = d;

		j.getBtnSubmeter().addActionListener(this);
		j.getBtnLimpar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Submeter")) {
			d.setAlt(Double.parseDouble(j.getTxtAltura().getText()));
			d.setPeso(Double.parseDouble(j.getTxtPeso().getText()));
		}
		if(e.getActionCommand().equals("Limpar")) {
			j.getTxtPeso().setText("");
		j.getTxtAltura().setText("");
		j.getLblIMC().setText("");
		}
		
	}
}