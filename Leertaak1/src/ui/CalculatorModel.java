package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import multiformat.BinaryBase;
import multiformat.Calculator;
import multiformat.DecimalBase;
import multiformat.FixedPointFormat;
import multiformat.FloatingPointFormat;
import multiformat.FormatException;
import multiformat.HexBase;
import multiformat.OctalBase;
import multiformat.RationalFormat;

/**
 * Model for the Calculator
 * @author Kas Feenema
 * @author Rafael van den Berg
 * @version 1.0
 */
public class CalculatorModel 
{
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	public static Calculator calc;
	static boolean done = false;
	
	/**
	 * Constructor of the model
	 */
	public CalculatorModel()
	{
		calc = new Calculator();
	}
	
	/**
	 * Adds a operand to the calculator
	 * @param operand
	 */
	public void addOperand(String operand)
	{
		try {
			calc.addOperand(operand);
		} 
		catch (FormatException e) {
			CalculatorView.message.setText(e.getMessage());
			calc.delete();
		}
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	}
	
	/**
	 * subtracts two operands
	 */
	public void subtract()
	{
		calc.subtract();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;
	}
	
	/**
	 * adds two operands
	 */
	public void add()
	{
		calc.add();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;
	} 
	
	/**
	 * multiplies two operands
	 */
	public void multiply()
	{
		calc.multiply();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;
	} 
	
	/**
	 * divides two operands
	 */
	public void divide()
	{
		calc.divide();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;    
	} 
	
	/**
	 * Sets the base 
	 * @param base
	 */
	public void setBase(String base)
	{
		switch(base){
		case "bin": calc.setBase(new BinaryBase());break;
		case "dec": calc.setBase(new DecimalBase());break;
		case "oct": calc.setBase(new OctalBase());break;
		case "hex": calc.setBase(new HexBase());break;
		}
		CalculatorView.message.setText("Base set to "+base);
		CalculatorController.currentOperand = "";
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
	/**
	 * sets the format
	 * @param format
	 */
	public void setFormat(String format)
	{
		switch(format){
		case "rat": calc.setFormat(new RationalFormat());break;
		case "float": calc.setFormat(new FloatingPointFormat());break;
		case "fixed": calc.setFormat(new FixedPointFormat());break;
		}
		CalculatorView.message.setText("Format set to "+format);
		CalculatorController.currentOperand = "";
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
	/**
	 * Clears the calculators current operand
	 */
	public void clear()
	{
		calc.delete();
		CalculatorController.currentOperand = "";
		CalculatorView.message.setText("Operands cleared..");
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
	/**
	 * Triggers the actionevent of the view so it gets updated
	 */
	public void update()
	{
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
	
	public void addActionListener( ActionListener l){
		actionListenerList.add( l );
	}

	public void removeActionListener( ActionListener l){
		if ( actionListenerList.contains( l ) )
			actionListenerList.remove( l );
	}
	
	private void processEvent(ActionEvent e){
		for( ActionListener l : actionListenerList)
			l.actionPerformed( e );
	}
}
