package control;

import java.net.Socket;

import model.Dados;
import vision.JanelaCliente;

public class Principal {
	
	public static void main(String[] args) {
		
		JanelaCliente jc = new JanelaCliente();
		Dados d = new Dados();
		SocketClient sc = new SocketClient(jc.getTxtIP().getText(), Integer.parseInt(jc.getTxtPorta().getText()));
		ModelVisionRelation mvr = new ModelVisionRelation(jc, d);

		sc.bindToServer();
		sc.createReader();
		sc.createWriter();
		
		// Shipping Bay - Sends to server as a request
		String exitAltura = jc.getTxtAltura().getText();
		String exitPeso = jc.getTxtPeso().getText();
		sc.sendData(exitAltura);
		sc.sendData(exitPeso);
		
		// Loading Bay - recieves IMC from our awesome server
		String entry = null;
		entry = sc.receiveData();
		jc.getLblIMC().setText(entry);
		
	}
}
