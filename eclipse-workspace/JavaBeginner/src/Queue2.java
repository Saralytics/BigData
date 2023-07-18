import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Queue2 {

	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<>(); // PriorityQueue implements the Queue interface
		
		q.add("Taobao");
		q.add("Tao");
		q.add("Bao");
		
		Iterator i = q.iterator();
		while (i.hasNext())
			System.out.println(i.next());

	}

}
