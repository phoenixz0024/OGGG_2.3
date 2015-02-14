package test;

import static org.junit.Assert.*;
import multiformat.Calculator;
import multiformat.FormatException;
import multiformat.OctalBase;

import org.junit.Test;

/**
 * JUnit Testcase to test Octal numbering base. 
 * Note that this class uses 'annotations' (the @...). This is a Java 1.5 feature. 
 * @author Kas Feenema & Rafael van den Berg
 *
 */
public class TestOctal 
{
	@Test
	public void testOctalBase()
	{
		Calculator calc = new Calculator();
		calc.setBase(new OctalBase());
		
		try {
			calc.addOperand("7");
			calc.addOperand("2");
			calc.add();
			assertEquals("11.0",calc.secondOperand());
			
			calc.addOperand("2");
			calc.addOperand("3");
			calc.subtract();
			assertEquals("-1.0",calc.secondOperand());
			
			calc.addOperand("6");
			calc.addOperand("2");
			calc.divide();
			assertEquals("3.0",calc.secondOperand());
			
			calc.addOperand("2");
			calc.addOperand("2");
			calc.multiply();
			assertEquals("4.0",calc.secondOperand());		
		} 
		catch (FormatException e) {
			fail(e.toString());
		}
	}
}
