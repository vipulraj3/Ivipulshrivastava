public class CurrentTime
{
    public static void main(String[] args){
        //obtain the total milliseconds since midnight, jan 1, 1970
        long totalMilliSeconds = System.currentTimeMillis();
        //obtain the total seconds since midnight, jan 1, 1970
        long totalSeconds = totalMilliSeconds/1000;
        long currentSecond =totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;
        long currentMinutes = (totalMinutes +30) % 60;

        long totalHours = totalMinutes / 60;
        long currentHour = (totalHours+5 +(totalMinutes/60 + 30)/60) % 24;
        System.out.print(+currentHour +":"+ currentMinutes +":"+ currentSecond);
    }
}
