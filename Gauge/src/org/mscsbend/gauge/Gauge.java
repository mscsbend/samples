package org.mscsbend.gauge;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Gauge extends JPanel implements GaugeView {

	private int reading;
	private int minimum;
	private int maximum;
	private int interval;
	
	private static final String LEFT_ACTION = "left";
	private static final String RIGHT_ACTION = "right";

	/**
	 * Create the panel.
	 */
	public Gauge(int reading, int minimum, int maximum, int interval) {
		this.setReading(reading);
		this.setMinimum(minimum);
		this.setMaximum(maximum);
		this.setTickInterval(interval);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFocusable(true);
		getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), LEFT_ACTION);
		getActionMap().put(LEFT_ACTION, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				if(LEFT_ACTION == e.getActionCommand()) {
					if(getReading() <= getMinimum()) return;
					setReading(getReading()-getTickInterval());
//				} else if(RIGHT_ACTION == e.getActionCommand()) {
//					if(getReading() >= getMaximum()) return;
//					setReading(getReading()+getTickInterval());					
//				}
			}
		});
	}

	public Gauge() {
		this(70, 10, 120, 10);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		int size = Math.min(getHeight()*2, getWidth())/2;
		double scale = (double)size/100;
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 8);
		AffineTransform fontTransform = AffineTransform.getScaleInstance(scale, scale);
		g2d.setFont(font.deriveFont(fontTransform));
		g.translate(size, getHeight());
		g2d.rotate(-Math.PI/2);
		g2d.rotate(Math.toRadians(10));
		AffineTransform transform = g2d.getTransform();
		int padding = (int)(3*scale);
		g2d.setStroke(new BasicStroke(padding/3));
		// Draw ticks
		int stringHeight = g2d.getFontMetrics().getHeight();
		int tickLength = (int) (10*scale);
		for(int i=this.minimum; i<=this.maximum; i+=this.interval) {
			g2d.rotate(Math.toRadians(160*(i-this.minimum)/(this.maximum-this.minimum)));
			String indication = Integer.toString(i);
			int stringWidth = (int)g2d.getFontMetrics().getStringBounds(indication, g).getWidth();
			
			g2d.setColor(Color.WHITE);
			g2d.drawString(Integer.toString(i), -stringWidth/2, -size+tickLength);
			
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.drawLine(0, -size+stringHeight+padding, 0, -size+tickLength+stringHeight+padding);
			g2d.setTransform(transform);
		}
		g2d.setTransform(transform);
		// Needle angle
		double needleAngle = Math.toRadians(160*(this.reading-this.minimum)/(this.maximum-this.minimum));
		g2d.rotate(needleAngle);
		// Draw the needle
		Polygon needle = new Polygon(new int[]{-padding, padding, 0}, new int[]{0, 0, (int)(-size+tickLength+stringHeight+2*padding)}, 3);
		g2d.setColor(Color.RED);
		g2d.fillPolygon(needle);
		g2d.setTransform(transform);
	}

	@Override
	public void setReading(int reading) {
		this.reading = reading;
		repaint();
	}

	@Override
	public int getReading() {
		return this.reading;
	}
	
	@Override
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	@Override
	public int getMinimum() {
		return this.minimum;
	}
	
	@Override
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	@Override
	public int getMaximum() {
		return this.maximum;
	}
	
	@Override
	public void setTickInterval(int interval) {
		this.interval = interval;
	}
	
	@Override
	public int getTickInterval() {
		return this.interval;
	}

}
