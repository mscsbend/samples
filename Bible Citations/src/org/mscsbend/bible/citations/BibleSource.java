package org.mscsbend.bible.citations;

import java.util.List;

public interface BibleSource {

	List<Reference> getReferences();
	
	BibleSource filterBy(String word);
	
	BibleSource search(String sentence);
	
	BibleSource reset();

	Word getWord(String wordValue);
	
	Book getBook(String bookId);
	
	Reference addReference(String bookId, int chapter, int verse, int location);
}
