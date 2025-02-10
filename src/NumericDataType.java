import java.util.*;

public class NumericDataType
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a byte value: ");
        byte byteValue = input.nextByte();  // this is the method
        System.out.print(byteValue);

        System.out.print("Enter a Short value: ");
        short shortValue = input.nextShort();
        System.out.print(shortValue);

        System.out.print("Enter a int value: ");
        int intValue = input.nextInt();
        System.out.print(intValue);

        System.out.print("Enter a long value: ");
        long longValue = input.nextLong();
        System.out.print(longValue);

        System.out.print("Enter a float value: ");
        float floatValue = input.nextFloat();
        System.out.print(floatValue);

    }
}
