package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import multiformat.*;

public class CalculatorModel 
{
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	public static Calculator calc;
	static boolean done = false;
	
	public CalculatorModel()
	{
		calc = new Calculator();
	}
	
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
	
	public void subtract()
	{
		calc.subtract();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;
	}
	
	public void add()
	{
		calc.add();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;
	} 
	
	public void multiply()
	{
		calc.multiply();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;
	} 
	
	public void divide()
	{
		calc.divide();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	    CalculatorController.currentOperand = calc.secondOperand();
	    done = true;    
	} 
	
	public void setBase(String base)
	{
		switch(base){
		case "bin": calc.setBase(new BinaryBase());break;
		case "dec": calc.setBase(new DecimalBase());break;
		case "oct": calc.setBase(new OctalBase());break;
		case "hex": calc.setBase(new HexBase());break;
		}
		CalculatorView.message.setText("Base set to "+base);
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
	public void setFormat(String format)
	{
		switch(format){
		case "rat": calc.setFormat(new RationalFormat());break;
		case "float": calc.setFormat(new FloatingPointFormat());break;
		case "fixed": calc.setFormat(new FixedPointFormat());break;
		}
		CalculatorView.message.setText("Format set to "+format);
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
	public void clear()
	{
		calc.delete();
		CalculatorView.screenText.setText("Insert a value..");
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	
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
