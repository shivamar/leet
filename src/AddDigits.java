public class AddDigits {
	//39 = 3+9=12 = 1+2 =3
    public int addDigits(int num) {
        if(num < 10) return num;
        
        int s=0;
        
        while(!(num / 10 == 0 && num % 10 == 0))
        {
            s += num % 10;
            num = num/10;
        }
        
        if(s < 10) return s;
        else return addDigits(s);
        
    }
    
    public static void main(String[] args)
    {
    	System.out.println(123);
    }
}