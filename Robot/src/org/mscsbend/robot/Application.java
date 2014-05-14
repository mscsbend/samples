package org.mscsbend.robot;

import java.awt.EventQueue;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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
	private int elbowAngle = 45;
	private int direction = 1;
	private int fingerAngle = -90;
	private List<Integer> currentKeys;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		robotPanel = new RobotPanel();
		frame.getContentPane().add(robotPanel);
		currentKeys = new ArrayList<Integer>();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if(KeyEvent.KEY_PRESSED == e.getID()) {
					if(!currentKeys.contains(e.getKeyCode())) {
						currentKeys.add(Integer.valueOf(e.getKeyCode()));
					}
				} else { // Released
					currentKeys.remove(Integer.valueOf(e.getKeyCode()));
				}
				return false;
			}
		});
		Timer timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentKeys.contains(KeyEvent.VK_LEFT)) {
					shoulderAngle -= 1;
					if(shoulderAngle < -90) shoulderAngle = -90;
				}
				if(currentKeys.contains(KeyEvent.VK_RIGHT)) {
					shoulderAngle += 1;
					if(shoulderAngle > 90) shoulderAngle = 90;
				}
				if(currentKeys.contains(KeyEvent.VK_UP)) {
					elbowAngle -= 1;
					if(elbowAngle < -90) elbowAngle = -90;
				}	
				if(currentKeys.contains(KeyEvent.VK_DOWN)) {
					elbowAngle += 1;
					if(elbowAngle > 90) elbowAngle = 90;
				}
				if(currentKeys.contains(KeyEvent.VK_PAGE_UP)) {
					fingerAngle -= 1;
					if(fingerAngle < -90) fingerAngle = -90;
				}
				if(currentKeys.contains(KeyEvent.VK_PAGE_DOWN)) {
					fingerAngle += 1;
					if(fingerAngle > -18) fingerAngle = -18;
				}
				robotPanel.setShoulderAngle(shoulderAngle);
				robotPanel.setElbowAngle(elbowAngle);
				robotPanel.setFirstFingerAngle(fingerAngle);
				robotPanel.setSecondFingerAngle(-fingerAngle);
			}
		});
		timer.start();
	}

}
