package org.mscsbend.calculator;

public interface CalculatorView {
	public void clear();
	public void addDigit(char digit);
	public void showResult(double result);
}
