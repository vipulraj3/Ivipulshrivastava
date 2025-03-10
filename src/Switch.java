import java.util.*;

public class Switch {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the status: ");
        int status = input.nextInt();

        switch (status)
        {
            case 0: System.out.println("Compute tax for single fillers"); break;
            case 1: System.out.println("Compute tax for married jointly or qualifying widow(er)"); break;
            case 2: System.out.println("Compute tax for married filling separately"); break;
            case 3: System.out.println("Compute tax for head of household"); break;
            default: System.out.println("Enter the valid status! "); System.exit(1);
        }

    }
}
