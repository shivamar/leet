
public class MoveZeroes {
	
	//best solution . O(n) - 2n
	 public static void moveZeroes2(int[] nums) {
	        int zeroCnt = 0,len = nums.length-1;
	        for(int i=0;i < nums.length ; i++){
	        	if(nums[i] == 0) zeroCnt++;
	        	else
	        	nums[i-zeroCnt] = nums[i];
	        }
	        
	        while(zeroCnt > 0){
	        	nums[len]=0;
	        	len--;
	        	zeroCnt--;
	        }
	        
	    }

	  public static void moveZeroes(int[] nums) {
	        int firstZeroIndex = 0;
	        for(int i=0;i < nums.length ; i++){
	                
	                if(nums[i] == 0) {
	                    firstZeroIndex = i;
	                    nums = swapNonZero(nums,firstZeroIndex);
	                }
	        }
	        
	    }
	    
	    public static int[] swapNonZero(int[] arr, int firstZeroIndex){
	        for(int i=firstZeroIndex;i < arr.length ;i++){
	            if(arr[i] != 0){
	                swap(arr,i,firstZeroIndex);
	                return arr;
	            }
	            	            
	        }
	        
	        return arr;	        
	    }
	    public static void swap(int[] arr,int l,int r){
	        int temp = arr[l];
	        arr[l] = arr[r];
	        arr[r] = temp;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {0,1,0,3,12};
    	
		moveZeroes2(arr);
    	
    	for(int a: arr)
    		System.out.println(a);

	}

}
