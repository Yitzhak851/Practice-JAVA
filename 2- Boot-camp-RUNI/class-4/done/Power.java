package done;
/*
 * Calculates the value of one given non-negative integer 
 * raised to the power of another
 */
public class Power {
  public static void main(String[] args) { 
    int x = Integer.parseInt(args[0]);  //5
    int y = Integer.parseInt(args[1]);  //2
    int result = 1;
    //TODO - x^y
    for(int i = 1; i <= y; i++){
      result *= x;    //result= result*x  >> 1*5 (5) >> 5*5 (25)
    }
    System.out.println("The power of " + x + " at "+ y + " is: " + result) ;
  }
}
