package org.mscsbend.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class Application {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Swing Calculator");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Application.class.getResource("/org/mscsbend/calculator/Application.icon.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CalculatorPresenter presenter = CalculatorFactory.create();
		SwingCalculatorView view = new SwingCalculatorView(presenter);
		frame.getContentPane().add(view);
	}

}
