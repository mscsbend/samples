package org.mscsbend.bible.citations;

public class DefaultBook implements Book {

	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}

	private DefaultBook(){}
	
	public static Book create(String name) {
		DefaultBook book = new DefaultBook();
		book.name = name;
		return book;
	}
}
