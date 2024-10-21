import java.util.*;
import java.io.*;


class Node<T>{
	T value;
	Node<T> next;
	public Node(T value){
		this.value = value;
		next = null;
	}
}

class _Queue<T>{
	Node<T> front;
	Node<T> back;
	int size;
	
	public _Queue(){
		front = null;
		back = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		if(front == null && back == null) return true;
		
		return false;
	}
	
	public T pop() {
		if(isEmpty()) return null; 
		
		Node<T> node = front;
		T result = node.value;
		front = node.next;
		
		if(front==null) back = null;
		
		size--;
		return result;
	}
	
	public void push(T entry){
		if(isEmpty()) {
			front = new Node<T>(entry);
			back = front;
		}
		else {
			back.next = new Node<T>(entry);
			back=back.next;
		}
		size++;
		
	}
	
}

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		_Queue<String> q= new _Queue<>();
		
		for(int i=0;i<N;i++) {
			String[] command = br.readLine().split(" ");
			
			switch(command[0]) {
			case "push":
				q.push(command[1]);
				break;
			case "pop":
				System.out.println((q.isEmpty())?-1:q.pop());
				break;
			case "empty":
				System.out.println(q.isEmpty()?1:0);
				break;
			case "front":
				System.out.println((q.isEmpty())?-1:q.front.value);
				break;
			case "back":
				System.out.println((q.isEmpty())?-1:q.back.value);
				break;
			case "size":
				System.out.println(q.size);
			default:
				break;
			}
		
		}
		
	}
}

