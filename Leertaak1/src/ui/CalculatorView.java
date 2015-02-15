package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * View of the Calculator
 * @author Kas Feenema
 * @author Rafael van den Berg
 * @version 1.0
 */
public class CalculatorView implements ActionListener
{
	JFrame window;
	JPanel contentPanel, screenView, messagePanel;
	static JPanel buttonPanel, clearPanel;
	public static JLabel screenText;
	public static JLabel message;
	
	/**
	 * Constructor
	 * @param Color c
	 */
	public CalculatorView(Color c)
	{
		createFrame();
		
		addPanels(c);
		
		CalculatorController.addButtons();
		
		window.setVisible(true);
	}
	
	/**
	 * Updates the label of the calculator
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e )
	{	
		screenText.setText(CalculatorController.currentOperand);
		if(CalculatorModel.done == true)
			CalculatorController.currentOperand = "";
			
		window.revalidate();
	}
	
	/**
	 * Creates the frame of the calculator
	 */
	public void createFrame()
	{
		window = new JFrame("Calculator");
		window.setSize(400,580);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Adds all panels to the main window of the calculator
	 * @param Color c
	 */
	public void addPanels(Color c)
	{
		contentPanel = new JPanel();
		contentPanel.setBackground(c);
		window.add(contentPanel);
		
		screenView = new JPanel(new GridLayout(1,1));
		screenView.setPreferredSize(new Dimension(380,50));
		contentPanel.add(screenView);
		
		screenText = new JLabel("Insert a value..", SwingConstants.CENTER);
		screenText.setFont(screenText.getFont().deriveFont(32.0f));
		screenView.add(screenText);
		
		buttonPanel = new JPanel(new GridLayout(5,5));
		buttonPanel.setBackground(Color.green);
		buttonPanel.setPreferredSize(new Dimension(380,400));
		contentPanel.add(buttonPanel);
		
		messagePanel = new JPanel(new GridLayout(1,1));
		messagePanel.setPreferredSize(new Dimension(380,50));
		contentPanel.add(messagePanel);
		message = new JLabel("No recent messages", SwingConstants.LEFT);
		message.setForeground(Color.red);
		messagePanel.add(message);
		
		clearPanel = new JPanel(new GridLayout(1,1));
		clearPanel.setPreferredSize(new Dimension(380,20));
		contentPanel.add(clearPanel);
	}
}
