package cards;

public class Problem
{
private static Candidates candidates = new Candidates();
private static Solution   solution   = new Solution();
public static int moves = 0; 
public static String stripes;
    
public static void main(String[] args){
	solve();
}

public static void solve()
{
	 moves++;
     int index=0;
     while (index<candidates.size())
     {
         if (solution.fits(candidates.get(index)))
         {
        	// showSolution();
             solution.record(candidates.remove(index)); //move candidate to solution
             if (solution.complete())
             {
            	 if(solution.isCorrect()){
            		 showSolution();
            	 }
             }
             else
             {
                 solve();
             }
             candidates.add(index, solution.eraseRecording()); //move candidate to candidates
  
           }
           index++;
        }
}

public static void showSolution()
{
	stripes = "";
	 String moveInfo = "Moves : "+moves;
	 int length = moveInfo.length();
	 for(int i = 0;i<length+2;i++){
		 stripes += "-";
	 }
	 
	 System.out.println("A solution is found!");
	 System.out.println(stripes);
  	 System.out.println("|Moves : "+moves+"|");
  	 System.out.println(stripes);
    solution.show();
    System.out.println(stripes);
}

}
        
          
         









