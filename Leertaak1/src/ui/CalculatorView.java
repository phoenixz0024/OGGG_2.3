package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class CalculatorView implements ActionListener
{
	JFrame window;
	JPanel contentPanel, screenView, buttonPanel;
	JLabel screenText;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	JButton zero,A,B,C,D,E,F,point,divider,plus,min,multiply,divide,answer;
	JComboBox baseMenu,pointFormatMenu;
	
	
	public CalculatorView()
	{
		createFrame();
		
		addPanels();
		
		addButtons();
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e )
	{
		screenText.setText(CalculatorModel.calc.getBase().getName()+","
                            + CalculatorModel.calc.getFormat().getName()+","
                            + CalculatorModel.calc.firstOperand() + ", "
                            +CalculatorModel.calc.secondOperand() + "] >");
	}
	
	public void createFrame()
	{
		window = new JFrame("Calculator");
		window.setSize(400,500);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addPanels()
	{
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.black);
		window.add(contentPanel);
		
		screenView = new JPanel(new GridLayout(1,1));
		screenView.setPreferredSize(new Dimension(380,50));
		contentPanel.add(screenView);
		
		screenText = new JLabel("0   ", SwingConstants.RIGHT);
		screenView.add(screenText);
		
		buttonPanel = new JPanel(new GridLayout(5,5));
		buttonPanel.setBackground(Color.green);
		buttonPanel.setPreferredSize(new Dimension(380,400));
		contentPanel.add(buttonPanel);
	}
	
	public void addButtons()
	{
		//dropdown menu's for the format and base
		baseMenu = new JComboBox<String>();
		baseMenu.addItem("dec");
		baseMenu.addItem("bin");
		baseMenu.addItem("hex");
		baseMenu.addItem("oct");
		buttonPanel.add(baseMenu);
		
		pointFormatMenu = new JComboBox<String>();
		pointFormatMenu.addItem("rat");
		pointFormatMenu.addItem("fixed");
		pointFormatMenu.addItem("float");
		buttonPanel.add(pointFormatMenu);
		
		// .|=+-*/ 0
		point = new JButton(".");	
		divider = new JButton("|");		
		answer = new JButton("=");	
		zero = new JButton("0");	
		plus = new JButton("+");
		min = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		
		buttonPanel.add(point);
		buttonPanel.add(divider);
		buttonPanel.add(answer);
		buttonPanel.add(zero);
		buttonPanel.add(plus);
		buttonPanel.add(min);
		buttonPanel.add(multiply);
		buttonPanel.add(divide);
		
		
		// 1 to 9 and ABCDEF
		for(int i = 0;i<9;i++){
			buttons.add(new JButton(Integer.toString(i+1)));
			buttonPanel.add(buttons.get(i));
			
			if(i == 2){
				A = new JButton("A");
				buttonPanel.add(A);
				
				B = new JButton("B");
				buttonPanel.add(B);
			}
			if(i==5){
				C = new JButton("C");
				buttonPanel.add(C);
				
				D = new JButton("D");
				buttonPanel.add(D);
			}
			if(i==8){
				E = new JButton("E");
				buttonPanel.add(E);
				
				F = new JButton("F");
				buttonPanel.add(F);
			}	
		}
	}
	
}
