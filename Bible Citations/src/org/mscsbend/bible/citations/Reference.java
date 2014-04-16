package org.mscsbend.bible.citations;

public interface Reference {
	Book getBook();
	
	int getChapter();
	
	int getVerse();
	
	int getLocation();
	
	Word getWord();
	void setWord(Word word);
	
	Reference getNext();
	void setNext(Reference next);

	Reference getPrevious();
	void setPrevious(Reference previous);

}
