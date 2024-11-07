package driver;

//linked list is a collection/list of nodes
public class SinglyLinkedList 
{
	public SinglyLinkedListNode header;
	public int length; //not necessary
	
	public SinglyLinkedList()
	{
		this.header = null;
		this.length = 0;
	}
	
	public int GetLength()
	{
//		int len = 0;
//		SinglyLinkedListNode node = this.header;
//		while(node != null)
//		{
//			len++;
//			node = node.nextNode;
//		}
		return this.length; //O(1) instead of O(n)
	}
	
	//IsEmpty
	public boolean IsEmpty()
	{
		return this.header == null; //this.length = 0
	}
	
	//Append: add to end of the list O(n)
	//don't need to give the list because it is an instance method
	public void Append(int value)
	{
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		if (this.IsEmpty()) //empty list
		{
			this.header = newNode;
			this.length++;
		}
		
		else
		{
			//find tail node 
			SinglyLinkedListNode tail = this.header;
			while(tail.nextNode != null)
			{
				tail = tail.nextNode;
			}
			tail.nextNode = newNode;
			this.length++;
			// make tail node's next be the new node
			
		}
	}

	//Prepend: add to start O(1)
	public void Prepend(int value)
	{
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		newNode.nextNode = this.header;
		this.header = newNode;
		this.length++;
//		if(this.IsEmpty())
//		{
//			this.header = newNode;
//			this.length++;
//		}
//		else
//		{
//			newNode.nextNode = this.header;
//			this.header = newNode;
//			this.length++;
//		}
	}
	
	//InsertAfter O(1)
	public void InsertAfter(SinglyLinkedListNode a, int value)
	{
		SinglyLinkedListNode b = a.nextNode;
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		a.nextNode = newNode;
		newNode.nextNode = b;
		this.length++;
//		if(a == null)
//		{
//			System.out.println("");
//		}
	}
	
	//Remove: delete the node from the list
	//return if the remove action completes
	//O(n)
	public boolean Remove(SinglyLinkedListNode node)
	{
		//when this is an empty list
		if(this.IsEmpty())
		{
			return false;
		}
		
		//Locate previous node of the node
		
				//connect previous node to the next node
				//make the node point to null
		else
		{
			if(this.header == node)
			{
				if(this.header.nextNode == null)
				{
					this.header = null;
					this.length = 0;
				}
				
				else
				{
					this.header = this.header.nextNode;
					this.length--;
				}
				node.nextNode = null;
				return true;
			}
			
			else
			{
				SinglyLinkedListNode previous = this.header;
				while(previous.nextNode != null)
				{
					if(previous.nextNode == node)
					{
						previous.nextNode = previous.nextNode.nextNode;
						this.length--;
						node.nextNode = null;
						return true;
					}
					else
					{
						previous = previous.nextNode;
					}
				}
				return false;
			}
		}
	}
	
	//Search: return the first node that match the value to search
	//O(1)
	public SinglyLinkedListNode Search(int value)
	{
		SinglyLinkedListNode node = this.header;
		while(node != null)
		{
			if(node.payload == value)
			{
				return node;
			}
			
			else
			{
				node = node.nextNode;
			}
		}
		return null; 
	}
	
	//Print
	public void Print()
	{
		System.out.println(this);
//		if(this.IsEmpty())
//		{
//			System.out.println("(0){empty}");
//			return;
//		}
//		SinglyLinkedListNode node = this.header;
//		String output = "(" + this.GetLength() + ")" + "{" + (node);//don't need node.payload because we override toString
//		node = this.header.nextNode;
//		while(node != null)
//		{
//			output = output + ", " + node;
//			node = node.nextNode;
//		}
//		output = output + "}";
//		System.out.println(output);
	}
	
	//OOP, unique method with the same name
	@Override
	public String toString()
	{
		if(this.IsEmpty())
		{
			return "(0){empty}";
		}
		SinglyLinkedListNode node = this.header;
		String output = "(" + this.GetLength() + ")" + "{" + (node);//don't need node.payload because we override toString
		node = this.header.nextNode;
		while(node != null)
		{
			output = output + ", " + node;
			node = node.nextNode;
		}
			output = output + "}";
			return output;	
		}
	
	//PrintReverse
	public void PrintReverse()
	{
		if(this.IsEmpty())
		{
			System.out.println("(0){empty}");
		}
		SinglyLinkedListNode node = this.header;
		String output = node.toString();
		node = this.header.nextNode;
		while(node != null)
		{
			output = node + " < " + output;
			node = node.nextNode;
		}
		//string format is "(%d){%s}
		System.out.println(String.format("(%d){%s}", this.GetLength(), output));
	}
	
	public void swap(SinglyLinkedListNode pre_a, SinglyLinkedListNode a, SinglyLinkedListNode pre_b, SinglyLinkedListNode b)
	{
		 if (a == b) return;

		 if (pre_a != null) 
		 {
			 pre_a.nextNode = b;
		 } 
		 else 
		 {
			 this.header = b;
		 }
		 	
		 if (pre_b != null) 
		 {
			 pre_b.nextNode = a;
		 } 
		 else 
		 {
			 this.header = a;
		 }
		 
		 SinglyLinkedListNode temp = a.nextNode;
		 a.nextNode = b.nextNode;
		 b.nextNode = temp;
	}

	
	//Sort
	public void Sort(boolean ascending)
	{
		if (this.header == null || this.header.nextNode == null) return; 

	    boolean swapped;
	    do 
	    {
	        swapped = false;
	        SinglyLinkedListNode pre_a = null;        
	        SinglyLinkedListNode a = this.header;     

	        while (a.nextNode != null) 
	        {
	            SinglyLinkedListNode b = a.nextNode;  

	            if (ascending) 
	            {
	                if (a.payload > b.payload) 
	                {
	                    swap(pre_a, a, a, b);
	                    swapped = true;
	                    
	                    pre_a = b;
	                } 
	                else
	                {
	                    pre_a = a;
	                    a = a.nextNode;
	                }
	            }
	            else
	            {
	                if (a.payload < b.payload) 
	                {
	                    swap(pre_a, a, a, b);
	                    swapped = true;
	                    
	                    pre_a = b;
	                } 
	                else
	                {
	                    pre_a = a;
	                    a = a.nextNode;
	                }
	            }
	        }  
	    } 
	    while (swapped); 
	}

}
	

