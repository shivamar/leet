import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/* 
Find the Mth permuation of a number array 1..N

solution: generate the next permuation and keep doing it until you reach Mth permutation!3
*/
class PermuationSequence
{
	    
    public static String getPermutation(int n, int k) throws Exception {
        int N = n;
		// your code goes here
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++){
			arr[i] = i+1;
		}
		
		int M = k; //(less than N!)
		
		int[] res = printMthPermutation(arr,M);
		
		return Arrays.toString(res);
		
    }
	public static void main (String[] args) throws java.lang.Exception
	{	
		int N = 8;
		// your code goes here
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++){
			arr[i] = i+1;
		}
		
		int M = 8590; //(less than N!)
		
		int[] res = printMthPermutation(arr,M);
		
		for(int a : res)
			System.out.println(a);
		
		System.out.println(getPermutation(N,M));
	}
	
	public static int[] printMthPermutation(int[] arr,int M) throws Exception
	{
		//first permuation is always the minimal non decreasing number
		if(M==1) return arr;
		int N = arr.length;
		
		//to genrate the next permutation
		for(int i=2; i <= M;i++)	
		{
			int j=N-1;
			//find the first number which is less than the next number from the right
			for(; j >0; j--){
				if(arr[j-1] < arr[j]){
					j = j-1;
					break;
				}
			}
			
		//if no number is like that, then we reach the highest possible permutation which is non decreasing
//			if(j==0) {
//			if(arr[j] > arr[j+1])
//				return arr;
//		    }
	
		//find the smallest number arr[k] which is bigger than arr[j] from the right 
		int smallest = Integer.MAX_VALUE, smallestIndex = Integer.MAX_VALUE;		
		int k=N-1;
		for(; k > j;k--){
			if(arr[k] > arr[j] && arr[k] < smallest){
				smallest = arr[k];
				smallestIndex = k;
			}
		}
		
		if(Integer.MAX_VALUE == smallestIndex) throw new Exception("no permuation lexicographically possible after M = " + String.valueOf(i-1));
		//swap arr[j] with arr[j]
		arr = swap(arr,smallestIndex,j);
		
		//sort the numbers after j
		sort(arr,j+1,N-1);
	
		}
		
		return arr;
	}
	
	public static int[] swap(int[] arr,int from,int to)
	{
		int temp = arr[from];
		
		arr[from] = arr[to];
		arr[to] = temp;
		
		return arr;
	}
	
	public static void sort(int [] arr, int from, int to)
	{
		if(from == to) return;
		int[] temp_arr = new int[to - from + 1];
		for(int i = from ; i < to+1; i++){
			temp_arr[i - from] = arr[i];
		}
		
		Arrays.sort(temp_arr);
		
		for(int i=from;i<to+1;i++)
		{
			arr[i] = temp_arr[i-from];
		}
	}
	
}
