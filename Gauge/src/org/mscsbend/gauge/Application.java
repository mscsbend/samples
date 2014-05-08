package org.mscsbend.gauge;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

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
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 515, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {300, 300};
		gridBagLayout.rowHeights = new int[]{220, -39, 139, 23, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		Gauge gaugeSpeed = new Gauge();
		GridBagConstraints gbc_gaugeSpeed = new GridBagConstraints();
		gbc_gaugeSpeed.gridwidth = 2;
		gbc_gaugeSpeed.insets = new Insets(0, 0, 5, 0);
		gbc_gaugeSpeed.fill = GridBagConstraints.BOTH;
		gbc_gaugeSpeed.gridx = 0;
		gbc_gaugeSpeed.gridy = 0;
		frame.getContentPane().add(gaugeSpeed, gbc_gaugeSpeed);
		
		JLabel lblSpeed = new JLabel("Speed [mph]");
		lblSpeed.setLabelFor(gaugeSpeed);
		lblSpeed.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.gridwidth = 2;
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpeed.gridx = 0;
		gbc_lblSpeed.gridy = 1;
		frame.getContentPane().add(lblSpeed, gbc_lblSpeed);
		
		Gauge gaugeAv = new Gauge();
		gaugeAv.setTickInterval(1);
		gaugeAv.setMaximum(10);
		gaugeAv.setMinimum(0);
		gaugeAv.setReading(2);
		GridBagConstraints gbc_gaugeAv = new GridBagConstraints();
		gbc_gaugeAv.insets = new Insets(0, 0, 5, 5);
		gbc_gaugeAv.fill = GridBagConstraints.BOTH;
		gbc_gaugeAv.gridx = 0;
		gbc_gaugeAv.gridy = 2;
		frame.getContentPane().add(gaugeAv, gbc_gaugeAv);
		
		final Gauge gaugeFe = new Gauge();
		gaugeFe.setTickInterval(10);
		gaugeFe.setReading(26);
		gaugeFe.setMinimum(0);
		gaugeFe.setMaximum(60);
		
		
		GridBagConstraints gbc_gaugeFe = new GridBagConstraints();
		gbc_gaugeFe.weightx = 0.5;
		gbc_gaugeFe.insets = new Insets(0, 0, 5, 0);
		gbc_gaugeFe.fill = GridBagConstraints.BOTH;
		gbc_gaugeFe.gridx = 1;
		gbc_gaugeFe.gridy = 2;
		frame.getContentPane().add(gaugeFe, gbc_gaugeFe);
		
		JLabel lblAv = new JLabel("Angular Velocity [rpm x 1,000]");
		lblAv.setLabelFor(gaugeAv);
		lblAv.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAv = new GridBagConstraints();
		gbc_lblAv.insets = new Insets(0, 0, 0, 5);
		gbc_lblAv.gridx = 0;
		gbc_lblAv.gridy = 3;
		frame.getContentPane().add(lblAv, gbc_lblAv);
		
		JLabel lblFe = new JLabel("Fuel Efficiency [mpg]");
		lblFe.setLabelFor(gaugeFe);
		lblFe.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblFe = new GridBagConstraints();
		gbc_lblFe.gridx = 1;
		gbc_lblFe.gridy = 3;
		frame.getContentPane().add(lblFe, gbc_lblFe);
	}

}
