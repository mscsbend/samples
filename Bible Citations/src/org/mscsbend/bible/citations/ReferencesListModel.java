package org.mscsbend.bible.citations;

import javax.swing.AbstractListModel;

public class ReferencesListModel extends AbstractListModel<Reference> {

	private static final long serialVersionUID = 1L;
	
	private BibleSource source;
	
	public ReferencesListModel(BibleSource source) {
		this.source = source;
	}
	
	@Override
	public int getSize() {
		return this.source.getReferences().size();
	}

	@Override
	public Reference getElementAt(int index) {
		return this.source.getReferences().get(index);
	}
	
	public void fireChanged() {
		fireContentsChanged(this.source, 0, getSize()-1);
	}

}
