package driver;

public class Main {

	public static void main(String[] args) {
		int initialSize = 10;
        HashTableChaining hashTable = new HashTableChaining(initialSize);

        hashTable.Insert(1, "1");
        hashTable.Insert(6, "6");
        hashTable.Insert(57, "57");
        hashTable.Insert(2, "2");
        hashTable.Insert(64, "64");
        hashTable.Insert(49, "49");
        hashTable.Insert(12, "12");
        hashTable.Insert(63, "63");
        hashTable.Insert(52, "52");
        hashTable.Insert(90, "90");
        hashTable.Insert(87, "87");
        hashTable.Insert(493, "493");
        hashTable.Insert(2391, "2391");
        hashTable.Insert(23, "23");
        hashTable.Insert(10000, "10000");
        hashTable.Insert(64315, "64315");
        hashTable.Insert(78, "78");
        hashTable.Insert(46, "46");
        hashTable.Insert(207, "64");
        hashTable.Insert(34, "34");
        
        hashTable.Remove(64315);
        hashTable.Remove(49);
        
        System.out.println("Hash Table:");
        hashTable.Display();
        System.out.println("");
        
        int searchKey = 78;
        Node result = hashTable.Search(searchKey);
        if (result != null) 
        {
            System.out.println("Found Key: " + result.Key + ", Value = " + result.Value);
        } 
        
        else 
        {
            System.out.println("Key: " + searchKey + " not found in the hash table.");
        }

        
        int searchKey2 = 64315;
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
