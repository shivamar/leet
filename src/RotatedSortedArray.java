/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1, mid=0;
        
        while(end > start)
        {
            mid=start+(end-start)/2;
            
            if(nums[mid] < nums[end]) end = mid;
            else start=mid+1;
        }
        
        int minIndex=start;
        if(target >= nums[minIndex] && target <= nums[nums.length-1]) {
            start=minIndex;
            end=nums.length-1;
        }
        else if(target > nums[nums.length-1] && (minIndex-1 >=0 ? target <= nums[minIndex-1] : true)){
            end=minIndex-1 >= 0 ? minIndex-1:0;
            start=0;
        }
       // System.out.println(end+" "+start);
        while(end>=start){
            mid=start+(end-start)/2;
            
            if(nums[mid]==target)return mid;
            
            if(nums[mid] > target)end = mid-1;
            else start=mid+1;
        }
        
        return -1;
        
    }
}