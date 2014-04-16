package org.mscsbend.bible.citations;

import javax.swing.SwingWorker;

public class Searcher extends SwingWorker<BibleSource, Object> {

	private String sentence;
	private BibleSource source;
	public Searcher(BibleSource source, String sentence) {
		this.source = source;
		this.sentence = sentence;
		
	}
	
	@Override
	protected BibleSource doInBackground() throws Exception {
		this.source.search(this.sentence);
		setProgress(100);
		return this.source;
	}

}
