import java.util.ArrayList;
import java.util.Iterator;


public class Peek{
	
	public static void main(String[] args){
		ArrayList<Integer> intarr = new ArrayList<Integer>();
		
		int[] arr = {1,2,3,4,5,6};
		
		for(Integer a : arr)
			intarr.add(a);
		
		Iterator<Integer> itr = intarr.iterator();
		PeekingIterator pk = new PeekingIterator(itr);
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
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer var = null;
    boolean isThr = false,peeked = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(peeked) return var;
		
        if(itr.hasNext()){
            peeked =true;
            var = itr.next();
        }
        else{
            var = null;
            peeked = false;
        } 
        
        return var;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peeked){
	        peeked = false;
	        return var;
	    }
	    else {
	        return itr.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if(peeked)
	        return true;
	    else
	        return itr.hasNext();
	}
}
