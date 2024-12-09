package driver;

public class HashTableLinearProbing 
{
	public int Size;
    public Node[] Table;
    public boolean[] Deleted;

    public HashTableLinearProbing(int InitialSize) 
    {
        this.Size = InitialSize;
        this.Table = new Node[this.Size]; 
        this.Deleted = new boolean[this.Size];
    }
    
    public int HashingFunction(int key)
	{
		return key % this.Size;
	}
	
	public void Insert(int key, String value)
	{
		int index = HashingFunction(key);
	    int originalIndex = index;
	    boolean inserted = false;

	    while (!inserted) 
	    {
	        if (Table[index] == null || Table[index].Key == key) 
	        { 
	            Table[index] = new Node();
	            Table[index].Key = key;
	            Table[index].Value = value;
	            inserted = true;
	        } 
	        else 
	        {
	            index = (index + 1) % Size;

	            if (index == originalIndex) 
	            {
	            	System.out.println("Table is full");
	                break;
	            }
	        }
	    }
		
	}
	
	//search in the hash table will always give a unique result
	public Node Search(int key)
	{
		int index = HashingFunction(key);
	    int originalIndex = index;

	    while (Table[index] != null || Deleted[index]) 
	    {
	        if (Table[index] != null && Table[index].Key == key) 
	        {
	        	System.out.print("At index " + index + " " );
	            return Table[index]; 
	        }
	        index = (index + 1) % Size;

	        if (index == originalIndex) 
	        {
	            break;
	        }
	    }
	    return null; 
	}
	
	public void Remove(int key)
	{
		int index = HashingFunction(key);
	    int originalIndex = index;

	    while (Table[index] != null || Deleted[index]) 
	    {
	        if (Table[index] != null && Table[index].Key == key) 
	        {
	            Table[index] = null; 
	            Deleted[index] = true; 
	            return;
	        }
	        index = (index + 1) % Size;

	        if (index == originalIndex) {
	            break;
	        }
	    }
	    System.out.println("Key " + key + " not found in the hash table.");
	}
	
	public void Display()
	{
		for (int i = 0; i < Size; i++) {
	        System.out.print("Index " + i + ": ");
	        if (Table[i] == null) {
	            if (Deleted[i]) {
	                System.out.println("DELETED");
	            } else {
	                System.out.println("null");
	            }
	        } else {
	            System.out.println("[" + Table[i].Value + "]");
	        }
	    }
	}
	
	public void Resize()
	{
		
		
		int newSize = Size * 2;
		HashTableLinearProbing newTable = new HashTableLinearProbing(newSize);
		
		for(int i = 0; i < this.Size; i++)
		{
			Node lst = this.Table[i];
			Node node = this.Table[0];
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
