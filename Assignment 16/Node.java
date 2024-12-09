package driver;

public class Node 
{
	public int Payload;
	public Node Left;
	public Node Right;
	
	public Node(int data)
	{
		this.Payload = data;	
		this.Left = null;
		this.Right = null;
	}
}
