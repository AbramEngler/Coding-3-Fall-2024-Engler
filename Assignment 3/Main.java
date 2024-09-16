package driver;

public class Main {

	public static void main(String[] args) 
	{
		String input = "unique";
		boolean output = isAllUnique(input);
		if(output == false)
		{
			System.out.println("'" + input + "'"+ " does not have all unique characters");
		}
		else
		{
			System.out.println("'" + input + "'"+ " does have all unique characters");
		}
	}
	
	public static boolean isAllUnique(String str)
	{
		for(int current = 0; current < str.length(); current++)
		{
			for(int nextLetter = current + 1; nextLetter < str.length(); nextLetter++)
			{
				if(str.charAt(current) == str.charAt(nextLetter))
				{
					return false;
				}
			}
		}
		return true;
	}
	
}
