import javax.lang.model.util.ElementScanner14;
import javax.naming.spi.DirStateFactory.Result;

/*
 * Test Case - 1
 * Final Number = 2500
 * Operations = {"X + 10", "X - 5", "X * 5", "X ^ 2"}
 * Expected Output: 5
 * 
 * Test Case - 2
 * Final Number = 1000
 * Operations = {"X * 5", "X / 0", "X ^ 3"}
 * Expected Output: -1
 * 
 * Test Case - 3
 * Final Number: 10
 * Operations: {"X * 5", "X * 0", "X + 10"}
 * Expected Output : -2
 * 
 * Test Case - 4
 * Final Number: 617283948
 * Operations: {"X + 5”, “X - 0”, “X + 1”, “X / 2”, “X ^ 1”}
 * Expected Output: 1234567890
 */

public class GuessTheNumber {
  public static void main(String[] args) throws Exception {
    int finalNumber = 10;
    String[] operations = {"X * 5", "X * 0", "X + 10"};

    int actualNumber = GuessTheNumber.getActualNumber(finalNumber, operations, operations.length);
    System.out.println("The actual number will be " + actualNumber + " after performing given operations.");
  }

  public static int getActualNumber(int finalNumber, String[] operations, int totalOperations) throws Exception{
    //TODO: Implement this function and remove below line, which throws exception
    
    int res = finalNumber;

        for(int i = totalOperations - 1 ; i>=0 ; i--) {

            // get operation & second operand for conditional checking

            char operation = operations[i].charAt(2);
            int number = Integer.parseInt(operations[i].substring(4));


            if(operation == '/' && number == 0) return -1;
            if(operation == '%' ||  (operation == '^' && number == 0)  || (operation == '*' && number == 0)) return -2;

            if(operation== '+') res-= number;
            else if(operation == '-') res += number;
            else if(operation == '*') res /= number;
            else if(operation == '/') res *= number;
            else res= (int) Math.pow(res, 1f / number);
        }
    return res;
  }
}
