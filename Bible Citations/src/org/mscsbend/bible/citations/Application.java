package org.mscsbend.bible.citations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.SwingWorker;

import java.awt.Font;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Application {

	private JFrame frmBibleSearch;
	private JTextField txtSearch;
	private JScrollPane scrollResult;
	private JList listResult;
	private JTextPane txtpnVerse;

	private BibleSource source;
	private final JPanel panelStatus = new JPanel();
	private JLabel lblStatus;
	private ReferencesListModel listModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmBibleSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setSource(BibleSource source) {
		this.source = source;
	}
	
	public BibleSource getSource() {
		return source;
	}
	
	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
		final BibleLoader loader = new BibleLoader();
		loader.execute();
		lblStatus.setText("Loading ...");
		loader.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if("progress".equals(evt.getPropertyName()) && evt.getNewValue().equals(100)) {
					lblStatus.setText("Loading complete");
					try {
						setSource(loader.get());
						listModel = new ReferencesListModel(getSource());
						listResult.setModel(listModel);
					} catch (Exception e) {
						lblStatus.setText(String.format("Loading failed: %s, %s", e.getClass().getName(), e.getMessage()));
					}
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibleSearch = new JFrame();
		frmBibleSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(Application.class.getResource("/org/mscsbend/bible/citations/Application.icon.png")));
		frmBibleSearch.setTitle("Bible Search");
		frmBibleSearch.setBounds(100, 100, 450, 300);
		frmBibleSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtSearch = new JTextField();
		txtSearch.setText("formless and empty");
		txtSearch.getDocument().addDocumentListener(new DocumentListener(){

			private void search(DocumentEvent e) {
				lblStatus.setText("Searching ...");
				listModel.fireChanged();
				final Searcher searcher = new Searcher(getSource(), txtSearch.getText());
				searcher.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if("progress".equals(evt.getPropertyName()) && evt.getNewValue().equals(100)) {
							lblStatus.setText("Searching complete");
						}
					}
				});
				searcher.execute();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(e);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(e);
			}
			
		});
		frmBibleSearch.getContentPane().add(txtSearch, BorderLayout.NORTH);
		txtSearch.setColumns(10);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		splitPane.setOneTouchExpandable(true);
		frmBibleSearch.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		listResult = new JList();
		scrollResult = new JScrollPane(listResult);
		listResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResult.setModel(new AbstractListModel() {
			String[] values = new String[] {"GEN 1:2 (4)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listResult.setSelectedIndex(0);
		splitPane.setLeftComponent(scrollResult);
		
		txtpnVerse = new JTextPane();
		txtpnVerse.setEditable(false);
		txtpnVerse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnVerse.setContentType("text/html");
		txtpnVerse.setText("<html>\r\n<head>\r\n\t<style>\r\n\t\tdiv {\r\n\t\t\tfont-family: sans-serif;\r\n\t\t}\r\n\t</style>\r\n</head>\r\n<body>\r\n<div>The earth was <strong>formless and empty</strong>. Darkness was on the surface of the deep and God\u2019s Spirit was hovering over the surface of the waters.<div>\r\n<body>\r\n</html>");
		splitPane.setRightComponent(txtpnVerse);
		FlowLayout fl_panelStatus = (FlowLayout) panelStatus.getLayout();
		fl_panelStatus.setAlignment(FlowLayout.LEFT);
		frmBibleSearch.getContentPane().add(panelStatus, BorderLayout.SOUTH);
		
		lblStatus = new JLabel(" ");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		panelStatus.add(lblStatus);
	}

}
