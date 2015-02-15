package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController extends CalculatorView implements ActionListener
{
	CalculatorModel cm;
	
	public CalculatorController(CalculatorModel c)
	{
		cm = c;

		for(int i = 0;i<9;i++){
			buttons.get(i).addActionListener(this);
		}
		
		A.addActionListener(this);
		B.addActionListener(this);
		C.addActionListener(this);
		D.addActionListener(this);
		E.addActionListener(this);
		F.addActionListener(this);
		
		point.addActionListener(this);
		divider.addActionListener(this);
		answer.addActionListener(this);
		zero.addActionListener(this);
		plus.addActionListener(this);
		min.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		
		baseMenu.addActionListener(this);
		pointFormatMenu.addActionListener(this);

	}
	
	 public void actionPerformed(ActionEvent e)
	    {
	        if (e.getSource() == A){
	            cm.addOperand("A");
	        } 
	        if (e.getSource() == B){
	            cm.addOperand("B");
	        } 
	        if (e.getSource() == C){
	            cm.addOperand("C");
	        } 
	        if (e.getSource() == D){
	            cm.addOperand("D");
	        } 
	        if (e.getSource() == E){
	            cm.addOperand("E");
	        } 
	        if (e.getSource() == F){
	            cm.addOperand("F");
	        } 
	        if (e.getSource() == buttons.get(0)){
	            cm.addOperand("1");
	        }
		}
}
