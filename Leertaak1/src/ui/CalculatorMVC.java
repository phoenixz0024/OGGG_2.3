package ui;

import java.awt.Color;

/**
 * MVC for the Calculator
 * @author Kas Feenema
 * @author Rafael van den Berg
 * @version 1.0
 */
public class CalculatorMVC 
{
	static CalculatorModel cm;
	static CalculatorView cv;
	static CalculatorController cc;
	
	/**
	 * Init
	 * @param args
	 */
	public static void main(String[] args)
	{
		cv = new CalculatorView(Color.black);
		cm = new CalculatorModel();
		cc = new CalculatorController(cm);
		cm.addActionListener(cv);
	}
}
