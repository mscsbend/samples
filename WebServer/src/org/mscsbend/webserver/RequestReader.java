package org.mscsbend.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestReader implements Runnable {

	enum State {
		REQUESTLINE,
		HEADERS
	};
	
	private IHandler handler;
	private BufferedReader input;
	private State state;
	private String path;
	
	private RequestReader(){}
	
	public static RequestReader create(InputStream inputStream, IHandler handler) {
		RequestReader instance = new RequestReader();
		instance.input = new BufferedReader(new InputStreamReader(inputStream));
		instance.handler = handler;
		Thread t = new Thread(instance);
		t.start();
		return instance;
	}

	@Override
	public void run() {
		String line;
		this.state = State.REQUESTLINE;
		try {
			while((line=input.readLine()) != null) {
				System.out.println(line);
				switch(this.state) {
				case REQUESTLINE:
					setPath(line);
					this.state = State.HEADERS;
					break;
				case HEADERS:
					if(line.isEmpty()) {
						this.handler.retrieve(this.path);
						return;
					} else {
						//TODO Do something with headers
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void setPath(String line) {
		String[] parts = line.split(" ");
		this.path = parts[1];
		System.out.println(this.path);
	}
}
