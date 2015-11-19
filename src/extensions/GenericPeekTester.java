package extensions;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericPeekTester{
	
	public static void main(String[] args){
		ArrayList<Integer> intarr = new ArrayList<Integer>();
		
		int[] arr = {1,2,3,4,5,6};
		
		for(Integer a : arr)
			intarr.add(a);
		
		Iterator<Integer> itr = intarr.iterator();
		GenericPeekingIterator<Integer> pk = new GenericPeekingIterator<>(itr);
		print(pk.next());
		print(pk.peek());
		print(pk.next());
		print(pk.next());
		print(pk.next());
		print(pk.peek());
		print(pk.peek());
		
	}
	
	public static void print(int a){
		System.out.println(a);
	}
}
