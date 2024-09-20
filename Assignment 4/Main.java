package driver;

public class Main {

	public static void main(String[] args) 
	{
		//array of arrays
		int[][] matrix = new int[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
		};
		
		//System.out.println(matrix[1] [2]);
		for(int y = 0; y < matrix.length; y++)
		{
			for(int x = 0; x < matrix[0].length; x++)
			{
//				System.out.println("The item at row index = " + y + " column index = " + x + " is " + matrix[y][x]);
//				System.out.println("(" + (x +1) +  ", " + (y + 1) + "): " + matrix[y][x]);
			}
		}
		
//		int rows = matrix.length;
//		int columns = matrix[0].length;
//		//int[r][c] <-> int [i]
//		for(int i = 0; i < rows * columns; i++)
//		{
//			//the item at 1D array index at i, should be at 
//			int r = i / columns;
//			int c = i % columns;
//			//what is the relation between r, c, and i
//			//i = r * columns + c
//			System.out.println("The item " + i + " int[" + r + "][" + c + "] is " + matrix[r][c]);
//		}
		
		int[] result = BinarySearch(matrix, 6);
		System.out.println(result[0] + " " + result[1]);
	}
	
	//first item is row index, second item is column index
	//there are 12 comparisons in the worst case == O(n)
	public static int[] LinearSearch(int[][] board, int query)
	{
		if(board.length == 0 || board[0].length == 0)
		{
			return new int[] {-1, -1};
		}
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[0].length; column++)
			{
				if(query == board[row][column]) //comparison
				{
					return new int[] {row, column};
				}
			}
		}
//		
//		//int[row][column] -> int[(row - ) * total_column + (column+1)]
//		//while current < total)
//		int columnTotal = board[0].length;
//		int rowTotal = board.length;
//		int total = columnTotal + rowTotal;
//		int current = 0;
//		int columnIndex = 0;
//		int rowIndex = 0;
//		
//		while(current < total)
//		{
//			if(board[rowIndex][columnIndex] == query)
//			{
//				return new int[] {rowIndex, columnIndex};
//			}
//			
//			else
//			{
//				columnIndex++;
//				if(columnIndex == columnTotal)
//				{
//					columnIndex = 0;
//					rowIndex++;
//				}
//				current++;
//			}
//		}
		return new int[] {-1, -1};
	}
	//scan through all the rows, running binary search for each row
	//or, map the matrix onto 1 dimensional array, get the index from 1D array binary search, 
	//map back to 2D matrix indexes
	//or, range binary search to return row index, and binary search to return column index
	public static int[] BinarySearch(int[][] matrix, int query)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int start = 0;
		int end = rows * columns -1;
		
		while(start <= end)
		{
			int mid = (start + end) / 2;
			int r = mid / columns;
			int c = mid % columns;
			if(matrix[r][c] == query)
			{
				return new int[] {r, c};
			}
			else
			{
				end = mid - 1;
			}
		}
		return new int[] {-1, -1};
	}
	
}
	

