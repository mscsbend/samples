package org.mscsbend.gauge;

public interface GaugeView {

	public void setReading(int reading);
	public void setMinimum(int minimum);
	public void setMaximum(int maximum);
	public void setTickInterval(int interval);
	public int getReading();
	public int getMinimum();
	public int getMaximum();
	public int getTickInterval();
}
