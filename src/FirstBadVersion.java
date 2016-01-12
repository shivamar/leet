/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//TEST method
class VersionControl {	
	int breakingPt = 7;
	public boolean isBadVersion(int i){
		return i >= 7;
	}
	
}
public class FirstBadVersion extends VersionControl {
/*
 You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API. 
*/
    
    public int firstBadVersion(int n) {
        int start=1,end = n;
        int mid = 1;
        
        while(end >= start)
        {
            mid = start + (end - start) / 2;
            
            if(isBadVersion(mid))
            {
                if(mid-1 >= 1) {
                    if(!isBadVersion(mid-1)) return mid;
                    else{
                        end = mid-1;
                    }
                }
                else return mid;
            }
            else
            {
                start=mid+1;
            }
        }
            
        return -1;
    }
}