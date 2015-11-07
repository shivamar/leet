import java.util.Iterator;
import java.util.TreeMap;

public class IntTORoman {

    public static TreeMap<Integer,String> populate(TreeMap<Integer,String> table){
        table.put(1,"I");
        table.put(5,"V");
        table.put(10,"X");
        table.put(50,"L");
        table.put(100,"C");
        table.put(500,"D");
        table.put(1000,"M");
        
        return table;
    }
    
    public String getNum(int num, TreeMap<Integer,String> table){
        if(table.containsKey(num)) return table.get(num);
        else{        	
        	if(num > 1000) return calculate(1000,3999,num, table);        		        	
            
        	Iterator<Integer> itr = table.keySet().iterator();
            Integer bottom = itr.next();
            
            while(itr.hasNext()){
            	int up = itr.next();
            	if(num > bottom && num < up) return calculate(bottom,up,num, table);            		 
            	else bottom = up;
            }            
            return "";
        }
    }
    
    private String calculate(int bottom, int up,int num, TreeMap<Integer,String> table) {
    	String ans = "";
    	boolean fiveBase = false;
    	int num1 = bottom;
    	while(num1 > 9){
    	    num1 /= 10;
    	}
    	if(num1 == 5) fiveBase = true;
    
       // System.out.println(up +" "+ num+" "+bottom); //test
       
        int subLowKey = bottom;
        if(fiveBase) {
            subLowKey = table.lowerKey(bottom);
        }
    	if(num == (up - subLowKey) && up != 3999){
    	    if(!fiveBase) return table.get(bottom)+table.get(up);
    	     else return table.get(subLowKey)+table.get(up);
    	}
        	
    	if(!fiveBase){
    		int div = num / bottom;
    		while(div > 0){    			
    			div--;
    			ans += table.get(bottom);
    		}
    	}
    	else{
    	    ans = table.get(bottom);
    	    int subBottom = table.lowerKey(bottom);
    	    
    	    int sub = (num - bottom) / subBottom;
    	    while(sub > 0){
    	            sub--;
    	            ans+=table.get(subBottom);
    	    }
    	}
    	
		return ans;
	}

	public String intToRoman(int num) {
	    TreeMap<Integer,String> table = new TreeMap<Integer,String>();
	    table = populate(table);
        
        int count = 1;
        String ans = ""; 
        
        while(num > 0){
            count = count * 10;
            int rem = num % 10;
            num = num / 10;
            if(rem != 0) ans = getNum(rem*(count/10), table) + ans;    
        }
        
        return ans;
    }
}