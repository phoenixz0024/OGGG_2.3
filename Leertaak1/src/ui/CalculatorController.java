package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class CalculatorController implements ActionListener
{
	public static CalculatorModel cm;
	static ArrayList<JButton> buttons = new ArrayList<JButton>();
	static JButton zero,A,B,C,D,E,F,point,divider,plus,min,multiply,divide,answer, clear;
	static JComboBox baseMenu,pointFormatMenu;
	static String currentOperand = "";
	static String Operator = "";
	
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
		clear.addActionListener(this);
		
		baseMenu.addActionListener(this);
		pointFormatMenu.addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e)
	 {
		CalculatorModel.done = false;
		//CalculatorController.currentOperand = "";
		cm.update();
	        if (e.getSource() == A){
	        	currentOperand += "A";
	        } 
	        if (e.getSource() == B){
	        	currentOperand += "B";
	        } 
	        if (e.getSource() == C){
	        	currentOperand += "C";
	        } 
	        if (e.getSource() == D){
	        	currentOperand += "D";
	        } 
	        if (e.getSource() == E){
	        	currentOperand += "E";
	        } 
	        if (e.getSource() == F){
	        	currentOperand += "F";
	        } 
	        if (e.getSource() == zero){
	        	currentOperand += "0";
	        } 
	        if (e.getSource() == buttons.get(0)){
	        	currentOperand += "1";
	        }
	        if (e.getSource() == buttons.get(1)){
	        	currentOperand += "2";
	        }
	        if (e.getSource() == buttons.get(2)){
	        	currentOperand += "3";
	        }
	        if (e.getSource() == buttons.get(3)){
	        	currentOperand += "4";
	        }
	        if (e.getSource() == buttons.get(4)){
	        	currentOperand += "5";
	        }
	        if (e.getSource() == buttons.get(5)){
	        	currentOperand += "6";
	        }
	        if (e.getSource() == buttons.get(6)){
	        	currentOperand += "7";
	        }
	        if (e.getSource() == buttons.get(7)){
	        	currentOperand += "8";
	        }
	        if (e.getSource() == buttons.get(8)){
	        	currentOperand += "9";
	        }
	        if (e.getSource() == point){
	        	if(!currentOperand.contains("."))
	        	currentOperand += ".";
	        	else{
	        		CalculatorView.message.setText("Operand already contains a \".\"");
	        	}
	        }
	        if (e.getSource() == divider){
	        	if(pointFormatMenu.getSelectedItem().toString() != "rat"){
	        		CalculatorView.message.setText("Divider can only be inserted if rational format is used");
	        	}
	        	else{
	        	if(!currentOperand.contains("/")){
	        		if(currentOperand.length()<1){
	        			CalculatorView.message.setText("Insert a value first");
	        		}
	        		else{
	        			currentOperand += "/";
	        		}
	        	}
	        	else{
	        		CalculatorView.message.setText("Operand already contains a \"/\"");
	        	}
	        	}
	        }
	        if (e.getSource() == plus){
	        	cm.addOperand(currentOperand);
	        	Operator = "+";
	        	currentOperand = "";
	        }
	        if (e.getSource() == min){
	        	cm.addOperand(currentOperand);
	        	Operator = "-";
	        	currentOperand = "";
	        }
	        if (e.getSource() == multiply){
	        	cm.addOperand(currentOperand);
	        	Operator = "*";
	        	currentOperand = "";
	        }
	        if (e.getSource() == divide){
	        	cm.addOperand(currentOperand);
	        	Operator = "/";
	        	currentOperand = "";
	        }
	        if (e.getSource() == baseMenu){
	        	if(baseMenu.getSelectedItem().toString() == "bin"){
	        		cm.setBase("bin");
	        	}
	        	if(baseMenu.getSelectedItem().toString() == "oct"){
	        		cm.setBase("oct");
	        	}
	        	if(baseMenu.getSelectedItem().toString() == "hex"){
	        		cm.setBase("hex");
	        	}
	        	if(baseMenu.getSelectedItem().toString() == "dec"){
	        		cm.setBase("dec");
	        	}
	        }
	        if (e.getSource() == pointFormatMenu){
	        	if(pointFormatMenu.getSelectedItem().toString() == "rat"){
	        		cm.setFormat("rat");
	        	}
	        	if(pointFormatMenu.getSelectedItem().toString() == "fixed"){
	        		cm.setFormat("fixed");
	        	}
	        	if(pointFormatMenu.getSelectedItem().toString() == "float"){
	        		cm.setFormat("float");
	        	}
	        }
	        if (e.getSource() == clear){
	        	cm.clear();
	        }
	        if (e.getSource() == answer){
	        	cm.addOperand(currentOperand);
	        	if(Operator == "+"){
	        		cm.add();
	        	}
	        	if(Operator == "-"){
	        		cm.subtract();
	        	}
	        	if(Operator == "*"){
	        		cm.multiply();
	        	}
	        	if(Operator == "/"){
	        		cm.divide();
	        	}
	        }
	        cm.update();
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
			pointFormatMenu.addItem("fixed");
			pointFormatMenu.addItem("float");
			pointFormatMenu.addItem("rat");
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
			clear = new JButton("clear");
			
			CalculatorView.buttonPanel.add(point);
			CalculatorView.buttonPanel.add(divider);
			CalculatorView.buttonPanel.add(answer);
			CalculatorView.buttonPanel.add(zero);
			CalculatorView.buttonPanel.add(plus);
			CalculatorView.buttonPanel.add(min);
			CalculatorView.buttonPanel.add(multiply);
			CalculatorView.buttonPanel.add(divide);
			CalculatorView.clearPanel.add(clear);
			
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
