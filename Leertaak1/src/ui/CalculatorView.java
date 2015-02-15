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
	JPanel contentPanel, screenView, messagePanel;
	static JPanel buttonPanel;
	JLabel screenText, message;

	
	
	public CalculatorView(Color c)
	{
		createFrame();
		
		addPanels(c);
		
		CalculatorController.addButtons();
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e )
	{
		screenText.setText("["+CalculatorModel.calc.firstOperand()+"],["+CalculatorModel.calc.secondOperand()+"]");
		window.revalidate();
	}
	
	public void createFrame()
	{
		window = new JFrame("Calculator");
		window.setSize(400,555);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addPanels(Color c)
	{
		contentPanel = new JPanel();
		contentPanel.setBackground(c);
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
		
		messagePanel = new JPanel(new GridLayout(1,1));
		messagePanel.setPreferredSize(new Dimension(380,50));
		contentPanel.add(messagePanel);
		message = new JLabel("No recent messages", SwingConstants.LEFT);
		messagePanel.add(message);
	}
	
	
	
}
