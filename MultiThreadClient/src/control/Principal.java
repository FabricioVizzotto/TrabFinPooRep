package control;

import java.net.Socket;

import model.Dados;
import vision.JanelaCliente;

public class Principal {
	
	public static void main(String[] args) {
		
		JanelaCliente jc = new JanelaCliente();
		Dados d = new Dados();
		ModelVisionRelation mvr = new ModelVisionRelation(jc, d);
		jc.setVisible(true);

		
	}
}
