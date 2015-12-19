/**
 * 
 */
package lruCache;

import java.util.HashMap;

/**
 * @author laxmikant
 *
 */
public class LRUCache {

	/**
	 * @param args
	 * 
	 * 
	 * contains a HashMap which has a key as Integer and Value as the Node in the Doubly LinkedList.
	 * 
	 * 
	 */
	
	
	int capacity;   //size of the Cache
	HashMap<Integer, Node> map=new HashMap<Integer, Node>();  //hashmap
	
	Node front=null;
	Node end=null;
	
	
	LRUCache(int size)
	{
		this.capacity=size;
	}
	
	
	public int read(int value)
	{	
		if(map.containsKey(value))
		{	
			Node n = map.get(value);
			remove(n);
			setFront(n);
			return value;
		}
			
		return Integer.MIN_VALUE;
		
	}
	
	
	public void put(int value)
	{	
		//System.out.print("\nsize"+map.size());
		if(map.size()<capacity)  // if queue is  not FULL yet
		{	
			
			Node n=new Node(value);
			setFront(n);
			map.put(value, n);
			
		}
		else    				// if Queue is FULL
		{
			map.remove(end.data);  //remove from map;
			remove(end);  //remove end
			Node n=new Node(value);
			setFront(n);
			map.put(value, n);
			
		}
		
	}
	


	public void remove(Node n) {
		// TODO Auto-generated method stub
		
		if(n.prev!=null)
		{
			n.prev.next=n.next;
		}
		else
		{
			front=n.next;
			front.prev=null;
		}
		
		if(n.next!=null)
		{
			n.next.prev=n.prev;
		}
		else
		{
			end=n.prev;
			end.next=null;
		}
		
		
	}
	
	
	public void setFront(Node n)
	{
		n.prev=null;
		n.next=null;
		
		if(front == null) // no node in Queue
		{
			front=n;
		}
		else
		{
			n.next=front;
			front.prev=n;
			front=n;
		}
		
		if(end == null)   //if no node in queue
		{
			end=front;
		}
		
		return ;
		
	}
	
	
	void displayQueue()
	{
		
		Node temp=front;
		System.out.print("\nQueue:  ");
		while(temp!=null)
		{
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
