package org.mscsbend.calculator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class CalculatorTests {
	private Character lastDigit;
	private int clearCount;
	private double shownResult;
	
	@Test
	public void testDigitPressed_AddsDigitToDisplay() {
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
			}

			@Override
			public void addDigit(char digit) {
				lastDigit = digit;
			}

			@Override
			public void showResult(double result) {
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		presenter.keyInput('1');
		assertThat(lastDigit, is('1'));
		presenter.keyInput('2');
		assertThat(lastDigit, is('2'));
		presenter.keyInput('.');
		assertThat(lastDigit, is('.'));
		presenter.keyInput('3');
		assertThat(lastDigit, is('3'));
	}
	
	@Test
	public void testNonDigitPressed_DoesNotAddDigitToDisplay() {
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
			}

			@Override
			public void addDigit(char digit) {
				lastDigit = digit;
			}

			@Override
			public void showResult(double result) {
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		presenter.keyInput('1');
		assertThat(lastDigit, is('1'));
		presenter.keyInput('a');
		assertThat(lastDigit, is('1'));
		presenter.keyInput('b');
		assertThat(lastDigit, is('1'));
		presenter.keyInput('c');
		assertThat(lastDigit, is('1'));
	}

	@Test
	public void testActionKeyPressed_ClearsDisplay() {
		
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
				clearCount++;
			}

			@Override
			public void addDigit(char digit) {
			}

			@Override
			public void showResult(double result) {
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		clearCount=0;
		presenter.keyInput('1');
		assertThat(clearCount, is(0));
		presenter.keyInput('+');
		assertThat(clearCount, is(1));
		presenter.keyInput('-');
		assertThat(clearCount, is(2));
		presenter.keyInput('*');
		assertThat(clearCount, is(3));
		presenter.keyInput('/');
		assertThat(clearCount, is(4));
	}

	@Test
	public void testEqualsKeyPressed_ShowsCorrectResult_ForAddition() {
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
			}

			@Override
			public void addDigit(char digit) {
			}

			@Override
			public void showResult(double result) {
				shownResult = result;
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		presenter.keyInput('2');
		presenter.keyInput('+');
		presenter.keyInput('2');
		presenter.keyInput('=');
		assertThat(shownResult, is(4d));
		presenter.keyInput('+');
		presenter.keyInput('2');
		presenter.keyInput('=');
		assertThat(shownResult, is(6d));
	}
	
	@Test
	public void testEqualsKeyPressed_ShowsCorrectResult_ForSubtraction() {
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
			}

			@Override
			public void addDigit(char digit) {
			}

			@Override
			public void showResult(double result) {
				shownResult = result;
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		presenter.keyInput('4');
		presenter.keyInput('4');
		presenter.keyInput('-');
		presenter.keyInput('1');
		presenter.keyInput('1');
		presenter.keyInput('=');
		assertThat(shownResult, is(33d));
		presenter.keyInput('-');
		presenter.keyInput('1');
		presenter.keyInput('1');
		presenter.keyInput('=');
		assertThat(shownResult, is(22d));
	}

	@Test
	public void testEqualsKeyPressed_ShowsCorrectResult_ForMultiplication() {
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
			}

			@Override
			public void addDigit(char digit) {
			}

			@Override
			public void showResult(double result) {
				shownResult = result;
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		presenter.keyInput('2');
		presenter.keyInput('*');
		presenter.keyInput('2');
		presenter.keyInput('=');
		assertThat(shownResult, is(4d));
		presenter.keyInput('*');
		presenter.keyInput('1');
		presenter.keyInput('0');
		presenter.keyInput('=');
		assertThat(shownResult, is(40d));
	}
	
	@Test
	public void testEqualsKeyPressed_ShowsCorrectResult_ForDivision() {
		CalculatorView view = new CalculatorView() {
			@Override
			public void clear() {
			}

			@Override
			public void addDigit(char digit) {
			}

			@Override
			public void showResult(double result) {
				shownResult = result;
			}
		};
		CalculatorPresenter presenter = CalculatorFactory.create(view);
		presenter.keyInput('6');
		presenter.keyInput('/');
		presenter.keyInput('2');
		presenter.keyInput('=');
		assertThat(shownResult, is(3d));
		presenter.keyInput('/');
		presenter.keyInput('3');
		presenter.keyInput('=');
		assertThat(shownResult, is(1d));
	}

}
