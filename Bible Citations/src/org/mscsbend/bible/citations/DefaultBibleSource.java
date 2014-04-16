package org.mscsbend.bible.citations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DefaultBibleSource implements BibleSource {
	protected List<Reference> references;
	protected List<Reference> filtered;
	protected Word current;
	protected Map<String, Word> words;
	protected Map<String, Book> books;
	protected List<Word> filterChain;

	private DefaultBibleSource(){
		this.words = new HashMap<String, Word>();
		this.books = new HashMap<String, Book>();
		this.references = new ArrayList<Reference>();
		this.filtered = new ArrayList<Reference>();
		this.filterChain = new ArrayList<Word>();
	}
	
	public static BibleSource create() {
		return new DefaultBibleSource();
	}
	
	@Override
	public BibleSource filterBy(String wordValue) {
		Word word = this.words.get(wordValue.toLowerCase());
		this.filterChain.add(word);
		List<Reference> toRemoveFromFiltered = new ArrayList<Reference>();
		for(Iterator<Reference> it = this.filtered.iterator(); it.hasNext();) {
			Reference reference = it.next();
			Reference next = reference.getNext();
			boolean match = true; 
			for(Word filter: this.filterChain) {
				if(next == null || next.getWord() != filter) {
					match = false;
					break;
				}
				next = next.getNext();
			}
			if(!match) {
				toRemoveFromFiltered.add(reference);
			}
		}
		this.filtered.removeAll(toRemoveFromFiltered);
		return this;
	}
	
	@Override
	public BibleSource reset() {
		this.filtered = new ArrayList<Reference>(this.references);
		this.filterChain.clear();
		return this;
	}

	@Override
	public List<Reference> getReferences() {
		return this.filtered;
	}

	@Override
	public Word getWord(String wordValue) {
		Word word;
		String value = wordValue.toLowerCase();
		if(!this.words.containsKey(value)) {
			word = DefaultWord.create(value);
			this.words.put(value, word);
		} else {
			word = this.words.get(value);
		}
		return word;
	}

	@Override
	public Book getBook(String bookId) {
		Book book;
		String name = bookId.toUpperCase();
		if(!this.books.containsKey(name)) {
			book = DefaultBook.create(name);
		} else {
			book = this.books.get(name);
		}
		return book;
	}

	@Override
	public Reference addReference(String bookId, int chapter, int verse,
			int location) {
		Reference reference = DefaultReference.create(getBook(bookId), chapter, verse, location);
		this.references.add(reference);
		return reference;
	}

	@Override
	public BibleSource search(String sentence) {
		this.reset();
		StringTokenizer tokenizer = new StringTokenizer(sentence);
		while(tokenizer.hasMoreElements()) {
			String word = tokenizer.nextToken();
			this.filterBy(word);
		}
		return this;
	}
}
