public class Rotate {    
    //O(n)
    public void rotate(int[] nums, int k) {
        if(nums.length < 2) return;
        
        if(k > nums.length-1) k = k % nums.length;
        
        if(k==0) return;
        //create a temp store of k array
        int[] temp = new int[k];
        int i=k;
        //fill up temp of last k arr from original array
        while(i > 0 ){
            temp[k-i]=nums[nums.length-i]; 
            i--;
        }
        //replace last k spots of original array with i-k elements' value
        for(i=nums.length-1;i >= k; i--)
        {
            nums[i]=nums[i-k];
        }
        
        //fill up the first k spots of original array with temp array's forst k spots
        i=0;
        while(i < k)
        {
            nums[i]=temp[i];
            i++;
        }
        
    }
}