package driver;

public class Salesman 
{
	//fields
	public String Name;
	public int Revenue;
	
	//constructor
	public Salesman(String Name, int Revenue)
	{
		this.Name = Name;
		this.Revenue = Revenue;
	}
	
	//methods
	public String getName()
	{
		return this.Name;
	}
	
	public int getRevenue()
	{
		return this.Revenue;
	}
	
	public String display()
	{
		return this.getName() + ": $" + this.getRevenue();
	}
	
	public static Salesman[] topFive(Salesman[] sales)
	{
		
		Salesman[]topFiveSales = new Salesman[5];
		
		for (int i = 0; i < sales.length; i++) //scan through all Salesman
		{
			Salesman current = sales[i];
			for(int j = 0; j < 5 ; j++)
			{
				Salesman temp = topFiveSales[j];
				if(temp == null) 
				{
					topFiveSales[j] = current;
					break;
				}
				else
				{
					if(current.Revenue > temp.Revenue)
					{
						topFiveSales[j] = current;
						current = temp;
					}
				}
			}
		}
		return topFiveSales;
	}
}
