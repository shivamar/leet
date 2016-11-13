import java.util.Arrays;
import java.util.Random;

class D1{
	public static void main(String[] args)
	{
		int[] num={1,2,3,4};
		Shuffle sF = new Shuffle(num);
		sF.reset();
		num=sF.shuffle();
		
		for(int i : num)
		  System.out.println(i);				
	}
}
public class Shuffle {
	
	
	public static void main(String[] args)
	{
		D1.main(null);				
	}
	
	    int[] numbers;    
	    public Shuffle(int[] nums) {
	        numbers = nums;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return numbers;    
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        int[] shuffled = Arrays.copyOf(numbers, numbers.length);
	        
	        for(int i=0; i < shuffled.length; i++)
	        {
	          //  System.out.println((int)(Math.random() * shuffled.length));
	            //int randomNum = (int)(Math.random() * shuffled.length);
	            Random r = new Random();
	            int randomNum =r.nextInt(i+1);
	            swap(shuffled, i, randomNum);
	        }
	        
	        return shuffled;
	    }
	    
	    private void swap(int[] arr, int i, int j)
	    {
	        int t=arr[i];
	        arr[i]=arr[j];
	        arr[j]=t;
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
