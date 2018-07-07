package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation {

	JanelaCliente j = new JanelaCliente();
	Dados d;

	public ModelVisionRelation(JanelaCliente j, Dados d) {
		this.j = j;
		this.d = d;

		this.j.getBtnSubmeter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		this.j.getBtnLimpar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j.getTxtPeso().setText("");
				j.getTxtAltura().setText("");
				j.getLblIMC().setText("");
			}
		});
	}

}