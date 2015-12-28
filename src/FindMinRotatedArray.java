public class FindMinRotatedArray {
    /*
    Find Minimum in Rotated Sorted Array My Submissions Question
Total Accepted: 72690 Total Submissions: 209062 Difficulty: Medium
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
    */
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start=0,end=nums.length-1,mid=0;
        //find the element in middle and if not the correct ans, goo towards the side which is decreasing
        //for correct ans, both the neifghbours are big
        while(end >= start){
            mid = (end+start) / 2;
            
           if(mid != 0 && mid+1 < nums.length ) if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid + 1]) return nums[mid];
            
            if(nums[start] <= nums[mid] && nums[mid] <= nums[end]) return nums[start];
            
            if(nums[mid] >= nums[start] && nums[mid] >= nums[end]){
                start = mid+1;
            }
            else if(nums[start] >= nums[mid]){
                end  = mid-1;
            }
            
        }
        
        return nums[0];
    }
}