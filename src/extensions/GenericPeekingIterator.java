package extensions;
import java.util.Iterator;


public class GenericPeekingIterator<E> implements Iterator<E> {
    Iterator<E> itr;
    E var = null;
    boolean isThr = false,peeked = false;
	public GenericPeekingIterator(Iterator<E> iterator) {
	    // initialize any member here.
	    itr = iterator;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public E peek() {
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
	public E next() {
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
