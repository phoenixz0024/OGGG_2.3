package dynProg.solvers;

import dynProg.Solver;

public class TopDownSolver implements Solver{
    
    private int[][] matrix;
    private int[] solved;
   
    public TopDownSolver(){        
    }
   
    public static void main(String[] args){
            TopDownSolver s = new TopDownSolver();
            s.solve(new int[]{3,5,7,9,11}, 17);
    }
   
    public boolean solve(int[] numbers, int sum){          
            matrix = new int[numbers.length][sum];  
           
            // Elke rij bijlangs gaan
            //M(i,j)
            //row == i
            //answer == j
            int totaal=0;
            int teller = 0;
            for(int p=0;p<numbers.length;p++){
                    totaal += numbers[p];
            }              
            solved = new int[totaal];
            for(int i = 0; i<numbers.length; i++){                  
                    int somB = 0;
                    for(int j = 0; j<=i; j++){                              
                            // Plaats de huidige
                            // Eerst kijken of hij al eerder is toegevoegd
                            // Als numbers j is 3 dan wordt er een 1 geplaatst op M(0,2)
                            if(checkSolved(numbers[j])){
                                    matrix[i][numbers[j]-1] = numbers[j];
                                    solved[teller] = numbers[j];
                                    teller++;
                            }

                            // De som uitvoeren
                            // Eerst kijken of hij al eerder is toegevoegd aan de matrix
                            // Zolang de som van B kleiner is dan 17 zal hij toegevoegd worden aan de matrix
                            // Als {3,5} aan de beurt is wordt er dus 8 uitgerekend
                            // Gekeken of het kleiner is dan 17
                            // en vervolgens in dit geval op {1,7} geplaatst
                            somB += numbers[j];    
                            if(checkSolved(somB)){                                  
                                    if(somB<=sum){                                  
                                            matrix[i][somB - 1] = somB;
                                            solved[teller] = somB;
                                            teller++;
                                    }
                            }
                           
                                                                                   
                            // De som van de vorige
                            // Totaal is gelijk aan de som van B - het getal voor de huidige
                            // Dit moet eigenlijk vaker om alle antwoorden te krijgen maar is op dit moment niet nodig om te doen
                            if (j > 0){
                                    totaal = somB - numbers[j - 1];
                                    if(checkSolved(totaal)){        
                                            if(totaal-1<=sum){
                                                    matrix[i][totaal - 1] = totaal;
                                                    solved[teller] = totaal;
                                                    teller++;
                                            }
                                    }
                            }                              
                    }                      
            }              
            return solved(sum);
    }
   
    private boolean solved(int sum){                
            if(sum<= matrix[0].length){
                    //Kijken of er een antwoord staat in de laatste kolom
                    //Elke rij bijlangs gaan en kijken in de laatste kolom of er een antwoord staat
                    for(int i = 0; i<matrix.length; i++){
                            if(matrix[i][sum-1] != 0){      
                                    System.out.println("true");
                                    return true;
                            }
                    }
            }
            return false;
    }
   
    private boolean checkSolved(int n){
            if(solved != null){            
                    for(int i = 0;i<solved.length;i++){
                            if(solved[i]==n){
                                    return false;
                            }
                    }      
            }
            return true;            
    }
}

