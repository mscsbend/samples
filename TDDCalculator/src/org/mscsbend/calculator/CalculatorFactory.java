package org.mscsbend.calculator;

public class CalculatorFactory {

	public static CalculatorPresenter create() {
		return new CalculatorPresenterImplementation();
	}
	
	public static CalculatorPresenter create(CalculatorView view) {
		CalculatorPresenter presenter = create();
		presenter.setView(view);
		return presenter;
	}
	
}
