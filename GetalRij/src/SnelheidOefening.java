
public class SnelheidOefening {

	
		static long totaltime = 0;
	/**
	 * @param args
	 */
	public static void main( String[] args){
		GetalRij gr = new GetalRij( 1000000, 2000000);
		
		long starttime = tijd();
		gr.zitErinB(32);	
		long endtime = tijd();
		
		totaltime = (endtime - starttime);
		
		System.out.println("startime = " + starttime);
		System.out.println("end = " + endtime);
		System.out.println("totaltime = " + totaltime);
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		
		
		
		return System.currentTimeMillis();
	}

}
