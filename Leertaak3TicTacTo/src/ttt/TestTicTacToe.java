package ttt;
import junit.framework.TestCase;
import org.junit.Test;

public class TestTicTacToe extends TestCase 
{
	TicTacToe ttt;
	
	@Test
	public void testPositionValue()
	{
		 ttt = new TicTacToe();
	     assertEquals(ttt.UNCLEAR, ttt.positionValue());

	     ttt.setComputerPlays();
	     ttt.playMove(0);
	     ttt.playMove(6);
	     ttt.playMove(1);
	     ttt.playMove(7);
	     ttt.playMove(2);
	     assertEquals(ttt.COMPUTER_WIN, ttt.positionValue());

	     ttt = new TicTacToe();
	     ttt.setHumanPlays();
	     ttt.playMove(0);
	     ttt.playMove(6);
	     ttt.playMove(1);
	     ttt.playMove(7);
	     ttt.playMove(2);
	     assertEquals(ttt.HUMAN_WIN, ttt.positionValue());

	     ttt = new TicTacToe();
	     ttt.playMove(0);
	     ttt.playMove(1);
	     ttt.playMove(2);
	     ttt.playMove(5);
	     ttt.playMove(3);
	     ttt.playMove(6);
	     ttt.playMove(7);
	     ttt.playMove(8);
	     ttt.playMove(4);
	     assertEquals(ttt.DRAW, ttt.positionValue());
	}
	
	@Test
	public void testChooseMove() 
	{
		ttt = new TicTacToe();
		ttt.playMove(0);
		ttt.playMove(3);
		ttt.playMove(1);
		ttt.playMove(2);
		ttt.playMove(4);
		ttt.playMove(7);

		//0 is Computer
		//OOX
		//XO.
		//.XO
		assertEquals(8, ttt.chooseMove());
	}
	
	@Test
	public void testIsAWin() 
	{
		ttt = new TicTacToe();
		ttt.playMove(0);
		ttt.playMove(3);
		ttt.playMove(1);
		ttt.playMove(2);
		ttt.playMove(4);
		ttt.playMove(7);
		ttt.playMove(8);
		assertTrue(ttt.gameOver());
	}
}