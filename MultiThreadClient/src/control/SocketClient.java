package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	private Socket cli;
	private String endereco;
	private int porta;
	private PrintWriter pw;
	private BufferedReader br;
	
	public SocketClient(String endereco, int porta){
		this.endereco = endereco;
		this.porta = porta;
		
	}
	
	public void bindToServer(){
		try {
			cli = new Socket(endereco,porta);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createWriter(){
		try {
			pw = new PrintWriter(cli.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendData(String data){
		pw.write(data);
	}
	public void createReader(){
		try {
			br = new BufferedReader(new InputStreamReader(cli.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String receiveData(){
		String dados = null;
		return dados;
				
	}
}
