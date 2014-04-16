package org.mscsbend.webserver;

import java.io.IOException;

public interface IHandler {
	public void retrieve(String path) throws IOException;
}
