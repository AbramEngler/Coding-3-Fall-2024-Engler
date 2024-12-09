package driver;

public class Main {

	public static void main(String[] args) 
	{
		BinarySearchTree BST = new BinarySearchTree();
		
		BST.Insert(5);
		BST.Insert(3);
		BST.Insert(9);
		BST.Insert(7);
		BST.Insert(0);
		BST.Insert(8);
		BST.Insert(6);
		BST.Insert(4);
		BST.Insert(1);
		BST.Insert(2);
		
		int deletionValue = 7;
		BST.Delete(BST.Root, deletionValue);
		
		int deletionValue2 = 1;
		BST.Delete(BST.Root, deletionValue2);
		
		int deletionValue3 = 9;
		BST.Delete(BST.Root, deletionValue3);
		
		System.out.println("Binary Search Tree (left to right):");
	    BST.Display();
	    
	    BST.Search(BST.Root, 3);
	    BST.Search(BST.Root, 6);
	    BST.Search(BST.Root, 9);

	}

}
