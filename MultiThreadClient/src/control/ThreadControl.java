package control;

import model.Dados;
import vision.JanelaCliente;

public class ThreadControl extends Thread{

	private String nome;
	private SocketClient cli;
	private JanelaCliente janCli;
	private Dados dados;
	
}
