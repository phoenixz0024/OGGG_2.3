package ttt;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class TicTacToe
{
	private static final int HUMAN        = 0; 
	private static final int COMPUTER     = 1; 
	public  static final int EMPTY        = 2;

	public  static final int HUMAN_WIN    = 0;
	public  static final int DRAW         = 1;
	public  static final int UNCLEAR      = 2;
	public  static final int COMPUTER_WIN = 3;

	int [ ] [ ] board = new int[ 3 ][ 3 ];
    private Random random=new Random();  
	private int side=random.nextInt(2);  
	private int position=UNCLEAR;
	private char emptyChar, computerChar, humanChar;

	// Constructor
	public TicTacToe( )
	{
		clearBoard( );
		initSide();
	}
	
	private void initSide()
	{
		emptyChar = '.';
	    if (this.side==COMPUTER) { computerChar='X'; humanChar='O'; }
		else                     { computerChar='O'; humanChar='X'; }
    }
    
    public void setComputerPlays()
    {
        this.side=COMPUTER;
        initSide();
    }
    
    public void setHumanPlays()
    {
        this.side=HUMAN;
        initSide();
    }

	public boolean computerPlays()
	{
	    return side==COMPUTER;
	}

	public int chooseMove()
	{
	    Best best = chooseMove(COMPUTER,HUMAN_WIN, COMPUTER_WIN);
	    return best.row*3+best.column;
    }
    
	/**
	 * Chooses the best move
	 * @param side
	 * @param human
	 * @param computer
	 * @return
	 */
	private Best chooseMove(int side, int human, int computer)
	{
		int opponent;
		Best reply; 
		int simpleEval; 
		int bestRow = 0;
		int bestColumn = 0;
		int value;
		
		if ((simpleEval = positionValue()) != UNCLEAR){
			return new Best(simpleEval);
		}
		
		if (side == COMPUTER){
			opponent = HUMAN;
			value = human;
		}
		else{
			opponent = COMPUTER;
			value = computer;
		}
		
		for (int i = 0; i < 9; i++){
			int row = i / 3;
			int column = i % 3;
			
			if (squareIsEmpty(row, column)){
				place(row, column, side, board);
				reply = chooseMove(opponent, human, computer);
				place(row, column, EMPTY , board);	
				if (side == HUMAN && reply.val < value || side == COMPUTER && reply.val > value){
					if (side == HUMAN){
						computer = reply.val;
						value = computer;
					}
					else{
						human = reply.val;
						value = human;
					}
					bestRow = row;
					bestColumn = column;
					if (human >= computer) break;
				}
			}
		}
		return new Best(value, bestRow, bestColumn);
	}
	

   
    //check if move ok
    public boolean moveOk(int move)
    {
    	return ( move>=0 && move <=8 && board[move/3 ][ move%3 ] == EMPTY );
    }
    
    // play move
    public void playMove(int move)
    {
		board[move/3][ move%3] = this.side;
		if (side==COMPUTER) this.side=HUMAN;  else this.side=COMPUTER;
	}


	// Simple supporting routines
	private void clearBoard( )
	{
		for(int x = 0; x<this.board.length; x++){
			for(int y=0; y<this.board[x].length; y++){
				place(x, y, EMPTY, board);
			}
		}
	}

	private boolean boardIsFull( )
	{
		for(int x = 0; x<this.board.length; x++){
			for(int y=0; y<this.board[x].length; y++){
			  if(squareIsEmpty(x,y)){
				  return false;
			  }
			}
		}
		return true;
	}

	// Returns whether 'side' has won in this position
	private boolean isAWin( int side )
	{
		if(side == board[0][0]){
			if(side == board[1][0] && side == board[2][0])return true;
			if(side == board[0][1] && side == board[0][2])return true;
		}
		if(side == board[1][1]){
			if(side == board[0][0] && side == board[2][2])return true;
			if(side == board[0][2] && side == board[2][0])return true;
			if(side == board[1][0] && side == board[1][2])return true;
			if(side == board[0][1] && side == board[2][1])return true;
		}
		if(side == board[2][2]){
			if(side == board[2][1] && side == board[2][0])return true;
			if(side == board[1][2] && side == board[0][2])return true;
		}
		return false;
	}
	 

	// Play a move, possibly clearing a square
	private void place( int row, int column, int piece , int[][] board)
	{
		board[ row ][ column ] = piece;
	}

	private boolean squareIsEmpty( int row, int column )
	{
		return board[ row ][ column ] == EMPTY;
	}

	// Compute static value of current position (win, draw, etc.)
	int positionValue( )
	{
		if (isAWin(COMPUTER))
			return COMPUTER_WIN;
		else if (isAWin(HUMAN)) 
			return HUMAN_WIN;
		else if (boardIsFull()) 
			return DRAW;
		
		return UNCLEAR;
	}
	
	
	public String toString()
	{
		String temp = "      ";
		for(int x = 0; x<board.length; x++){
			for(int y=0; y<board[x].length; y++){
				if(board[x][y] == HUMAN){
					temp += humanChar;
			}
			else if(board[x][y] == COMPUTER){
				temp += computerChar;
			}
			else{
				temp += emptyChar;
			}
			}
			temp += "\n      ";
		}
		return temp; 
	}  
	
	public boolean gameOver()
	{
	    this.position=positionValue();
	    return this.position!=UNCLEAR;
    }
    
    public String winner()
    {
        if      (this.position==COMPUTER_WIN) return "computer";
        else if (this.position==HUMAN_WIN   ) return "human";
        else                                  return "nobody";
    }
    
	
	private class Best
    {
       int row;
       int column;
       int val;

       public Best( int v )
         { this( v, 0, 0 ); }
      
       public Best( int v, int r, int c )
        { val = v; row = r; column = c; }
    } 
	
	
}

