package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketServidor {

	private Socket cli;
	private ServerSocket serv;
	private String endereco;
	private int porta;
	private PrintWriter pw;
	private BufferedReader br;
	
	
	public void bindToClient(){
		try {
			cli = serv.accept();
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
		try {
			while(br.ready()){
				dados = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dados;
				
	}
	
}
