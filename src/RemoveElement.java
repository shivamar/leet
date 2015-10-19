import java.util.Arrays;


public class RemoveElement {

	public RemoveElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] t  = new int[2];
		
		t[0] = 4;
		t[1] = 5;
		
		System.out.println(removeElement(t,4));

	}
	
	    public static int removeElement(int[] nums, int val) {
	        int count = 0;
	        for(int i=0;i<nums.length;i++)
	        {
	            if(nums[i] == val){
	                //swap postion at count and present position of i
	                int temp = nums[count];
	                nums[count] = nums[i];
	                nums[i] = temp;
	                
	                count++;
	            }
	        }
	        int len = nums.length;
	       
	       if(len == count) {
	           nums = null;
	            return 0;   
	       }
	       else nums = Arrays.copyOfRange(nums,count,len);
	       
	       for(int i : nums)
	    	   System.out.println(i);
	       
	        return len - count;
	    }

}
