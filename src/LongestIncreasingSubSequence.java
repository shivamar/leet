import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Assert.*;

/*
 *  Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity. 
 */
public class LongestIncreasingSubSequence {
    
    // dp solution ; a list of list is built where each list is the longest list possible with that element at i-th position; i.e. each 
	//element is added to the list which had its last element smaller than it and whose length was the longest seems so far    
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length < 1) return 0;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int i=0, size =nums.length, LISLength=1;
        
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(nums[i]);
        ans.add(li);
        
        for(i=1;i<size;i++)
        {
            ArrayList<Integer> max = new ArrayList<>();
            for(int j=0; j < i;j++)
            {
                li = ans.get(j);
                if(li.get(li.size()-1) < nums[i] && li.size()+1 > max.size())
                {
                    max = li;
                    
                    if(LISLength < max.size() + 1) LISLength = max.size()+1;
                }
            }
            li = new ArrayList<Integer>();
            li.addAll(max);
            li.add(nums[i]);
            ans.add(li);
        }

        check(LISLength, ans);
        
        return LISLength;
    }
    
    //unit testing
    public static void check(int longest, ArrayList<ArrayList<Integer>> ans)
    {
        int maxSize = 0;
        
        for(ArrayList<Integer> li : ans)
        {
            if(maxSize < li.size()) maxSize = li.size();
        }
       
        Assert.assertTrue(maxSize == longest); 
    }
    
    public static void main(String[] args)
    {
    	int[] a = {109,1,2,3,6,4,5};
    	int len = lengthOfLIS(a);
    }
}