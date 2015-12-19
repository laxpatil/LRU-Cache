/**
 * 
 */
package lruCache;

/**
 * @author laxmikant
 *
 */
public class LRUOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LRUCache l= new LRUCache(5);
		
		l.put(1);
		l.displayQueue();
		l.put(2);
		l.displayQueue();
		l.put(1);
		l.displayQueue();
		l.put(4);
		l.displayQueue();
		//l.put(5);
		l.displayQueue();
		//l.put(6);
		l.displayQueue();
		//l.put(7);
		l.displayQueue();
		int k=l.read(1);
		System.out.println("\n\nRead from Cache: "+k);
		l.displayQueue();
		k=l.read(4);
		System.out.println("\n\nRead from Cache: "+k);
		l.displayQueue();
		
		
		
		
	}

}
