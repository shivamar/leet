class Solution {
	/*
        Given a sorted array of integers, find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4]
	 */
	public int[] searchRange(int[] nums, int target) {
		int start = 0;
		int end = nums.length -1;
		int mid = 0;
		int[] arr = new int[2];
		arr[0]=-1;arr[1]=-1;
		while(start <= end )
		{
			mid = (start + end)/2;

			if(nums[mid] == target) arr = getRange(nums, mid);

			if(nums[mid] < target) {
				start = mid+1;
			}else{
				end = mid-1;
			}
		}

		return arr;
	}

	public int[] getRange(int[] nums, int mid)
	{
		int element = nums[mid];
		int start = mid,end = mid;

		while(start >= 0){
			if(start-1 >= 0 && nums[start-1] == element) start = start - 1;
			else break;
		}

		while(end <= nums.length-1){
			if(end+1 <= nums.length-1 && nums[end+1] == element) end = end + 1;
			else break;
		}

		int[] arr = new int[2];
		arr[0] = start;
		arr[1] = end;

		return arr;
	}
}
