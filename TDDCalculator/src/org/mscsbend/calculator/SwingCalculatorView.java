package org.mscsbend.calculator;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Position;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SwingCalculatorView extends JPanel implements CalculatorView {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private CalculatorPresenter presenter;
	private ActionListener actionListener;
	public SwingCalculatorView(CalculatorPresenter presenter) {
		this.presenter = presenter;
		this.presenter.setView(this);
		this.actionListener = new ButtonClickedActionListener(this.presenter);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(20);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(this.actionListener);
		GridBagConstraints gbc_btnDivide = new GridBagConstraints();
		gbc_btnDivide.fill = GridBagConstraints.BOTH;
		gbc_btnDivide.insets = new Insets(0, 0, 5, 5);
		gbc_btnDivide.gridx = 1;
		gbc_btnDivide.gridy = 1;
		add(btnDivide, gbc_btnDivide);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(this.actionListener);
		GridBagConstraints gbc_btnMultiply = new GridBagConstraints();
		gbc_btnMultiply.fill = GridBagConstraints.BOTH;
		gbc_btnMultiply.insets = new Insets(0, 0, 5, 5);
		gbc_btnMultiply.gridx = 2;
		gbc_btnMultiply.gridy = 1;
		add(btnMultiply, gbc_btnMultiply);
		
		JButton btnSubtract = new JButton("-");
		btnSubtract.addActionListener(this.actionListener);
		GridBagConstraints gbc_btnSubtract = new GridBagConstraints();
		gbc_btnSubtract.fill = GridBagConstraints.BOTH;
		gbc_btnSubtract.insets = new Insets(0, 0, 5, 0);
		gbc_btnSubtract.gridx = 3;
		gbc_btnSubtract.gridy = 1;
		add(btnSubtract, gbc_btnSubtract);
		
		JButton btn1 = new JButton("7");
		btn1.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 2;
		add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton("8");
		btn2.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 2;
		add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton("9");
		btn3.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 2;
		add(btn3, gbc_btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 3;
		add(btn4, gbc_btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 3;
		add(btn5, gbc_btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 3;
		add(btn6, gbc_btn6);
		
		JButton btn7 = new JButton("1");
		btn7.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 4;
		add(btn7, gbc_btn7);
		
		JButton btn8 = new JButton("2");
		btn8.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 4;
		add(btn8, gbc_btn8);
		
		JButton btn9 = new JButton("3");
		btn9.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 4;
		add(btn9, gbc_btn9);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(this.actionListener);
		GridBagConstraints gbc_btnEquals = new GridBagConstraints();
		gbc_btnEquals.gridheight = 2;
		gbc_btnEquals.fill = GridBagConstraints.BOTH;
		gbc_btnEquals.gridx = 3;
		gbc_btnEquals.gridy = 4;
		add(btnEquals, gbc_btnEquals);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(this.actionListener);
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.gridwidth = 2;
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 0;
		gbc_btn0.gridy = 5;
		add(btn0, gbc_btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(this.actionListener);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.gridx = 2;
		gbc_button.gridy = 5;
		add(btnDot, gbc_button);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(this.actionListener);
		GridBagConstraints gbc_btnPlus = new GridBagConstraints();
		gbc_btnPlus.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlus.fill = GridBagConstraints.BOTH;
		gbc_btnPlus.gridheight = 2;
		gbc_btnPlus.gridx = 3;
		gbc_btnPlus.gridy = 2;
		add(btnPlus, gbc_btnPlus);
	}

	@Override
	public void clear() {
		this.textField.setText("");
	}

	@Override
	public void addDigit(char digit) {
		Document document = this.textField.getDocument();
		Position offset = document.getEndPosition();
		try {
			this.textField.getDocument().insertString(offset.getOffset()-1, Character.toString(digit), null);
		} catch (BadLocationException e) {
			// Nah, this will never happen
		}
	}

	@Override
	public void showResult(double result) {
		this.textField.setText(Double.toString(result));
	}

	private class ButtonClickedActionListener implements ActionListener {

		private CalculatorPresenter presenter;
		public ButtonClickedActionListener(CalculatorPresenter presenter) {
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			presenter.keyInput(((JButton)e.getSource()).getText().charAt(0));
		}
		
	}
}
