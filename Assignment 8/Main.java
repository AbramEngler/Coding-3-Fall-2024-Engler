package driver;

import java.util.Random;

public class Main {

	public static void main(String[] args) 
	{
		int[] testArray = RandomizedArray(10000000, 1, 10000000);
		int[] testArray2 = ArrayClone(testArray);
		
		long startTime = System.currentTimeMillis();
		ShellSort(testArray);
		long endTime = System.currentTimeMillis();
		System.out.println("Shell Sort took " + (endTime - startTime) + " milliseconds to complete");
		
		long startTime2 = System.currentTimeMillis();
		QuickSort(testArray2, 0, testArray2.length-1);
		long endTime2 = System.currentTimeMillis();
		System.out.println("Quick Sort took " + (endTime2 - startTime2) + " milliseconds to complete");
		
	}
	
	
	//Shell Sort
	public static void InsertionSortOnLeaves (int[] arr, int startIndex, int gap)
	{	
		for(int i = startIndex; i < arr.length - gap; i = i + gap)
		{
			int j = i + gap; //the next number we are comparing i to
			while(j > startIndex && arr[j - gap] >= arr[j])
			{
				int temp = arr[j];
				arr[j] = arr[j-gap];
				arr[j - gap] = temp;
				j = j - gap; //move to previous index to check the index before again
			}
		}
	}
	
	//apply the insertion sort when we partition the array into gap groups
	// k in notes is equal to gap
	public static void InsertionSortOnGap(int[] arr, int gap)
	{
		for(int i = 0; i < gap; i++)
		{
			InsertionSortOnLeaves(arr, i, gap);
		}
	}
	
	
	public static void ShellSort(int[] arr)
	{
		int k = 1;
		int gaps = 2;
		while(gaps < arr.length)
		{
			gaps = gaps * 2;
			k++;
		}
		gaps = gaps / 2;
		k--;
		for(int i = k; i >= 0; i--)
		{
			int gap = pow(2, i);
			InsertionSortOnGap(arr, gap);
		}
	}
	
	public static int pow(int base, int power)
	{
		int result = 1;
		for(int i = 0; i < power; i++)
		{
			result = result * base;
		}
		return result;
	}
	
	//Quick Sort
	public static void QuickSort(int[] arr, int start, int end) 
	{
        if (start < end) 
        {
            int pivotIndex = partition(arr, start, end);
            QuickSort(arr, start, pivotIndex - 1); // Sort left half
            QuickSort(arr, pivotIndex, end);       // Sort right half
        }
    }
	
	//ascending order
	//rearrange the items on the array, and move all numbers smaller than pivot to left, higher to right
	//return the index of the pivot
	public static int partition(int[] arr, int start, int end)
	{
		//mid is the index of the pivot
		int mid = (start + end) / 2;
		int pivot = arr[mid];
		int leftCursor = start;
		int rightCursor = end;
		
		while(leftCursor <= rightCursor)
		{
			//leftCursor stops at the number on the arr from left to right when it is equal to pivot
			//loop from start to end, until arr[leftCursor] >= pivot
			while(arr[leftCursor] < pivot)
			{
				leftCursor++;
			}
			
			//move rightCursor from right to left
			while(arr[rightCursor] > pivot)
			{
				rightCursor--;
			}
			
			//swap when left and right are not on the same item
			if(leftCursor <= rightCursor)
			{
				int temp = arr[leftCursor];
				arr[leftCursor] = arr[rightCursor];
				arr[rightCursor] = temp;
				leftCursor++;
				rightCursor--;
			}
		}
		return leftCursor;	
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
