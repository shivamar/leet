import java.util.*;


public class LRU {
	Queue<Integer> q;
	HashMap<Integer, Integer> cache;
	
	int capacity;
	
	public LRU(int cap) {
		cache = new HashMap<Integer, Integer>();
		q = new LinkedList<Integer>();
		capacity = cap;
	}
	
	//if cap is not reached, insert it in hash map.
	//if cap is reached remove the key in the queue and remove it in hash map
	//before inserting new key value pair
	public void set(int key, int val)
	{
		if(cache.size() >= capacity) {
			int elem = q.peek();
			cache.remove(elem);
			q.poll();
			
//			for(Iterator itr = q.iterator();itr.next() != null;){
//				int el = (int) itr.next();				
//				if(el == elem) q.remove(el);			
//			}						
			
		}
		
//		else {
			cache.put(key, val);
			if(q.contains(key)) q.remove(key); 
			q.offer(key);
//		}
			
	}
													
	//get the value from hash map and add key to queue
	//if the capacity,  
	public int get(int key)
	{
		int res = cache.get(key) == null ? -1 : cache.get(key);
		
		if(res != -1) {
			if(q.contains(key)) q.remove(key); 
			q.offer(key);
		}
		
		return res;
	}
	
	public static void main(String[] args){
		LRU lru = new LRU(4);
		
		lru.set( 2,2 );
		lru.set( 1,1 );
		lru.set( 3,3 );
		lru.set( 4,4);
		lru.get(2);
		
		lru.set(5,5);
		lru.set(12,12);
		lru.set(13,13);
		lru.set(33,33);
		lru.set(44,44);
	
		System.out.println(lru.get(12)+lru.q.toString());
	}
}
