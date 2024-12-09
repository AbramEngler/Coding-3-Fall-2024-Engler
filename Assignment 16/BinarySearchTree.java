package driver;

public class BinarySearchTree 
{
	public Node Root;
	
	public BinarySearchTree()
	{
		this.Root = null;
	}
	
	public void Insert(Node newNode, Node node)
	{
		if (node.Payload >= newNode.Payload)
		{
			if(node.Left == null)
			{
				node.Left = newNode;
			}
			
			else
			{
				Insert(newNode, node.Left);
			}
		}
		
		else
		{
			if(node.Right == null)
			{
				node.Right = newNode;
			}
			else
			{
				Insert(newNode, node.Right);
			}
		}
		
	}
	
	//insert
	public void Insert(int data)
	{
		Node newNode = new Node(data);
		if(this.Root == null)
		{
			this.Root = newNode;
		}
		
		else
		{
			Insert(newNode, this.Root);
		}
	}
	
	//delete
	public Node Delete(Node node, int data)
	{
		//if it is a leaf, delete the node
		//if there is a left child, make the left child to be the parent
		//move all the left child's children up
		if (node == null) 
		{
			System.out.println("Value not in tree");
	        return null;
	    }
	    
	    if (data < node.Payload) 
	    {
	        node.Left = Delete(node.Left, data);
	    } 
	    
	    else if (data > node.Payload) 
	    {
	        node.Right = Delete(node.Right, data);
	    } 
	    
	    else 
	    {
	        if (node.Left == null && node.Right == null) 
	        {
	            return null; 
	        } 
	        
	        else if (node.Left == null) 
	        {
	            return node.Right; 
	        } 
	        
	        else if (node.Right == null) 
	        {
	            return node.Left;
	        } 
	        
	        else 
	        {
	            Node successor = FindMin(node.Right); 
	            node.Payload = successor.Payload;
	            node.Right = Delete(node.Right, successor.Payload);
	        }
	    }
	    return node;
	}
	
	private Node FindMin(Node node) 
	{
	    while (node.Left != null) 
	    {
	        node = node.Left;
	    }
	    return node;
	}
	
	//search
	public Node Search(Node node, int data)
	{
		//recursively compare the node, and if not hit, call the search again
		if (node == null || node.Payload == data) 
		{
			if(node == null)
			{
				System.out.println("Value " + data + " not found in tree");
				return node;
			}
			else
			{
				System.out.println("Value found: " + node.Payload);
				return node;
			}
	    }
		
	    if (data < node.Payload) 
	    {
	        return Search(node.Left, data);
	    }
	    return Search(node.Right, data);
	}
	
	public void Display() 
	{
	    DisplayRecursive(this.Root, 0);
	}

	public void DisplayRecursive(Node node, int depth) 
	{
	    if (node == null) 
	    {
	        return; 
	    }
	    
	    DisplayRecursive(node.Right, depth + 1);
	    
	    for (int i = 0; i < depth; i++) 
	    {
	        System.out.print("   "); 
	    }
	    System.out.println(node.Payload); 
	    
	    DisplayRecursive(node.Left, depth + 1);
	}
}
