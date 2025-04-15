import java.util.*;

public class GameMultiplyThreeNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);
        int number3 = (int)(Math.random() * 10);


        System.out.print("What is "+ number1 + " * " + number2 + " * " + number3 + " ? ");
        int answer = input.nextInt();

//        System.out.println(number1+ " * " + number2 + " * " + number3 + " = " + answer + " is " + (number1*number2*number3 == answer));
//        System.out.println("Multiplication of these three number is " + number1*number2*number3 );

        if (answer == number1*number2*number3){
            System.out.print("Correct");
        } else {
            System.out.println("Wrong. The correct answer is " + (number1*number2*number3));
        }


    }
}
