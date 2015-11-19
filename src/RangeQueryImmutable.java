
public class RangeQueryImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,-5,0,1,3,5,8};
		
		NumArray numArr = new NumArray(nums);
		int i = numArr.sumRange(1, 3);
		
		assert(i==-4);
	}

}

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.
 */
class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = nums;
        
        for(int j=0;j < sum.length;j++)
        {
            sum[j] = (j==0) ? sum[j]: sum[j]+sum[j-1];  
        }
    }

    public int sumRange(int i, int j) {
       return (i==0) ?  sum[j] : sum[j]-sum[i-1]; 
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);