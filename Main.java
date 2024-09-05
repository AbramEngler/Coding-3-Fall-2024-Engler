package driver;

public class Main {

	public static void main(String[] args) 
	{
		Salesman abel = new Salesman("Abel", 100);
		Salesman noah = new Salesman("Noah", 101);
		Salesman adam = new Salesman("Adam", 102);
		Salesman eden = new Salesman("Eden", 103);
		Salesman abram = new Salesman("Abram", 104);
		Salesman dolf = new Salesman("Dolf", 105);
		Salesman charles = new Salesman("Charles", 106);
		Salesman chum = new Salesman("Chum", 107);
		Salesman kieran = new Salesman("Kieran", 108);
		Salesman kris = new Salesman("Kris", 2);
		
		Salesman[] sales = new Salesman[] {abel, noah, adam, eden, abram, dolf, charles, chum, kieran, kris};
		Salesman[] top5Salesman = Salesman.topFive(sales);
		
		System.out.println("Sales unsorted:");
		for(int i = 0; i < sales.length; i++)
		{
			System.out.println((i + 1) + " " + sales[i].display());
		}
		
		System.out.println("");
		System.out.println("Top 5 Sales, Sorted:");
		for(int i = 0; i < 5; i++)
		{
			System.out.println((i + 1) + " " + top5Salesman[i].display());
		}

	}

}
