import java.util.*;

public class subtractionQuiz {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

//      Random rand = new Random();  this is the random number keyword in java which is used for upper bound the integer.
//      And Math.random() is also generates a random floating-point number between 0.0 to 1.0.

        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        if(number2 > number1) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

            System.out.print("What is the " + number1 + " - " + number2 + "?");
            int answer = input.nextInt();

            if (number1 - number2 == answer) {
                System.out.println("You are correct.");
            }
            else{
                System.out.println("You are wrong");
                System.out.println(number1+" - "+number2 +" Should be " + (number1-number2));
            }
    }
}
