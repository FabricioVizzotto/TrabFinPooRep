package control;

import java.util.ArrayList;

public class PrincipalServ {

	public static void main(String[] args) {

		SocketServidor sserv = new SocketServidor();
		double alt, peso, imc;
		String[] list = null;

		sserv.createServerSocket(55555);

		System.out.println("Buscando conexão...");
		while (true) {
			sserv.bindToClient();
			System.out.println("Conectado");

			sserv.createReader();
			sserv.createWriter();

			list = sserv.receiveData().split(";");

			alt = Double.parseDouble(list[0]);
			System.out.println("Got height");
			peso = Double.parseDouble(list[1]);
			System.out.println("Got Mass");
			imc = calcImc(alt, peso);

			sserv.sendData("" + imc);
		}

	}

	public static double calcImc(double alt, double peso) {
		double imc = peso / (Math.pow(2, alt));
		return imc;
	}
}
