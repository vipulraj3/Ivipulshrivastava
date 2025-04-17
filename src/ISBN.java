import java.util.*;

public class ISBN {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digit of an ISBN as integer: ");
        int isbn = input.nextInt();

        String isbnStr = String.format("%09d" , isbn);

        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbnStr.charAt(i) - '0';
            checksum += digit * (i+1);
        }

        checksum %= 11;

        if (checksum == 10) {
            isbnStr += "X";
        } else {
            isbnStr += checksum;
        }
        System.out.println("The ISBN-10 number is " + isbnStr);

    }
}
