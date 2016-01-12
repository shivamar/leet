/*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
    */
public class SearchInsert {
	//BINARY SEARCH N INSERT - O(log n)
    public int searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length-1,mid=0;
        if(nums[0] > target) return 0;
        if(nums[nums.length-1] < target) return nums.length;
        
        while(end >= start)
        {
            mid = start+(end-start)/2;
            
            if(nums[mid]==target || isBtw(nums,mid,target)) return mid;
            if(nums[mid] < target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        
        return -1;
    }
    
    public boolean isBtw(int[] nums, int mid, int target)
    {
        if(mid-1 >=0){
            if(nums[mid-1]<target && target < nums[mid])
                return true;
        }        
        return false;
    }
}