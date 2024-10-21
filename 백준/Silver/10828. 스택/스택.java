import java.util.*;
import java.io.*;

class Node<T>{
	T value;
	Node<T> next;
	
	public Node(T value) {
		this.value = value;
		next = null;
	}
}

class _Queue<T>{
	Node<T> front, back;
	int size = 0;
	
	public _Queue(){
		front = null;
		back = null;
	}
	
	public boolean isEmpty() {
		if(front ==null && back == null) return true;
		else return false;
	}
	
	public T poll() {
		if(isEmpty()) return null;
		
		Node<T> node = back;
		T result = node.value;
		back = back.next;
		if(back==null) front = null;
		
		size--;
		return result;
	}
	
	public void add(T value) {
		Node<T> node = new Node<>(value);
		
		if(isEmpty()) {
			front = node;
			back = node;
		}
		else {
			front.next = node;
			front = node;
		}
		size++;
	}
	
}

class _Stack<T>{
	Node<T> head;
	int size = 0;
	
	public _Stack() {
		head = null;
	}
	
	public boolean isEmpty() {
		return (head==null?true:false);
	}
	
	public void push(T value){
		Node<T> node = new Node<>(value);
		if(isEmpty()) head = node;
		else {
			node.next = head;
			head = node;
		}
		
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		
		Node<T> node = head;
		head = node.next;
		size--;
		return node.value;
	}
	
}


public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		_Stack<String> s= new _Stack<>();
		
		for(int i=0;i<N;i++) {
			String[] command = br.readLine().split(" ");
			
			switch(command[0]) {
			case "push":
				s.push(command[1]);
				break;
			case "pop":
				System.out.println((s.isEmpty())?-1:s.pop());
				break;
			case "empty":
				System.out.println(s.isEmpty()?1:0);
				break;
			case "top":
				System.out.println((s.isEmpty())?-1:s.head.value);
				break;
			case "size":
				System.out.println(s.size);
			default:
				break;
			}
		
		}
		
	}
}