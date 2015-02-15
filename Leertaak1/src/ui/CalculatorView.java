package ui;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


public class CalculatorView 
{
	public static void main(String[] args)
	{
		new CalculatorView();
	}
	
	public CalculatorView()
	{
		JFrame window = new JFrame("Calculator");
		window.setSize(400,500);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		JPanel content = new JPanel();
		content.setBackground(Color.black);
		window.add(content);
		
		JPanel screenView = new JPanel();
		screenView.setPreferredSize(new Dimension(380,50));
		content.add(screenView);
		
		JLabel screenText = new JLabel("0", SwingConstants.EAST);
		screenView.add(screenText);
		
	}

}
