package org.mscsbend.bible.citations;

public class DefaultReference implements Reference {

	private Book book;
	private int chapter;
	private int verse;
	private int location;
	private Word word;
	private Reference next;
	private Reference previous;
	
	private DefaultReference(){}
	
	public static Reference create(Book book, int chapter, int verse, int location) {
		DefaultReference reference = new DefaultReference();
		reference.book = book;
		reference.chapter = chapter;
		reference.verse = verse;
		reference.location = location;
		return reference;
	}
	
	@Override
	public Book getBook() {
		return this.book;
	}

	@Override
	public int getChapter() {
		return this.chapter;
	}

	@Override
	public int getVerse() {
		return this.verse;
	}

	@Override
	public int getLocation() {
		return this.location;
	}

	@Override
	public Word getWord() {
		return this.word;
	}

	@Override
	public Reference getNext() {
		return this.next;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public void setNext(Reference next) {
		this.next = next;
	}

	@Override
	public Reference getPrevious() {
		return this.previous;
	}
	
	@Override
	public void setPrevious(Reference previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d:%d (%d)"
				, this.book.getName(), this.chapter, this.verse, this.location);
	}

}
