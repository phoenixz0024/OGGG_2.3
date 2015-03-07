package opgave2;


public class Solve {

	
	public static void main(String[] args) {
		
			int[] array = {3,5,7,9,11};
			
			if( hasSum(array, 17) )
				System.out.println("Ja");
			else
				System.out.println("Nee");		
	} 
	
	/**
	 * 
	 * @param set
	 * @param sum
	 * @return subset
	 */
	// returns true als er een deelverzameling is van de set[] met de som gelijk aan de gegeven som
	public static boolean hasSum(int[] array, int sum) {
		
		// De waarde van subset[i][j] is true als er een subset is van set[0..j-1]
		// met som gelijk aan i
		int len = array.length;
		boolean[][] subset = new boolean[sum+1][len+1];
		
		
		// Base case
		// als som is 0, subset heeft altijd 0 dus antwoord is true
		for( int i = 0; i <= len; i++){
			subset[0][i] = true;
		}
		
		// als som niet gelijk is aan 0 en de set is leeg, het antwoord is false
		for(int i = 1; i <= sum; i++){
			subset[i][0] = false;
		}
		
		// vul de subset table met bottom-up
		for( int i = 1; i <= sum; i++)
		{
			
			for(int j = 1; j <= len; j++){
				
				subset[i][j] = subset[i][j-1];
				
				if(!subset[i][j] && i >= array[j-1])
					subset[i][j] = subset[i - array[j-1]][j-1];
				
			}
		}
		
		return subset[sum][len];
	}
	
}
