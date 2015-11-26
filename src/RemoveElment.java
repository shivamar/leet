/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class RemoveElment {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length == 0) return 0;
        int[] arr = nums;
        
        int len=nums.length,count=0, notEl = findNextNonEl(arr,len-1,val),tmp=0;
        for(int r = len-1;r>=0;r--)
        {
            if(arr[r] == val){
                count++;
                
            if(r < notEl){
                swap(arr,r,notEl);
                tmp = notEl;
                notEl = findNextNonEl(arr, notEl, val);
                if(notEl==0) return  len-count-r;
            }
            
            }
        }
        
        return len-count;
    }
    
    private int findNextNonEl(int[] arr,int curr, int element)
    {
        if(arr[curr] != element){
            return curr;
        }
        
        for(int i=curr; i >=0;i--)
        {
            if(arr[i]!=element) return i;
        }
        
        return curr;
    }
    
    private void swap(int[] arr,int t,int a){
        int temp = arr[t];
        arr[t]=arr[a];
        arr[a]=temp;
    }
}