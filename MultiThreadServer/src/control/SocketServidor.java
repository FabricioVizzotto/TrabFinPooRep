package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketServidor {

	private Socket cli;
	private ServerSocket serv;
	private String endereco;
	private int porta;
	private PrintWriter pw;
	private BufferedReader in;
	private ArrayList<String> al;

	public void bindToClient() {
		try {
			cli = serv.accept();
			onlyWithClient(cli);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onlyWithClient(Socket cli) {
		createWriter();
		createReader();
	}

	public void createServerSocket(int porta) {
		try {
			serv = new ServerSocket(porta);
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

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

}
