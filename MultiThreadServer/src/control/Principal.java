package control;


public class Principal {
	
	public static void main(String[] args) {
		
		SocketServidor sserv = new SocketServidor();
		double alt, peso, imc;
		String texto;
		
		sserv.createServerSocket(55555);
		
		
		System.out.println("Buscando conexão...");
		while(true){
			sserv.bindToClient();
			System.out.println("Conectado");
			
			sserv.createReader();
			sserv.createWriter();
			
			do {
				texto = sserv.receiveData();
			}while(texto.equals(""));
			
			alt = Double.parseDouble(texto);
			peso = Double.parseDouble(sserv.receiveData());
			imc = calcImc(alt, peso);
			sserv.sendData(Double.toString(imc));
		}
		
	}

	public static double calcImc(double alt, double peso) {
		double imc = peso / (Math.pow(2, alt));
		return imc;
	}
}
