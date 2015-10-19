import java.util.Arrays;

public class MedianOf2SortedArrays {
    /*
     * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
     * 
     * learning link!
     * 
     * take the half of smaller array (depending on median - upper half or lower half)
     * remove same no of elements from bigger array at each step and repeat
     * till the base case is reached! --> where one array is 2 elements or less
     */
	private double findMedian(int[] nums1)
    {
        int len = nums1.length;

        if(len == 1) return nums1[0];
        if(len == 2) return (nums1[0]+nums1[1]) / 2.0;
        
        if(len % 2 == 0) return (nums1[(len/2)-1] + nums1[len/2]) / 2.0;
        else
        return nums1[len/2];
    }
    // two numbers num1 arra and even  num2 array => 6 subcases
    // 1,2 | 4,5,6,7 => both less than 5 and its prev no.4 so (4+5) / 2 is median
    //4,6 | 5,8,10,11 => both less than 8 but around its prev element 5 so (bigger than 5 elment. 6 + 8)/2
    // 4,9 | 5,8,10,11 => 4 less than 8 and 9 btw 8 and 10 so median is 9+10 / 2
    //
    // 1,2 | 4,5,6 
    //1,2 | 5,6 = > [ max(element1)+min(element2) ]/ 2
    // -2 -1 0 1 2 | 1 2 3 => 1,2 | 1 => answer 
    // 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1 > len2){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            
            len1 = nums1.length;
            len2 = nums2.length;
        }
        
        if(len1 <= 2 || len2 <= 2) {
         double res = baseCase(nums1,nums2);
         
         if(res != -1) return res;
        }
        
        double median1 = findMedian(nums1);
        double median2 = findMedian(nums2);
        
        
        if(median1 == median2) return median1;
        
        else if(median1 > median2){
        	nums1 = Arrays.copyOfRange(nums1, 0, len1/2 + 1);
        	int diff = len1 - (len1/2 + 1);
        	nums2 = Arrays.copyOfRange(nums2, diff, len2);
            return findMedianSortedArrays(nums1, nums2);
        }
        
        else{
        	nums1 = Arrays.copyOfRange(nums1, len1 % 2 == 1 ? len1/2 : len1/2 - 1 , len1);
        	int diff = len1 - len1/2 - 1;
        	nums2 = Arrays.copyOfRange(nums2, 0, len2 - diff);
            return findMedianSortedArrays(nums1,nums2);
        }
    }
    
    private double baseCase(int[] nums1, int[] nums2)
    {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double ans = -1;
        double deno = 2;
        
        if(len1 == 0) return findMedian(nums2);
        
        if(len1 == 2 && len2 == 2){
            return (Math.max(nums1[0], nums2[0]) + Math.min(nums1[1] ,nums2[1]))/deno;
        }
        else if(len1 == 2 && len2 > 2 && len2 % 2 == 0){
            //choose middle 4 elements of bigger array and the another array in full to decide btw the six elements
            int right1 = nums2[len2/2 - 2];
            int right2 = nums2[len2/2 - 1];
            int right3 = nums2[len2/2];
            int right4 = nums2[len2/2+1];
            
            int left1 = nums1[0];
            int left2 = nums1[1];
            
            if(left1 <= right2 && left2 >= right3 ) return (right2 + right3) /deno;
            else if(left2 <= right2) return (right2+Math.max(right1,left2))/deno;
            else if(left1 >= right3) return (right3 +Math.min(right4,left1))/deno;
            else return (Math.max(left1, right2)+Math.min(left2, right3))/deno;
        }
        else if(len1 == 2 && len2 > 2 && len2 % 2 == 1){
            int left1 = nums1[0];
            int left2 = nums1[1];
            
            int right1 = nums2[len2/2-1];
            int right2 = nums2[len2/2];
            int right3 = nums2[len2/2+1];
            
            if(left1 <= right2 && left2 >= right2) return right2;
            else if(left2 <= right2) return Math.max(Math.max(right1,left2), left1);
            else if(left1 >= right2) return Math.min(Math.min(left1,left2),right3);
        }
       else if(len1 == 1 && len2 ==1){
           return (nums1[0]+nums2[0]) / 2.0;
       }
       else if(len1 == 1 && len2 == 2){
            if(nums1[0] <= nums2[0]) return nums2[0];
            else if(nums1[0] >= nums2[1]) return nums2[1];
            else return nums1[0];
       }
       else if(len1 == 1 && len2 % 2  == 0){
            int right1 = nums2[len2/2 - 2];
            int right2 = nums2[len2/2 - 1];
            int right3 = nums2[len2/2];
            int right4 = nums2[len2/2 + 1];
            
            int left1 = nums1[0];
            
            if(left1 > right2 && left1 < right3) return left1;
            else if(left1 <= right2) return Math.max(left1, right2);
            else if(left1 >= right3) return Math.min(right3, left1); 
       }
       else if(len1 == 1 && len2 % 2 == 1){
            int left1 = nums1[0];
            
            int right1 = nums2[len2/2-1];
            int right2 = nums2[len2/2];
            int right3 = nums2[len2/2+1];   
            
            if(left1 == right2) return (left1 + right2)/ 2.0;
            else if(left1 > right2) return (right2 + Math.min(left1, right3)) / deno;
            else if(left1 < right2) return (right2 + Math.max(left1, right1)) / deno;
       }
       
       return ans;
    }
    
     public static void main(String[] args){
     	MedianOf2SortedArrays s = new MedianOf2SortedArrays();
   
     	int[] num2 = {1,2};
     	int[] num1 = {3,4,5,6,7};
     	double a = s.findMedianSortedArrays(num1, num2);
     	System.out.println(a);
     }
             
}