package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation {

	private JanelaCliente j = new JanelaCliente();
	private Dados d;

	public ModelVisionRelation(JanelaCliente j, Dados d) {
		this.j = j;
		this.d = d;

		j.getBtnSubmeter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setAlt(Double.parseDouble(j.getTxtAltura().getText()));
				d.setPeso(Double.parseDouble(j.getTxtPeso().getText()));
			}
		});

		j.getBtnLimpar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j.getTxtPeso().setText("");
				j.getTxtAltura().setText("");
				j.getLblIMC().setText("");
			}
		});
	}
}