package org.mscsbend.robot;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Application {

	private JFrame frame;
	private RobotPanel robotPanel;
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

	private int shoulderAngle = 45;
	private int direction = 1;
	private int fingerAngle = -90;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		robotPanel = new RobotPanel();
		frame.getContentPane().add(robotPanel);
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(shoulderAngle >= 45) {
					direction = -1;
				}
				if(shoulderAngle <= -45) {
					direction = 1;
				}
				robotPanel.setShoulderAngle(shoulderAngle+=direction);
				robotPanel.setElbowAngle(shoulderAngle*2);
				
				robotPanel.setFirstFingerAngle(fingerAngle-=direction);
				robotPanel.setSecondFingerAngle(-fingerAngle);
			}
		});
		timer.start();
	}

}
