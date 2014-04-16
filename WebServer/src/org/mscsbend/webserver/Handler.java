package org.mscsbend.webserver;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Paths;

public class Handler implements IHandler {

	private Handler() {}
	
	private OutputStream out;
	
	public static void create(Socket s) throws IOException {
		Handler handler = new Handler();
		RequestReader.create(s.getInputStream(), handler);
		handler.out = s.getOutputStream();
	}

	@Override
	public void retrieve(String path) throws IOException {
		File absoluteFile = Paths.get(System.getProperty("user.dir"), path).toFile();
		if(absoluteFile.exists() && absoluteFile.isFile()) {
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream(absoluteFile));
			byte[] buffer = new byte[1000];
			int read;
			while((read = stream.read(buffer)) != -1) {
				this.out.write(buffer, 0, read);
			}
		} else {
			this.out.write("HTTP/1.1 404 Not found\r\n\r\nNot there".getBytes("utf-8"));
		}
		this.out.close();
	}
	
	
}
