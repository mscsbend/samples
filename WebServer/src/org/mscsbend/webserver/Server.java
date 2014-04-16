package org.mscsbend.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	private ServerSocket ss;
	private Server() {}
	
	public static void create() {
		Server instance = new Server();
		Thread t = new Thread(instance);
		t.setDaemon(false);
		t.start();
	}

	@Override
	public void run() {
		try {
			ss = new ServerSocket(7777);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		while(true) {
			try {
				Socket s = ss.accept();
				Handler.create(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
