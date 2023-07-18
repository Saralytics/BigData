import java.util.Queue;
import java.util.LinkedList;

public class Queue1 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>(); // 
		
		for(int i = 0; i<5; i++) {
			q.add(i);
		}
		System.out.println("Elements of queue are" + q);
		
		q.remove(5);
		System.out.println(q);
		
		int head = q.peek();
		System.out.println("The head is " + head);
		
		int size = q.size();
		System.out.println("The size of the queue is "+size);

	}

}
