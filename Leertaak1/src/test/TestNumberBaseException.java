package test;

import static org.junit.Assert.fail;
import multiformat.BinaryBase;
import multiformat.Calculator;
import multiformat.DecimalBase;
import multiformat.FormatException;
import multiformat.HexBase;
import multiformat.NumberBaseException;
import multiformat.OctalBase;

import org.junit.Test;

/**
 * JUnit Testcase to test the control of the right input
 * Note that this class uses 'annotations' (the @...). This is a Java 1.5 feature. 
 * @author Kas Feenema  
 * @author Rafael van den Berg
 * @version 1.0
 *
 */
public class TestNumberBaseException 
{
	@Test
	public void testNumberBase()
	{
		Calculator calc = new Calculator();
		
		try{
			calc.setBase(new BinaryBase());
			calc.addOperand("1");
			if(!calc.secondOperand().matches("[01./]+")){
				throw new NumberBaseException("Not a valid operand");
			}
			
			calc.setBase(new DecimalBase());
			calc.addOperand("1.0");
			if(!calc.secondOperand().matches("[0123456789./]+")){
				throw new NumberBaseException("Not a valid operand");
			}
			
			calc.setBase(new HexBase());
			calc.addOperand("1A");
			if(!calc.secondOperand().matches("[0123456789ABCDEF./]+")){
				throw new NumberBaseException("Not a valid operand");
			}
			
			calc.setBase(new OctalBase());
			calc.addOperand("7");
			if(!calc.secondOperand().matches("[01234567./]+")){
				throw new NumberBaseException("Not a valid operand");
			}	
		}
		catch(FormatException fe){
			fail(fe.toString());
		}
		catch(NumberBaseException nbe){
			fail(nbe.toString());
		}

	}
}

