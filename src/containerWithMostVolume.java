public class containerWithMostVolume {
	
	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
	 */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1, max = 0, temp = 0;
        
        while(r > l)
        {
            temp = (r - l) * Math.min(height[r], height[l]);
            if(temp > max) max = temp;
            
            if(height[l] == height[r]) {
                l++;
                r--;
            }
            else if(height[l] > height[r]) r --;
            else l++;
        }
        
        return max;
    }
}
