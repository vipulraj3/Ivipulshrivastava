public class ApproximatePi2
{
    public static void main(String[] args )
    {
        int terms =  7;
        double pi = 0.0;
        for (int i=0; i< terms; i++){
            double term = 1.0/(2*i+1);
            if(i % 2 == 0){
                pi += term;
            }
            else{
                pi -= term;
            }
        }
        pi *= 4;
        System.out.println("Pi value is:" + pi);
    }
}
