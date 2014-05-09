package org.mscsbend.robot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class RobotPanel extends JPanel implements RobotView {

	private int shoulderAngle;
	private int elbowAngle;
	private int firstFingerAngle;
	private int firstFingerLowerAngle;
	private int secondFingerAngle;
	private int secondFingerLowerAngle;
	
	/**
	 * Create the panel.
	 */
	public RobotPanel() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setDoubleBuffered(true);
		this.shoulderAngle=90;
		this.elbowAngle=45;
		this.firstFingerAngle=-45;
		this.firstFingerLowerAngle=45;
		this.secondFingerAngle=45;
		this.secondFingerLowerAngle=-45;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		double scale = (double)Math.min(getWidth(), getHeight())/150;
		Point center = new Point(getWidth()/2, getHeight()/2);
		g2.translate(center.x, center.y);
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scale, scale);
		g2.transform(scaleTransform);
		
		// Shoulder angle
		AffineTransform rotateShoulderTransform = AffineTransform.getRotateInstance(Math.toRadians(this.shoulderAngle));
		g2.transform(rotateShoulderTransform);

		// Draw upper arm and shoulder
		Polygon arm = new Polygon(new int[]{-10, -5, 5, 10}, new int[]{0, -30, -30, 0}, 4);
		g2.setColor(Color.GRAY);
		g2.fillPolygon(arm);
		g2.setColor(Color.DARK_GRAY);
		g2.drawPolygon(arm);
		g2.setColor(Color.GRAY);
		g2.fillOval(-10, -10, 20, 20);
		g2.setColor(Color.DARK_GRAY);
		g2.drawOval(-10, -10, 20, 20);
		
		// Locate elbow
		g2.translate(0, -30);

		// Elbow angle
		AffineTransform rotateElbowTransform = AffineTransform.getRotateInstance(Math.toRadians(this.elbowAngle));
		g2.transform(rotateElbowTransform);

		// Draw forearm and elbow
		Polygon arm2 = new Polygon(new int[]{-5, -2, 2, 5}, new int[]{0, -30, -30, 0}, 4);
		g2.setColor(Color.GRAY);
		g2.fillPolygon(arm2);
		g2.setColor(Color.DARK_GRAY);
		g2.drawPolygon(arm2);
		g2.setColor(Color.GRAY);
		g2.fillOval(-5, -5, 10, 10);
		g2.setColor(Color.DARK_GRAY);
		g2.drawOval(-5, -5, 10, 10);
		
		// Locate first finger
		g2.translate(-2, -30);
		
		// Save straight angle
		AffineTransform straightFingerTransform = g2.getTransform();
		
		// First finger angle
		AffineTransform rotateFinger1Transform = AffineTransform.getRotateInstance(Math.toRadians(this.firstFingerAngle));
		g2.transform(rotateFinger1Transform);		
		
		// Draw first finger
		g2.setColor(Color.GRAY);
		Polygon finger1 = new Polygon(new int[]{-1, -1, 1, 1}, new int[]{0, -10, -10, 0}, 4);
		g2.fillPolygon(finger1);
		g2.setColor(Color.DARK_GRAY);
		g2.drawPolygon(finger1);

		// Locate first finger joint
		g2.translate(0.5, 0);
		
		// Draw first finger joint
		g2.setColor(Color.GRAY);
		g2.fillOval(-2, -2, 3, 3);
		g2.setColor(Color.DARK_GRAY);
		g2.drawOval(-2, -2, 3, 3);
		
		// Locate first finger lower part
		g2.translate(-0.5, -10);
		
		// First finger lower part angle
		AffineTransform rotateFinger12Transform = AffineTransform.getRotateInstance(Math.toRadians(this.firstFingerLowerAngle));
		g2.transform(rotateFinger12Transform);
				
		// Draw first finger lower part
		g2.setColor(Color.GRAY);
		Polygon finger12 = new Polygon(new int[]{-1, 0, 0, 1}, new int[]{0, -10, -10, 0}, 4);
		g2.fillPolygon(finger12);
		g2.setColor(Color.DARK_GRAY);
		g2.drawPolygon(finger12);
		
		// Locate first finger lower joint
		g2.translate(0.5, 0);
		
		// Draw first finger lower joint
		g2.setColor(Color.GRAY);
		g2.fillOval(-2, -2, 3, 3);
		g2.setColor(Color.DARK_GRAY);
		g2.drawOval(-2, -2, 3, 3);		
		
		// Restore straight finger angle
		g2.setTransform(straightFingerTransform);
		
		// Locate second finger
		g2.translate(4, 0);
		
		// Second finger angle
		AffineTransform rotateFinger2Transform = AffineTransform.getRotateInstance(Math.toRadians(this.secondFingerAngle));
		g2.transform(rotateFinger2Transform);		
		
		// Draw second finger
		g2.setColor(Color.GRAY);
		Polygon finger2 = new Polygon(new int[]{-1, -1, 1, 1}, new int[]{0, -10, -10, 0}, 4);
		g2.fillPolygon(finger2);
		g2.setColor(Color.DARK_GRAY);
		g2.drawPolygon(finger2);
		
		// Locate second finger joint
		g2.translate(0.5, 0);
		
		// Draw second finger joint
		g2.setColor(Color.GRAY);
		g2.fillOval(-2, -2, 3, 3);
		g2.setColor(Color.DARK_GRAY);
		g2.drawOval(-2, -2, 3, 3);
		
		// Locate second finger lower part
		g2.translate(-0.5, -10);
		
		// First finger lower part angle
		AffineTransform rotateFinger22Transform = AffineTransform.getRotateInstance(Math.toRadians(this.secondFingerLowerAngle));
		g2.transform(rotateFinger22Transform);
				
		// Draw first finger lower part
		g2.setColor(Color.GRAY);
		Polygon finger22 = new Polygon(new int[]{-1, 0, 0, 1}, new int[]{0, -10, -10, 0}, 4);
		g2.fillPolygon(finger22);
		g2.setColor(Color.DARK_GRAY);
		g2.drawPolygon(finger22);

		// Locate second finger lower joint
		g2.translate(0.5, 0);
		
		// Draw second finger lower joint
		g2.setColor(Color.GRAY);
		g2.fillOval(-2, -2, 3, 3);
		g2.setColor(Color.DARK_GRAY);
		g2.drawOval(-2, -2, 3, 3);		

		// Restore straight finger angle
		g2.setTransform(straightFingerTransform);

	}

	@Override
	public void setShoulderAngle(int angle) {
		this.shoulderAngle = angle;
		repaint();
	}

	@Override
	public void setElbowAngle(int angle) {
		this.elbowAngle = angle;
		repaint();
	}

	@Override
	public void setFirstFingerAngle(int angle) {
		this.firstFingerAngle = angle;
		repaint();
	}

	@Override
	public void setFirstFingerLowerAngle(int angle) {
		this.firstFingerLowerAngle = angle;
		repaint();
	}

	@Override
	public void setSecondFingerAngle(int angle) {
		this.secondFingerAngle = angle;
		repaint();
	}

	@Override
	public void setSecondFingerLowerAngle(int angle) {
		this.secondFingerLowerAngle = angle;
		repaint();
	}

	
}
