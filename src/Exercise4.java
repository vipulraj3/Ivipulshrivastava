public class Exercise4 {
    public static void main(String[] args)
    {
        int  i;
        System.out.println("a  a^2 a^3 a^4");
        for (i=0; i<=4; i++)
        {
            System.out.printf("%d  %d   %d   %d%n", i, (i * i), (i * i * i), (i * i * i * i));
        }
    }
}
