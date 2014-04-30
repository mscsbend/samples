package org.mscsbend.calculator;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

public class SwingCalculatorView extends JPanel implements CalculatorView {
	private JTextField textField;
	public SwingCalculatorView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(20);
		
		JButton btnDivide = new JButton("/");
		GridBagConstraints gbc_btnDivide = new GridBagConstraints();
		gbc_btnDivide.fill = GridBagConstraints.BOTH;
		gbc_btnDivide.insets = new Insets(0, 0, 5, 5);
		gbc_btnDivide.gridx = 1;
		gbc_btnDivide.gridy = 1;
		add(btnDivide, gbc_btnDivide);
		
		JButton button_1 = new JButton("/");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 1;
		add(button_1, gbc_button_1);
		
		JButton btn1 = new JButton("7");
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 2;
		add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton("8");
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 2;
		add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton("9");
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 2;
		add(btn3, gbc_btn3);
		
		JButton btn4 = new JButton("4");
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 3;
		add(btn4, gbc_btn4);
		
		JButton btn5 = new JButton("5");
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 3;
		add(btn5, gbc_btn5);
		
		JButton btn6 = new JButton("6");
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 3;
		add(btn6, gbc_btn6);
		
		JButton btn7 = new JButton("1");
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 4;
		add(btn7, gbc_btn7);
		
		JButton btn8 = new JButton("2");
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 4;
		add(btn8, gbc_btn8);
		
		JButton btn9 = new JButton("3");
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 4;
		add(btn9, gbc_btn9);
		
		JButton btnEquals = new JButton("=");
		GridBagConstraints gbc_btnEquals = new GridBagConstraints();
		gbc_btnEquals.gridheight = 2;
		gbc_btnEquals.fill = GridBagConstraints.BOTH;
		gbc_btnEquals.gridx = 3;
		gbc_btnEquals.gridy = 4;
		add(btnEquals, gbc_btnEquals);
		
		JButton btn0 = new JButton("0");
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.gridwidth = 2;
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 0;
		gbc_btn0.gridy = 5;
		add(btn0, gbc_btn0);
		
		JButton button = new JButton(".");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.gridx = 2;
		gbc_button.gridy = 5;
		add(button, gbc_button);
		
		JButton btnPlus = new JButton("+");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDigit(char digit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showResult(double result) {
		// TODO Auto-generated method stub
		
	}

}
