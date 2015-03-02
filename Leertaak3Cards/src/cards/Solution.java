package cards;
import java.util.Stack;
/** the solution is a sequence of cards placed on the board according to the card positions
    example without border
*/
public class Solution extends Stack<Candidate>
{
    // The board is an 2D array.
	//  0123
	// 0..-.
	// 1---.
	// 2.---
	// 3..-.
	private Candidate[][] board = new Candidate[4][4];
	
	// card positions on the board
	// the first card position on the board are
	// {0,2}, {1,0}. {1,1}
	private int[] row    = { 0, 1, 1, 1, 2, 2, 2, 3 };
	private int[] column = { 2, 0, 1, 2, 1, 2, 3, 2 };
	//  indices of adjacent cards in the solution.
	//                 0   1  2   3   4    5     6    7   
	int [] [] check = {{},{},{1},{0},{2},{3,4},{5,6},{7}}; 
	
	
	public Solution()
	{
	}

	 // Check of dezelfde kaarten ergens naast elkaar liggen:
	 // Checks whether a candidate with card CardChar is in 
	 // an adjacent position of the board position (row, column)
	 // @param row, column, candidate
	 // @return Boolean indicating if cardChar is found.
	 // can be used in the methods fits and isCorrect
	private boolean bordersCard(int row, int column, char cardChar){
		 if(cardChar == ' ') {
			 return false;
			 }
			//HOE WERKT HET BEPALEN VAN EEN NEIGHBOE VIA BOARD
		 	 //boven
			 if(row > 0) {
				 Candidate neighbor = board[row - 1][column];
				 if(neighbor != null && neighbor.getCardChar() == cardChar) {
					 return true;
				 }
			 }
			 
			 //onder
			 if(row < board[0].length - 1) {
				 Candidate neighbor = board[row + 1][column];
				 if(neighbor != null && neighbor.getCardChar() == cardChar) {
					 return true;
				 }
			 }
			 
			 //rechts
			 if(column > 0) {
				 Candidate neighbor = board[row][column - 1];
				 if(neighbor != null && neighbor.getCardChar() == cardChar) {
					 return true;
				 }
			 }
			 
			 //links
			 if(column < board.length - 1) {
				 Candidate neighbor = board[row][column + 1];
				 if(neighbor != null && neighbor.getCardChar() == cardChar) {
					 return true;
				 }
			 }
			 return false;
    }
	
	
	/**
	 * Checks whether candidate card of same kind.
	 * Checks whether by placing candidate the solution sofar still complies with the rules
	 * @param candidate
	 * @return boolean indicating whether this candidate can be put in the
	 * next free position.
	 */
	public boolean fits(Candidate candidate){ 
		
		if(bordersCard(row[this.size()],column[this.size()], candidate.getCardChar()))
		{
			//de kaart mag niet geplaatst worden omdat bordersCard true returned
			//wat inhoud dat er eenzelfde kaart direct naast ligt
			return false;
		}
		//Het plaatsen van de kaart overschreid geen regels als de pointer
		//hier komt en dus returned fits true
		return true;
    }

	public void record(Candidate candidate)
	{
		int i=this.size(); // i= index in this stack of next for the next candidate
		board [row[i]] [column[i]] = candidate; //x=row, y=column
		this.push(candidate);
		
	}

	public boolean complete()
	{
		return this.size()==8;
	}

	public void show()
	{
		System.out.println(this); 
	}

	public Candidate eraseRecording()
	{
		int i=this.size()-1;           // i= index of the candidate that is removed from this Stack;
		board[row[i]][column[i]]=null; // remove candidate from board
		return this.pop();
    }
	
	// can be used in method isCorrect
    private char mustBeAdjacentTo(char card)
    {  
      if (card=='A') return 'K'; 
      if (card=='K') return 'Q'; 
      if (card=='Q') return 'J';
      return '?'; //error
    }
	
	/**
	 * Checks whether the rules below are fulfilled
	 * For the positions that can be checked for solution sofar.
	 * Rules:
	 * Elke aas (ace) grenst (horizontaal of verticaal) aan een heer (king).
	 * Elke heer grenst aan een vrouw (queen).
	 * Elke vrouw grenst aan een boer (jack).
	 * @return true if all checks are correct.
	 */
	// uses methods borderCard and mustBeAdjacent to
	boolean isCorrect() 
	{
		//doorloop alle candidates op het board. 
		//Voor elke candidate check of het naast de juiste candidate ligt.
		for(int i = 0; i < row.length; i++) {		
			Candidate candidate = board[this.row[i]][this.column[i]];
			
			//mustBeAdjacentChar is de candidate die naast de variabele candidate moet liggen
			//zoals deze hierboven is gedifinieerd
			char mustBeAdjacentChar = mustBeAdjacentTo(candidate.getCardChar());
			
			//Als de candidate bestaat en en in mustBeAdjacentTo geen error is
			//(Wat resulteerd in het returnen van een vraagteken.
			if(candidate != null && mustBeAdjacentChar != '?') {
				if(!bordersCard(this.row[i], this.column[i], mustBeAdjacentChar)) {
					//Als de candidate grenst aan de verkeerde candidate
					//Dan returned bordersCard false. Wanneer dit gebeurd is de candidate
					//verkeerd geplaatst en returned isCorrect() false.
					return false;
				}
			}
		}
		//Wanneer alle candidaten geplaatst zijn volgens de regels returned isCorrect() true
		return true;
    }     
            
	
	/**
	 * @return a representation of the solution on the board
	 */
     public String toString(){
    	 String output = "";
    	 for(int y = 0; y < board.length; y++) {
	    	 String row = "";
	    	 
	    	 String gap = "|";
	    	 
	    	 int speling = ((Problem.stripes.length()-9)/2)-1;
	    	 for(int i = 0;i<speling;i++){
	    		 gap += " ";
	    	 }
	    	 
	    	 for(int x = 0; x < board[0].length; x++) {
		    	 Candidate candidate = board[y][x];
		    	 
		    	 if(candidate != null) {
			    	 row += "|" + candidate.getCardChar();
			    	 if(x == board[0].length - 1 || board[y][x + 1] == null) {
			    		 row += "|";
			    	 }
		    	 }
		    	 else {
		    		 row += "  ";
		    	 }
	    	 }
	    	 if(y == board.length-1){
	    		 output += gap+row+gap.substring(1,gap.length())+"|";
	    	 }
	    	 else{
	    		 output += gap+row+gap.substring(1,gap.length())+"|"+ "\n";
	    	 }
    	 }
    	 
    	
    	 return output;	
	}    

}
