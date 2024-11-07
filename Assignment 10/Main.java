package driver;

public class Main {

	public static void main(String[] args) 
	{
		SinglyLinkedList list = new SinglyLinkedList();
		list.Append(17);
		list.Prepend(9);
		list.Append(5);
		list.Append(91);
		list.Append(15);
		list.Append(45);
		list.Append(75);
		
		list.Print();
		list.Sort(true);
		list.Print();
	}

}
