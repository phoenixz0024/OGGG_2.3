package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class CalculatorController implements ActionListener
{
	CalculatorModel cm;
	static ArrayList<JButton> buttons = new ArrayList<JButton>();
	static JButton zero,A,B,C,D,E,F,point,divider,plus,min,multiply,divide,answer;
	static JComboBox baseMenu,pointFormatMenu;
	
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
	        if (e.getSource() == zero){
	            cm.addOperand("0");
	        } 
	        if (e.getSource() == buttons.get(0)){
	            cm.addOperand("1");
	        }
	        if (e.getSource() == buttons.get(1)){
	            cm.addOperand("2");
	        }
	        if (e.getSource() == buttons.get(2)){
	            cm.addOperand("3");
	        }
	        if (e.getSource() == buttons.get(3)){
	            cm.addOperand("4");
	        }
	        if (e.getSource() == buttons.get(4)){
	            cm.addOperand("5");
	        }
	        if (e.getSource() == buttons.get(5)){
	            cm.addOperand("6");
	        }
	        if (e.getSource() == buttons.get(6)){
	            cm.addOperand("7");
	        }
	        if (e.getSource() == buttons.get(7)){
	            cm.addOperand("8");
	        }
	        if (e.getSource() == buttons.get(8)){
	            cm.addOperand("9");
	        }
	        if (e.getSource() == point){
	            cm.addOperand(".");
	        }
	        if (e.getSource() == divider){
	            cm.addOperand("/");
	        }
	        if (e.getSource() == plus){
	            cm.add();
	        }
	        if (e.getSource() == min){
	            cm.subtract();
	        }
	        if (e.getSource() == multiply){
	            cm.multiply();
	        }
	        if (e.getSource() == divide){
	            cm.divide();
	        }
		}
	 
	 public static void addButtons()
		{
			//dropdown menu's for the format and base
			baseMenu = new JComboBox<String>();
			baseMenu.addItem("dec");
			baseMenu.addItem("bin");
			baseMenu.addItem("hex");
			baseMenu.addItem("oct");
			CalculatorView.buttonPanel.add(baseMenu);
			
			pointFormatMenu = new JComboBox<String>();
			pointFormatMenu.addItem("rat");
			pointFormatMenu.addItem("fixed");
			pointFormatMenu.addItem("float");
			CalculatorView.buttonPanel.add(pointFormatMenu);
			
			// .|=+-*/ 0
			point = new JButton(".");	
			divider = new JButton("|");		
			answer = new JButton("=");	
			zero = new JButton("0");	
			plus = new JButton("+");
			min = new JButton("-");
			multiply = new JButton("*");
			divide = new JButton("/");
			
			CalculatorView.buttonPanel.add(point);
			CalculatorView.buttonPanel.add(divider);
			CalculatorView.buttonPanel.add(answer);
			CalculatorView.buttonPanel.add(zero);
			CalculatorView.buttonPanel.add(plus);
			CalculatorView.buttonPanel.add(min);
			CalculatorView.buttonPanel.add(multiply);
			CalculatorView.buttonPanel.add(divide);
			
			
			// 1 to 9 and ABCDEF
			for(int i = 0;i<9;i++){
				buttons.add(new JButton(Integer.toString(i+1)));
				CalculatorView.buttonPanel.add(buttons.get(i));
				
				if(i == 2){
					A = new JButton("A");
					CalculatorView.buttonPanel.add(A);
					
					B = new JButton("B");
					CalculatorView.buttonPanel.add(B);
				}
				if(i==5){
					C = new JButton("C");
					CalculatorView.buttonPanel.add(C);
					
					D = new JButton("D");
					CalculatorView.buttonPanel.add(D);
				}
				if(i==8){
					E = new JButton("E");
					CalculatorView.buttonPanel.add(E);
					
					F = new JButton("F");
					CalculatorView.buttonPanel.add(F);
				}	
			}
		}
}
