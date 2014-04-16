package org.mscsbend.bible.citations;

import java.util.StringTokenizer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BibleSourceHandler extends DefaultHandler {

	enum State {
		INIT,
		BOOK,
		CHAPTER,
		VERSE
	}

	private BibleSource source;
	private Book book;
	private int chapter;
	private int verse;
	private int location;
	private State state = State.INIT;
	private Reference reference;
	
	private BibleSourceHandler() {
		this.source = DefaultBibleSource.create();
	}
	
	public static BibleSourceHandler create() {
		return new BibleSourceHandler();
	}
	
	public BibleSource getBibleSource() {
		return this.source;
	}
	
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		if(qName.equals("book")) {
			this.book = source.getBook(attributes.getValue("id"));
			this.state = State.BOOK;
		} else if(qName.equals("c")) {
			this.chapter = Integer.parseInt(attributes.getValue("id"));
			this.state = State.CHAPTER;
		} else if(qName.equals("v")) {
			try {
				this.verse = Integer.parseInt(attributes.getValue("id"));
			} catch (NumberFormatException e) {
//				e.printStackTrace();
			}
			this.location = 1;
			this.state = State.VERSE;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(state == State.VERSE) {
			StringTokenizer tokenizer = new StringTokenizer(new String(ch, start, length));
			while(tokenizer.hasMoreTokens()) {
				String wordValue = tokenizer.nextToken().replaceAll("[^a-zA-Z0-9\\s]", "");
				Reference reference = source.addReference(this.book.getName(), chapter, verse, location++);
				
				reference.setWord(source.getWord(wordValue));
				if(this.reference != null) {
					this.reference.setNext(reference);
					reference.setPrevious(this.reference);
				}
				this.reference = reference;
			}
		}
	}
	

}
