package driver;

public class Main {
	
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 5;
		System.out.println("Fibonacci number " + input + " is " + Fibonacci(input));
		System.out.println("Function is called " + count + " times");
	}
	
	public static int Fibonacci(int n)
	{
		count++;
		if(n <= 1)
		{
			return 1;
		} 
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
