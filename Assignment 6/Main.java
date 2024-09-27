package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] testArray = RandomizedArray(10000, 1, 10000);
		int[] testArray2 = ArrayClone(testArray);
		
		long startTime = System.currentTimeMillis();
		BubbleSort(testArray);
		long endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array size of " + testArray.length + " took Bubble Sort " + (endTime - startTime) + " milliseconds to complete");
		
		long startTime2 = System.currentTimeMillis();
		SelectionSort(testArray2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("Sorting a random array size of " + testArray2.length + " took Selection Sort " + (endTime2 - startTime2) + " milliseconds to complete");

	}
	
	public static void SelectionSort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			//in each loop, we put the current smallest number in the position of i
			for(int j = i + 1; j < arr.length; j++) 
			{
				if(arr[j] < arr[i])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void BubbleSort(int[] arr) //"float" the smallest to the left of the array
	{
		for(int i = 0; i < arr.length; i++)
		{
			//in each loop we compare neighbor items, and brings the larger to the right
			for(int j = 0; j < arr.length - i - 1; j++)
			{
				if(arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
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
	
	public static int[] ArrayClone(int[] array)
	{
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++)
		{
			result[i] = array[i];
		}
		return result;
	}

}
