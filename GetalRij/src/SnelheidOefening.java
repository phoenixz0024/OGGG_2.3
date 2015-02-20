
public class SnelheidOefening {

	
		static long totaltime = 0;
	/**
	 * @param args
	 */
	public static void main( String[] args){
		GetalRij gr = new GetalRij( 100000, 200000);
		
		long starttime = tijd();
		System.out.println(gr.zitErinB(33));
		long endtime = tijd();
		
		totaltime = endtime - starttime;
		
		System.out.println("startime = " + starttime);
		System.out.println("end = " + endtime);
		System.out.println("totaltime = " + totaltime);
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		return System.currentTimeMillis();
	}

}
