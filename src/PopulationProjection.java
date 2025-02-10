public class PopulationProjection
{
    public static void main(String[] args){
        double currentPopulation = 312032486;
        double secondPerYear = 365 * 24 * 60 * 60;

        double birthPerYear = secondPerYear/7;
        double deathPerYear = secondPerYear/13;
        double immigrantsPerYear = secondPerYear/45;

        for (int year=1; year<=5; year++)
        {
            // understand this line
            currentPopulation += birthPerYear - deathPerYear + immigrantsPerYear;
            System.out.println("Year: " + year + " Population: " + (long) currentPopulation);
        }
    }
}
