import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
*
* @author Rafael van den Berg, Kas Feenema

*
*/

public class GetalRij {
	private int[] getallen;
	
	public GetalRij( int aantal, int max ){
		// Belangrijke aanname: aantal < max, anders kunnen de getallen niet uniek zijn.
		getallen = new int[aantal];
		vulArrayMetUniekeWaarden( aantal, max );
	}

	private void vulArrayMetUniekeWaarden(int aantal, int max) {
		// Vul een hulplijst met getallen 0, ..., max
		ArrayList hulpLijst = new ArrayList( max );
		for ( int i=0; i<max; i++){
			hulpLijst.add( i );
		}
		
		// Stop 'aantal' random waarden in getallen
		Random r = new Random();
		for ( int i=0; i<aantal; i++){
			// Het omzetten van Integer naar int gaat sinds Java 1.5 automatisch (unboxing).
			int getal = (Integer) (hulpLijst.remove( r.nextInt( hulpLijst.size())));
			getallen[i] = getal;
		}
	}
	/**
	 * linair algoritme zonder break
	 * @param zoekWaarde
	 * @return
	 */
	public boolean zitErinA( int zoekWaarde ){
		
		boolean exist = false;
		int index = 0;
		
		while(index < getallen.length){
			
			if(getallen[index] == zoekWaarde){
				exist = true;
			}
			index++;
		}
		
		return exist;
	}
	
	/**
	 * linair algoritme met break
	 * @param zoekWaarde
	 * @return
	 */
	public boolean zitErinB( int zoekWaarde ){
		boolean exist = false;
		int index = 0;
		
		while(exist == false && index < getallen.length){
			
			if(getallen[index] == zoekWaarde){
				exist = true;
			}
			index++;
		}
		
		return exist;
	}

	/**
	 * linear search with better algorithm ( using a third variable called middle which represents the middle
	 * of an array )
	 * @param zoekWaarde
	 * @return
	 */
	public boolean zitErinC( int zoekWaarde ){
		
		
		boolean found = false;
		
		int lowEnd = 0;
		int highEnd = getallen.length - 1;
		
		
		while(highEnd >= lowEnd && found == false){
			
			int middle = (highEnd + lowEnd) / 2;
			System.out.println(getallen[middle]);
			
			if( getallen[middle] == zoekWaarde){
				
				// zoekWaarde has been found at this index
				found = true;

			}
			else if (getallen[middle] > zoekWaarde){
				
				highEnd = middle - 1;
			}
			else {
				lowEnd = middle + 1;
			}
			
		}
		
		return found;
	}

	public boolean zitErinD( int zoekWaarde ){
		return false;
	}
	
	public void sorteer(){
		Arrays.sort( getallen);
	}
	
	public void print(){
		for( int i=0; i<getallen.length; i++)
			System.out.println(getallen[i]);
	}

}
