package driver;

public class Main {

	public static void main(String[] args) {
		String inputTrue = "(1 + 2 * (3 - 1)) / (1 + 1)";
		String inputFalse = "(1 + 2 * (3 - 1) / (1 + 1)";
			
		iStack stackInterface = new StackInterfaceList();
		System.out.println(stackInterface.IsExpValid(inputTrue));  
		System.out.println(stackInterface.IsExpValid(inputFalse));
		
		Stack stackAbstract = new IntListStack();
		System.out.println(stackAbstract.IsExpValid(inputTrue));  
		System.out.println(stackAbstract.IsExpValid(inputFalse));
	}

}