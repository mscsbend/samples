package org.mscsbend.bible.citations;

import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		InputStream bibleStream = Main.class.getResourceAsStream("/eng-web_usfx.xml");
		BibleSource bibleSource = new BibleSourceFactory().create(bibleStream);
		for(String arg: args) {
			bibleSource.filterBy(arg);
		}
		for(Reference reference: bibleSource.getReferences()) {
			System.out.println(reference);
		}
	}

}
