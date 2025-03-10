public class Test11 {
    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter the score: ");
        int score = input.nextInt();

        if (score > 10)
        {
            System.out.print(score * 3);
        }
        else
        {
            System.out.print(score * 4);
        }

    }
}
