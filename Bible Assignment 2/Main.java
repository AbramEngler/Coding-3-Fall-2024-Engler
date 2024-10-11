package driver;

public class Main {

	public static void main(String[] args) {
		int disciples = 13;
		double population = 7700000000D;
		int yearsResult = yearsForConversion2(disciples, population);
		System.out.println("It will take " + yearsResult + " years to convert the world, starting with " + disciples + " disciples");

	}
	
	public static int yearsForConversion2(int initialDisciples, double population) {
        int years = 0;
        double currentDisciples = initialDisciples;
        int lifespan = 72;  
        int startTrainingAge = 18;  
        int childBearingAge = 30; 
        double currentPopulation = population;
        double newPopulation = 0;

        while (currentDisciples < currentPopulation) {
            years = years + 3;

            double newDisciples = currentDisciples * 2; 
            currentDisciples += newDisciples;  

            if (years % childBearingAge == 0) {
                newPopulation = currentPopulation / 2;  
            }
            
            if(years % startTrainingAge == 0)
            {
            	currentPopulation = currentPopulation + newPopulation;
            }

            if (years % lifespan == 0) {
                currentDisciples -= currentDisciples / 2;  
            }
        }
        
        return years;
    }

}
