package org.mscsbend.bible.citations;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class BibleSourceFactory {
	
	public BibleSource create(InputStream input) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		
		BibleSourceHandler handler = BibleSourceHandler.create();
		saxParser.parse(input, handler);
		BibleSource result = handler.getBibleSource();
		result.reset();
		return result;
	}
}
