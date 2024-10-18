package driver;
import java.util.Random;


public class Main {

	public static void main(String[] args) 
	{
		int[] testArray = RandomizedArray(50000, 1, 50000);
//		for(int i = 0; i < testArray.length; i++)
//		{
//			System.out.print(testArray[i] + ", ");
//		}
//		System.out.println("");
		long startTime = System.currentTimeMillis();
		mergeSort(testArray, 0, testArray.length - 1);
		long endTime = System.currentTimeMillis();
//		for(int i = 0; i < testArray.length; i++)
//		{
//			System.out.print(testArray[i] + ", ");
//		}
		System.out.println("Merge Sort took " + (endTime - startTime) + " milliseconds to complete");
		
	}
	
	 public static void mergeSort(int[] array, int left, int right) 
	 {
	        if (left < right) 
	        {
	            int mid = left + (right - left) / 2;

	            mergeSort(array, left, mid);
	            mergeSort(array, mid + 1, right);

	            merge(array, left, mid, right);
	        }
	    }

	  public static void merge(int[] array, int left, int mid, int right) 
	  {
	        int leftIndex = left;
	        int rightIndex = mid + 1;

	        while (leftIndex <= mid && rightIndex <= right) 
	        {
	            if (array[leftIndex] <= array[rightIndex]) 
	            {
	                leftIndex++;
	            } 
	            else 
	            {
	                int value = array[rightIndex];
	                int index = rightIndex;

	                while (index > leftIndex) 
	                {
	                    array[index] = array[index - 1];
	                    index--;
	                }
	                array[leftIndex] = value;

	                leftIndex++;
	                mid++;
	                rightIndex++;
	            }
	        }
	  }
	  
	  public static int[] RandomizedArray(int size, int start, int end)
		{
			if(end - start + 1 >= size)
			{
				int[] sourceArray = new int[end - start + 1];
				for(int i = 0; i < end - start + 1; i++)
				{
					sourceArray[i] = start + i;
				}
				shuffle(sourceArray);
				int[]result = new int[size];
				for(int i = 0; i < size; i ++)
				{
					result[i] = sourceArray[i];
				}
				return result;
			}
			else
			{
				return null;
			}
		}
		
		//randomize the items in the array
		public static void shuffle(int[] array)
		{
			//loop for half the array length
			for(int i = 0; i < array.length / 2; i++)
			//every round we pick two random positions and swap the items on these two positions
			{
				Random r = new Random();
				int pos1 = r.nextInt(array.length - 1);
				int pos2 = r.nextInt(array.length - 1);
				int temp = array[pos1];
				array[pos1] = array[pos2];
				array[pos2] = temp;
			}
			
		}
}
