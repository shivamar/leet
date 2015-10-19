
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class TrappingRainWater
{
	/*
	 * 
	 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
		For example,
		Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
		The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image
	 */

	//trapping rain water -leetcoder
	public static int trap(int[] ht)
	{
		int[] left = new int[ht.length];
		int[] right = new int[ht.length];
		
		int max=ht[0];
		for(int i=0;i < ht.length; i++)
		{
			if(ht[i] > max){
				max = ht[i];
			}
			left[i] = max;
		}
		
		max=ht[ht.length-1];
		for(int i=ht.length-1;i >= 0; i--)
		{
			if(ht[i] > max){
				max = ht[i];
			}
			right[i] = max;
		}
		
		int ans = 0;
		
		for(int i = 0; i < ht.length; i++)
		{
			ans  += (Math.min(left[i],right[i]) - ht[i]);
		}
		
		return ans;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));
		
	}
}