package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketClient {

	private Socket cli;
	private String endereco;
	private int porta;
	private PrintWriter pw;
	private BufferedReader in;
	private ArrayList<String> al;

	public SocketClient(String endereco, int porta) {
		this.endereco = endereco;
		this.porta = porta;

	}

	public void bindToServer() {
		try {
			cli = new Socket(endereco, porta);
			createReader();
			createWriter();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createWriter() {
		try {
			pw = new PrintWriter(cli.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendData(String data) {
		pw.println(data);
		pw.flush();
		System.out.println("info sent");
	}

	public void createReader() {
		try {
			in = new BufferedReader(new InputStreamReader(cli.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String receiveData() {
		String str = null;
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
