import java.util.*;


public class RemoveDuplicates {
    /*
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
    */
	
	public int removeDuplicates(int[] nums) {
	    int index=0;
	   
	    for(int j=1;j<nums.length;j++){
	       if(nums[j] != nums[j-1])
	        nums[++index]=nums[j];
	    }
	   
	    return index+1;
	   }
	
    public int removeDuplicates_1(int[] nums) {
        int i=0,j=0;
        boolean hasDuplicate = false;        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int a : nums){
            if(!set.contains(a))
                set.add(a);
        }
        
        for(i=0;i<nums.length-1 && j < nums.length;i++)
        {
            if(!hasDuplicate){
            if(nums[i]==nums[i+1]){
                hasDuplicate = true;
                j=i+1;
            }
            }
            else{
                while(j < nums.length && nums[j] == nums[j-1])j++;
                
                if(j > nums.length-1) break;                
                nums = swap(nums,i,j);            
                j++;                
            }
        }
        
        return set.size();
    }
    
    public void print(int[] nums){
         System.out.println("array printing");
        for (int  a : nums)
            System.out.println(a);
    }
    
    public void print(int a){
         System.out.println("---------");
        System.out.print(a);
         System.out.println("a---------");
    }
    
    //check return 
    public int[] swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        //nums[j] = temp;
        
        return nums;
    }
}