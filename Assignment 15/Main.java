package driver;

public class Main {

	public static void main(String[] args) {
		int initialSize = 10;
        HashTableLinearProbing hashTable = new HashTableLinearProbing(initialSize);

        hashTable.Insert(1, "1");
        hashTable.Insert(6, "6");
        hashTable.Insert(57, "57");
        hashTable.Insert(2, "2");
        hashTable.Insert(64, "64");
        hashTable.Insert(49, "47");
        hashTable.Insert(12, "12");
        hashTable.Insert(63, "63");
        hashTable.Insert(52, "52");
        hashTable.Insert(90, "90");
       
        hashTable.Remove(12);
        hashTable.Remove(52);
        
        System.out.println("Hash Table:");
        hashTable.Display();
        System.out.println("");
        
        int searchKey = 63;
        Node result = hashTable.Search(searchKey);
        if (result != null) 
        {
            System.out.println("Found Key: " + result.Key + ", Value = " + result.Value);
        } 
        
        else 
        {
            System.out.println("Key: " + searchKey + " not found in the hash table.");
        }

        
        int searchKey2 = 6;
        Node result2 = hashTable.Search(searchKey2);
        if (result2 != null) 
        {
            System.out.println("Found Key: " + result2.Key + ", Value = " + result2.Value);
        } 
        
        else 
        {
            System.out.println("Key: " + searchKey2 + " is not found in the hash table.");
        }
        
	}

}
