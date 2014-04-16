package org.mscsbend.bible.citations;

import java.io.InputStream;

import javax.swing.SwingWorker;

public class BibleLoader extends SwingWorker<BibleSource, Object> {

	public BibleLoader() {
	}
	
	@Override
	protected BibleSource doInBackground() throws Exception {
		InputStream bibleStream = Main.class.getResourceAsStream("/eng-web_usfx.xml");
		BibleSource result = null;
		try {
			result = new BibleSourceFactory().create(bibleStream);
		} finally {
			setProgress(100);
		}
		return result;
	}
	

}
