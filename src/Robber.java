public class Robber {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
    */
    public int rob(int[] nums) {
        int odd = 0,even = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0) {
                even+=nums[i];
                even = Math.max(odd,even);
            }
            else{
              odd+=nums[i];  
              odd = Math.max(odd,even);
            } 
        }
        
        return Math.max(odd,even);
    }
}