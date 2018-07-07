package control;

import model.Dados;

public class Principal {
	
	public static void main(String[] args) {
		
		SocketServidor sserv = new SocketServidor();
		
		sserv.createServerSocket(55555);
		sserv.createReader();
		sserv.createWriter();

		while(true){
			sserv.bindToClient();
			sserv.receiveData();
		}
		
	}
}
