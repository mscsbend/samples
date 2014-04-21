package org.mscsbend.calculator;

public class CalculatorPresenterImplementation implements CalculatorPresenter {

	private CalculatorView view;
	private double result;
	StringBuffer buffer;
	private double operant;
	private char action;
	
	public CalculatorPresenterImplementation() {
		this.buffer = new StringBuffer();
	}

	public CalculatorView getView() {
		return view;
	}

	public void setView(CalculatorView view) {
		this.view = view;
	}

	@Override
	public void keyInput(char key) {
		if(Character.isDigit(key)) {
			this.buffer.append(key);
			this.view.addDigit(key);
		} else if(isAction(key)) {
			this.action = key;
			if(this.buffer.length()>0) {
				this.operant = Double.parseDouble(this.buffer.toString());
			}
			this.buffer.setLength(0);
			this.view.clear();
		} else if(isEquals(key)) {
			if(this.buffer.length()>0) {
				this.result = this.operant;
				this.operant = Double.parseDouble(this.buffer.toString());
			}
			this.buffer.setLength(0);
			if('+' == this.action) {
				this.result += this.operant;
			} else if('-' == this.action) {
				this.result -= this.operant;
			} else if('*' == this.action) {
				this.result *= this.operant;
			} else if('/' == this.action) {
				this.result /= this.operant;
			}
			this.operant = this.result;
			this.view.showResult(result);
		}
	}

	private boolean isEquals(char key) {
		return key == '=';
	}

	private boolean isAction(char key) {
		return('+' == key || '-' == key || '*' == key || '/' == key);
	}

	
}
