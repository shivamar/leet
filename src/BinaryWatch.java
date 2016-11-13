//https://leetcode.com/contest/5/problems/binary-watch/

/*
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class BinaryWatch {
/*
 * public class Solution {
    public List<String> readBinaryWatch(int num) {
        
        int num4Hours, num4Mins;
        List<String> listTime = new ArrayList<String>();
        for(int i=0; i <= num; i ++)
        {
             num4Hours=i;
             num4Mins=num-i;
             
            List<String> listHours = getCombinationHours(num4Hours);
            List<String> listMins = getCombinationMins(num4Mins);
            
            List<String> tempListTime=append(listHours, listMins);
            listTime.addAll(tempListTime);
        }
        
        return listTime;
    }
}
 */
}
