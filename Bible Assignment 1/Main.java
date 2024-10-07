package driver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int disciples = 13;
		double population = 7700000000D;
		int yearsResult = yearsForConversion(disciples, population);
		System.out.println("It will take " + yearsResult + " years to convert the world, starting with " + disciples + " disciples");
		
		int targetYears = 50;
		double disciplesPerTrainingResult = numberOfDisciplesPerTraining(disciples, population, targetYears);
		System.out.println("It will take " + disciplesPerTrainingResult + " new disciples per training cycle to convert the world in " + targetYears + " years");

	}
	
	public static int yearsForConversion(double disciples, double population)
	{
		int years = 0;
		
		while(disciples < population)
		{
			disciples = disciples * 3;
			years = years + 3;
		}
		
		return years;
	}
	
	public static double numberOfDisciplesPerTraining(double disciples, double population, int targetYears)
	{
		double yearsTraining = 3;
		double trainingCycles = targetYears / yearsTraining;
		
		double disciplesPerTraining = Math.pow(population / disciples, 1 / trainingCycles) - 1;
		
		return disciplesPerTraining;
	}

}
