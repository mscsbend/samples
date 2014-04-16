package org.mscsbend.bible.citation;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mscsbend.bible.citations.BibleSource;
import org.mscsbend.bible.citations.BibleSourceFactory;
import org.mscsbend.bible.citations.Reference;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;

public class TestBibleSource {

	@Test
	public void testCreate() throws Exception {
		long beginRead = System.currentTimeMillis();
		InputStream bibleStream = getClass().getResourceAsStream("/eng-web_usfx.xml");
		long endRead = System.currentTimeMillis();
		System.out.println(String.format("%6d Reading the resource", endRead-beginRead));
		long beginParse = System.currentTimeMillis();
		BibleSource bibleSource = new BibleSourceFactory().create(bibleStream);
		long endParse = System.currentTimeMillis();
		System.out.println(String.format("%6d Parsing the resource", endParse-beginParse));
		List<Reference> beginningSet = search("in the beginning", bibleSource);
		List<Reference> beginningAndEndSet = search("beginning and the end", bibleSource);
		List<Reference> alphaAndOmega = search("the alpha and the omega", bibleSource);
	}
	
	private List<Reference> search(String sentence, BibleSource source) {
		source.reset();
		long beginFilter = System.currentTimeMillis();			
		StringTokenizer tokenizer = new StringTokenizer(sentence);
		while(tokenizer.hasMoreElements()) {
			String word = tokenizer.nextToken();
			source.filterBy(word);
		}
		List<Reference> result = source.getReferences();
		long endFilter = System.currentTimeMillis();	
		System.out.println(String.format("%6d Filtering the resource on \"%s\"", endFilter-beginFilter, sentence));			
		for(Reference reference: result) {
			System.out.println(reference);
		}
		return result;
	}
}
