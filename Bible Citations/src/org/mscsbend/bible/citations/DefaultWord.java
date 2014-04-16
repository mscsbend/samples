package org.mscsbend.bible.citations;

public class DefaultWord implements Word {

	private String wordValue;
	
	@Override
	public String getValue() {
		return this.wordValue;
	}

	private  DefaultWord() {}
	
	public static Word create(String value) {
		DefaultWord word = new DefaultWord();
		word.wordValue = value;
		return word;
	}
	
}
