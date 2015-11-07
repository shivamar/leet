/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class SingleNumber
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] a = {2,3,2,1,4,1,4};
		System.out.println(singleNumber(a));
		
		int b = 7;
				
		System.out.println(Integer.toBinaryString(~b));		
	}
	
	public static int singleNumber(int[] nums) {
        int a = 0;
        
        for(int num : nums)
            a ^= num;
            
            return a;
    }
    
}