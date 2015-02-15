package ui;

public class CalculatorMVC 
{
	static CalculatorModel cm;
	static CalculatorView cv;
	static CalculatorController cc;
	
	public static void main(String[] args)
	{
		cm = new CalculatorModel();
		cc = new CalculatorController(cm);
		cv = new CalculatorView();
		cm.addActionListener(cv);
	}
}
