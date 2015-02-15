package ui;

import java.awt.Color;

public class CalculatorMVC 
{
	static CalculatorModel cm;
	static CalculatorView cv;
	static CalculatorController cc;
	
	public static void main(String[] args)
	{
		cv = new CalculatorView(Color.blue);
		cm = new CalculatorModel();
		cc = new CalculatorController(cm);
		
		cm.addActionListener(cv);
	}
}
