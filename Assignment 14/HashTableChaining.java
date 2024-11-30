package driver;

public class HashTableChaining 
{
	public int Size;
	public List[] Table;
	
	public HashTableChaining(int InitialSize)
	{
		this.Size = InitialSize;
		this.Table = new List[this.Size];
		for (int i = 0; i < this.Size; i++) {
	        this.Table[i] = new List(); 
	    }
	}
	
	public int HashingFunction(int key)
	{
		return key % this.Size;
	}
	
	public void Insert(int key, String value)
	{
		int index = HashingFunction(key);

	    if (this.Table[index] == null) 
	    {
	        this.Table[index] = new List();
	    }

	    Node oldNode = this.Table[index].Search(key);
	    if (oldNode != null) 
	    {
	        oldNode.Value = value;
	    } 
	    
	    else 
	    {
	        Node newNode = new Node();
	        newNode.Key = key;
	        newNode.Value = value;
	        this.Table[index].Append(newNode);
	    }
		
	}
	
	//search in the hash table will always give a unique result
	public Node Search(int key)
	{
		int index = HashingFunction(key);
		System.out.print("At index " + index + " " );
		return this.Table[index].Search(key);
	}
	
	public void Remove(int key)
	{
		int index = HashingFunction(key);
		this.Table[index].Remove(key);
	}
	
	public void Display()
	{
		 for (int i = 0; i < this.Size; i++) 
		 {
		        System.out.print("Index " + i + ": ");
		        
		        if (this.Table[i] != null && !this.Table[i].IsEmpty()) 
		        {
		            Node currentNode = this.Table[i].Head;		           
		            while (currentNode != null) 
		            {
		                System.out.print("[" + currentNode.Value + "]  ");
		                currentNode = currentNode.NextNode;
		            }
		            
		            System.out.println("null"); 
		        }
		        
		        else 
		        {
		            System.out.println("null"); 
		        }
		    }
	}
	
	public void Resize()
	{
		
		
		int newSize = Size * 2;
		HashTableChaining newTable = new HashTableChaining(newSize);
		
		for(int i = 0; i < this.Size; i++)
		{
			List lst = this.Table[i];
			Node node = lst.Head;
			while(node != null)
			{
//				Node newNode = new Node();
//				newNode.Key = node.Key;
//				newNode.Value = node.Value;
				newTable.Insert(node.Key, node.Value);
				node = node.NextNode;
			}
		}
		
		this.Size = newTable.Size;
		this.Table = newTable.Table;
	}
}
